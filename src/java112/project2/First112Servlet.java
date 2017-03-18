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
    
    private Properties properties;
    
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
        out.print("<link rel='stylesheet' type='text/css' href='css/style.css' />");
        out.print("<script type='text/javascript' src='js/modernizr-1.5.min.js'></script>");
        out.print("</HEAD>");
        out.print("<HEADER><NAV><DIV id='menubar'><ul id='nav'>");
        out.print("<li><a href='/java112'>Home</a></li>");
        out.print("<li class='current'><a href=''>Project 2 Servlet</a></li>");
        out.print("</HEADER></NAV></DIV></ul>");
        out.print("<BODY>");
        out.print("<h1>Project 2 Servlet!</h1>");
        out.print("<table><tr><th>Author</th><th>Email</th><th>Course Name</th>");
        out.print("<th>Course Time</th><th>Professor</th><th>Course Description</th></tr>");
        out.print("<tr><td>" + properties.getProperty("author") + "</td>");
        out.print("<td>" + properties.getProperty("email") + "</td>");
        out.print("<td>" + properties.getProperty("course.title") + "</td>");
        out.print("<td>" + properties.getProperty("course.time") + "</td>");
        out.print("<td>" + properties.getProperty("instructor") + "</td>");
        out.print("<td>" + properties.getProperty("project.description") + "</td>");
        out.print("</tr></table>");
        out.print("<a href='/java112'><img src='/public_html/images/sql-santa.jpeg' alt='image' ></a>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
        
    }
    
    public void init(ServletConfig config) throws ServletException {
        loadProperties("/project2.properties");
    }
    
    public void loadProperties(String propertiesFilePath)  {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch(IOException ioException) {
            ioException.printStackTrace();
        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }

}