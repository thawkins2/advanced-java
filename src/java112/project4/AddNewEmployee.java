package java112.project4;


import java.io.*;
import java.util.*;

import java112.employee.EmployeeDirectory;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 *  Grabs employee directory from servlet context. Recieved post data from add
 * employee jsp form. Routes data to emplyee directory and adds a new employee record.
 *
 *@author    Thomas Hawkins
 */
@WebServlet(
name = "addNewEmployee",
urlPatterns = {"/add-new-employee"}
) public class AddNewEmployee extends HttpServlet {

    /**
     *  Handles HTTP POST requests.
     * Grabs post form data and sends it to employee directory for processing a new
     * employee query. Returns success session attribute if query is successful. JSP
     * page clears attribute on reload so success message does not stick around.
     *
     *@param  request               the HttpRequest
     *@param  response              the HttpResponse
     *@exception  ServletException  if there is a general
     *                              servlet exception
     *@exception  IOException       if there is a general
     *                              I/O exception
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = request.getSession();
        
        EmployeeDirectory addEmployee = (EmployeeDirectory)context.getAttribute("directory");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String socialSecurityNumber = request.getParameter("socialSecurityNumber");
        String department = request.getParameter("department");
        String roomNumber = request.getParameter("roomNumber");
        String phoneNumber = request.getParameter("phoneNumber");

        int result = addEmployee.addEmployeeRecord(firstName, lastName, socialSecurityNumber,
        department, roomNumber, phoneNumber);

        if (result > 0) {
            session.setAttribute("success", "Employee added to the database.");
        } else {
            session.setAttribute("success", "Error adding employee to database.");
        }
        
        String url = "/java112/addEmployee.jsp";
        response.sendRedirect(url);
    }
}
