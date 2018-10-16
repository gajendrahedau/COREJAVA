package com.cg.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.project.bean.Associate;


@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public loginServlet() {
        super();
       
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int associateId=Integer.parseInt(request.getParameter("associateId"));
		String password=request.getParameter("password");
		
		Associate associate=new Associate(associateId,password);
		RequestDispatcher dispatcher;
		if(associate.getAssociateId()==1111&&associate.getPassword().equals("apapap")){
			dispatcher=request.getRequestDispatcher("loginSuccessPage.jsp");
			request.setAttribute("associate", associate);
			dispatcher.forward(request, response);
		}
		else{
			dispatcher=request.getRequestDispatcher("loginErrorPage.jsp");
			request.setAttribute("errorMessage", "associateId or password is wrong");
			dispatcher.forward(request, response);
		}
		
		
		
		
		
		
		
		
		
		
		
		
	/*String associateId=request.getParameter("associateId");
	String password=request.getParameter("password");
	PrintWriter out=response.getWriter();
	out.println("<html><body><div align='center'>");
	if(associateId.equals("12345")&&password.equals("appu"))
		out.print("<font color='green'>Welcome associate"+associateId+"</font>");
	else
		out.print("<font color='red'>Wrong Credentials!!</font>");
	out.println("<div></body></html>");*/
		
	}
    
    

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.print("<html><body>");
		out.println("<form>User Id:");
		out.println("<input type=text name=userid placeholder=enter your user id required>");
		out.println("<br><br>Password:");
		out.println("<input type=password name=password placeholder=Enter Password pattern=(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8} required>");
		out.println("<br><br>Submit:");
		out.println("<input type=submit value=Submit />");
		out.println("<br><br>Reset:");
		out.println("<input type=reset value=Reset />");
		out.print("</form></body></html>");
		
	}

}
