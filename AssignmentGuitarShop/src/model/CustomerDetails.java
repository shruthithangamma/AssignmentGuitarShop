package model;

import java.lang.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tools.DBUtil;

/**
 * Servlet implementation class CustomerDetails
 */
@WebServlet("/CustomerDetails")
public class CustomerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
		
    String custId = request.getParameter("customerid");
    System.out.println(custId);
    
		String tableInfo = "";
		tableInfo += "<tr><th>Order ID</th><th>Order Date</th><th>Shipment Amount</th><th></th></tr>";
	    System.out.println(5);
		List<Order> ord = getCustomerdetails(custId);
		
		
		if(ord != null){
			
			try{
			    
				for(Order orders: ord){
					
			
						
			tableInfo += "<tr><td>"+ orders.getOrderId() +"</td><td>" + orders.getShipDate() +"</td><td>"+orders.getShipAmount()+"</td></tr>";
				}
		
		
		request.setAttribute("tableInfo", tableInfo);
	
		}
		
		catch (Exception e){

		request.setAttribute("message", "<div class='alert alert-danger' role='alert'>Error! Danger Will Robinson Danger! " + e + "</div>");
	}
	
	getServletContext().getRequestDispatcher("/orders.jsp").forward(request, response);
}
		else{
			
			tableInfo += "<tr><td>" +"null" +"</td><td>"+ "null" +"</td><td>"+"null"+"</td><tr>";
		}
		
		request.setAttribute("tableInfo", tableInfo);
		getServletContext().getRequestDispatcher("/orders.jsp").forward(request, response);
		
}
	public static List<Order> getCustomerdetails(String custId){
		   
			System.out.println(custId);
			EntityManager em = DBUtil.getEmFactory().createEntityManager();			
			String qString = "SELECT o FROM Order o where o.customer.customerId = :custId";
			
			TypedQuery<Order> q = em.createQuery(qString, Order.class);
			q.setParameter("custId", Long.parseLong(custId));
			List<Order> orders;
			try{
				orders = q.getResultList();
			
				if(orders == null || orders.isEmpty())
					orders = null;
				
			}/*catch(Exception e){
				System.out.println(e);
			}*/finally{
				em.close();
			}
			System.out.println(orders);
					return orders;
		}
	

		
}
