package java112.project4;
 
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
 
/**
 *  Class routes to new employee form.
 *
 *@author    Thomas Hawkins
 */
@WebServlet(
    name = "addEmployee", 
    urlPatterns = { "/add-employee" }
) public class AddEmployeePage extends HttpServlet {
 
    /**
     *  Handles HTTP GET requests.
     Sends us to the add new employee jsp form.
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
 
        String urlForward = "/addEmployee.jsp";
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(urlForward);
        dispatcher.forward(request, response);
    }
 
}





