package java112.project3;


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
name = "project3properties",
urlPatterns = {"/properties-servlet"}
) public class PropertiesServlet extends HttpServlet {

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
        
        request.setAttribute("p3properties", properties);
        
        String urlForward = "/project3properties.jsp";
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(urlForward);
        dispatcher.forward(request, response);
    }


    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        loadProperties("/project3.properties");
    }


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
