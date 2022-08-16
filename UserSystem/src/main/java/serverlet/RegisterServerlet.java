package serverlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;

@WebServlet(urlPatterns = "/save")
public class RegisterServerlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Receive data from design page
		String userid = req.getParameter("userid");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String password = req.getParameter("password");
		
		PrintWriter out = resp.getWriter();
		//out.println("Userid: " + userid);
		
		//set All data to the User class object
		User user = new User();
		user.setUserid(userid);
		user.setName(name);
		user.setEmail(email);
		user.setAddress(address);
		user.setPassword(password);
		
		try 
		{
			int response = user.addUser();
			
			if(response == 1)
			{
				out.println("Registration Successfull");
			}
			else
			{
				out.println("Registration Failed");
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//call addUser function
		
		//System.out.println("Userid: " + userid);
		//Display Data in Browser
	    
		
	}
}