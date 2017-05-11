package java112.project4;


import java.io.*;
import java.util.*;

import java112.employee.EmployeeDirectory;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 *  Receives data from employee search and routes data to the employee directory
 * for querying. Takes query results and forwards it to jsp for display.
 *
 *@author    Thomas Hawkins
 */
@WebServlet(
name = "searchResults",
urlPatterns = {"/search-results"}
) public class SearchResults extends HttpServlet {

    /**
     *  Gets employee directory from servlet context and places search data into
     * appropriate method call. Takes returned list and forwards response, based on
     * if data was sent back.
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

        ServletContext context = getServletContext();

        EmployeeDirectory employeeSearch = (EmployeeDirectory)context.getAttribute("directory");
        String searchTerm = request.getParameter("searchTerm");
        String searchType = request.getParameter("searchType");

        List<Object> searchResults = employeeSearch.searchEmployeeDatabase(searchTerm, searchType);
        int rows = searchResults.size();

        request.setAttribute("results", searchResults);
        request.setAttribute("rows", rows);

        if (rows > 0) {
            String urlForward = "/searchResults.jsp";
            RequestDispatcher dispatcher
            = getServletContext().getRequestDispatcher(urlForward);
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("noResults", "0 results found.");
            String urlForward = "/employeeSearch.jsp";
            RequestDispatcher dispatcher
            = getServletContext().getRequestDispatcher(urlForward);
            dispatcher.forward(request, response);
        }
    }
}
