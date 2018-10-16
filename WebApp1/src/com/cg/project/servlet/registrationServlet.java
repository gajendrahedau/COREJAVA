package com.cg.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.project.bean.Associate;


@WebServlet("/registration")
public class registrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  public registrationServlet() {
        super();
        
    }
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	int associateId=Integer.parseInt(request.getParameter("associateId"));
	String password=request.getParameter("password");
	String firstName=request.getParameter("firstName");
	String lastName=request.getParameter("lastName");
	String email=request.getParameter("email");
	String[] hobbies=request.getParameterValues("hobbies");
	String dateOfBirth=request.getParameter("date");

	Associate associate= new Associate(associateId, password, firstName, lastName, email, dateOfBirth, hobbies);
	RequestDispatcher dispatcher;
	
	dispatcher=request.getRequestDispatcher("registrationSuccessPage.jsp");
	request.setAttribute("associate",associate);
		dispatcher.forward(request, response);
	
	
	
	/*String firstName=request.getParameter("firstName");
	String lastName=request.getParameter("lastName");
	String userId=request.getParameter("userId");
	String password=request.getParameter("password");
	String email=request.getParameter("email");
	String[] hobbies=request.getParameterValues("hobbies");
	String dateOfBirth=request.getParameter("date");
	PrintWriter out=response.getWriter();
	out.println("<html><body><div align='center'><table>");
	out.println("<tr><td>First Name</td><td>"+firstName+"</td></tr>");
	out.println("<tr><td>Last Name</td><td>"+lastName+"</td></tr>");
	out.println("<tr><td>UserId</td><td>"+userId+"</td></tr>");
	out.println("<tr><td>Password</td><td>"+password+"</td></tr>");
	out.println("<tr><td>Email</td><td>"+email+"</td></tr>");
	out.println("<tr><td>Hobbies</td>");
	for (String str : hobbies) {
		out.println("<td>"+str+"</td></tr>");
	}
	out.println("<tr><td>Date</td><td>"+dateOfBirth+"</td></tr>");
	out.println("</table><div></body></html>");*/
	
	
}
/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.print("<html><body><form>");
		out.println("First name: <input type=text name=firstname required> <br><br>");
		out.println("Last name: <input type=text name=lastname required><br><br>");
		out.println("User Id: <input type=text name=userid placeholder=Create your user id required> <br><br>");
		out.println(" Password: <input type=password name=password placeholder=Enter Password pattern=(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,} title=Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more character required> <br><br> ");
		out.println(" Email: <input type=email name=email> <br><br> ");
		out.println("Submit: <input type=submit value=Submit /> <br><br> ");
		out.println(" Reset: <input type=reset value=Reset />");
		out.println("</form></body></html>");
}*/

}
