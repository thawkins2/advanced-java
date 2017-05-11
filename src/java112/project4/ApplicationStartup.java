package java112.project4;


import java.io.*;
import java.util.*;

import java112.employee.EmployeeDirectory;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * Servlet autoloads when tomcat starts, instantiating the properties, employee
 * directory, and sending them to the servlet context to be used by the whole project.
 *@author    Thomas Hawkins
 */
@WebServlet(
name = "applicationStartup",
urlPatterns = {"/project4-startup"},
loadOnStartup = 1
) public class ApplicationStartup extends HttpServlet {

    private Properties properties;


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
    }


    /**
     *  Init method loading the properties and employee directory into the servlet
     * context for use across all servlets.
     *@exception  ServletException  if there is a general
     *                              servlet exception
     */
    public void init() throws ServletException {
        loadProperties("/project4.properties");
        EmployeeDirectory employeeDirectory;

        ServletContext context = getServletContext();
        context.setAttribute("project4properties", properties);
        context.setAttribute("directory", employeeDirectory = new EmployeeDirectory(properties));
    }


    /**
     * Load properties file.
     * @param propertiesFilePath Properties file path for use.
     */
    public void loadProperties(String propertiesFilePath) {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
