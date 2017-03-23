package java112.project2;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(
    name = "First112Servlet", 
    urlPatterns = { "/FirstServlet", "/112Servlet" }
)
public class First112Servlet extends HttpServlet {
    
     /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>First 112 Servlet</TITLE>");
        out.print("</HEAD>");
        out.print("<HEADER>");
        out.print("<h1>First Servlet!</h1>");
        out.print("</HEADER>");
        out.print("<BODY>");
        out.print("<h3>Name:Thomas Hawkins Class:Advanced Java 112</h3>");
        out.print("<a href='/java112'><img src='/java112/images/sql-santa.jpeg' title='Home' alt='image' ></a>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
        
    }

}