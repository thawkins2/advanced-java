package java112.project4;


import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 *  Class forwards us to employee search jsp page.
 *
 *@author    Thomas Hawkins
 */
@WebServlet(
name = "employeeSearch",
urlPatterns = {"/employee-search"}
) public class EmployeeSearchDisplay extends HttpServlet {

    /**
     *  Forwards to employee search jsp form.
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

        String urlForward = "/employeeSearch.jsp";
        RequestDispatcher dispatcher
        = getServletContext().getRequestDispatcher(urlForward);
        dispatcher.forward(request, response);
    }
}
