package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tools.DBUtil;

/**
 * Servlet implementation class insertCustomer
 */
@WebServlet("/insertCustomer")
public class insertCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertCustomer() {
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
	 * @param order_id 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String CustomerFirstName = request.getParameter("first_name");
		String CustomerLastName = request.getParameter("last_name");
		String CustomerEmailID = request.getParameter("email_address");
		String CustomerID 	   = request.getParameter("customer_id");
		String CustomerBillingAddressID = request.getParameter("billingaddressid");
		String CustomerPassword = request.getParameter("password");
		String CustomerShippingAddressID = request.getParameter("shippingaddressid");
		System.out.println("doPost retrieve parameters");
		System.out.println("CustomerBillingAddressID"+CustomerBillingAddressID);
		System.out.println("CustomerShippingAddressID"+CustomerShippingAddressID);
		
		 response.setContentType("text/html");  
		 model.Customer cust = new model.Customer();
          EntityManager em = DBUtil.getEmFactory().createEntityManager();   
           EntityTransaction trans = em.getTransaction();
           trans.begin();
           try
   		{
        	   
   			BigDecimal bdBillingAddress = new BigDecimal(CustomerBillingAddressID);
   			BigDecimal bdShippingAddress = new BigDecimal(CustomerShippingAddressID);
   			cust.setFirstName("CustomerFirstName");
   			cust.setLastName("CustomerLastName");
   			cust.setEmailAddress("CustomerEmailID");
   			cust.setCustomerId(Long.parseLong(CustomerID));
   			cust.setBillingAddressId(bdBillingAddress);
   			cust.setPassword("CustomerPassword");
   			cust.setShippingAddressId(bdShippingAddress);
   			
   			em.persist(cust);
   			System.out.println("persist");
   			trans.commit();
   		}catch(Exception e){
   			System.out.println("EXCEPTION");
   			System.out.println(e);
			//trans.rollback();
			
		}finally{
			em.close();
		} 
           //System.out.println("/GetCustomer");
           getServletContext().getRequestDispatcher("/addCustomer.jsp").forward(request, response);  
	}	
	         
	
	public static void getInsert(model.Customer cust){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try{
			
			em.persist(cust);
			trans.commit();
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			em.close();
		}
	} 
}

