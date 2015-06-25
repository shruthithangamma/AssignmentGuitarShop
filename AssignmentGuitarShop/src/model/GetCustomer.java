package model;

import java.io.IOException;
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
 * Servlet implementation class GetCustomer
 */
@WebServlet("/GetCustomer")
public class GetCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCustomer() {
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
		
		String tableInfo = "";
		String custInformation = "";
		List<Customer> customers = getCustomerdetails();
		Iterator<Customer> iterator = customers.iterator();
		try{
			
			tableInfo += "<tr><th>Customer ID</th><th>Customer Name</th><th>Email</th><th></th></tr>";
		while(iterator.hasNext())
		{
			Customer cust = (Customer)iterator.next();
			//System.out.println(cust.getCustFirstName());
				
						
			tableInfo += "<tr><td>"+ cust.getCustomerId()  +"</td><td><a href='CustomerDetails?customerid=" + cust.getCustomerId() + "'>" + cust.getFirstName() +"</a></td><td>"+cust.getEmailAddress()+"</td></tr>";
		
		
		
		}
		
		request.setAttribute("tableInfo", tableInfo);
	
		}
		
		catch (Exception e){

		request.setAttribute("message", "<div class='alert alert-danger' role='alert'>Error! Danger Will Robinson Danger! " + e + "</div>");
	}
		getServletContext().getRequestDispatcher("/customers.jsp").forward(request, response);
	}
		
	public static List<Customer> getCustomerdetails(){
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "SELECT d from Customer d";
			TypedQuery<Customer> q = em.createQuery(qString, Customer.class);
			List<Customer> customers;
			try{
				customers = q.getResultList();
				if(customers == null || customers.isEmpty())
					customers = null;
				
			}/*catch(Exception e){
				System.out.println(e);
			}*/finally{
				em.close();
			}
					return customers;
		}
	

	}


