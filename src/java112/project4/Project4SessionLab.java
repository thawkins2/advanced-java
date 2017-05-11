package java112.project4;
 
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
 
/**
 *  
 *
 *@author    Thomas Hawkins
 */
@WebServlet(
    name = "SessionCounter", 
    urlPatterns = { "/session-counter" }
)
 
public class Project4SessionLab extends HttpServlet {
    
    private Integer sessionCounter;
 
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpRequest
     *@param  response              the HttpResponse
     *@exception  ServletException  if there is a general 
     *                              servlet exception
     *@exception  IOException       if there is a general 
     *                              I/O exception
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            
         HttpSession session = request.getSession();
         Integer       sessionAttribute  = 
                (Integer) session.getAttribute("project4SessionCounter");
                
         if (sessionAttribute == null || sessionAttribute.equals("")) {
             Integer initializeCounter = 1;
             sessionCounter = initializeCounter;
             session.setAttribute("project4SessionCounter", sessionCounter);
         } else {
             sessionCounter++;
             session.setAttribute("project4SessionCounter", sessionCounter);
         }
         
        String urlForward = "/project4session.jsp";
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(urlForward);
        dispatcher.forward(request, response);
    }
 
}





