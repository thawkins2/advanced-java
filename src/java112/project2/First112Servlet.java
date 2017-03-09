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
        out.print("<HEAD><TITLE>Frist 112 Servlet</TITLE>");
        out.print("<link rel='stylesheet' type='text/css' href='css/style.css' />");
        out.print("<script type='text/javascript' src='js/modernizr-1.5.min.js'></script>");
        out.print("</HEAD>");
        out.print("<HEADER><NAV><DIV id='menubar'><ul id='nav'>");
        out.print("<li><a href='/java112'>Home</a></li>");
        out.print("<li class='current'><a href=''>Project 2 Servlet</a></li>");
        out.print("</HEADER></NAV></DIV></ul>");
        out.print("<BODY>");
        out.print("<h1>Project 2 Servlet!</h1>");
        System.out.println("Is this logging?");
        log("Is this logging?");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
        
    }


}