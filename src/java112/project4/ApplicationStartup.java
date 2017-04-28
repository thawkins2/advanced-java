package java112.project4;


import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 *
 *
 *@author    Thomas Hawkins
 */
@WebServlet(
    name = "applicationStartup", 
    urlPatterns = { "/project4-startup" },
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


    public void init() throws ServletException {
        loadProperties("/project4.properties");
        EmployeeDirectory employeeDirectory = new EmployeeDirectory(properties);
        
        ServletContext context = getServletContext();
        context.setAttribute("project4properties", properties);
        context.setAttribute("directory", employeeDirectory);
    }


    /**
     * Load properties
     * @param propertiesFilePath
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
