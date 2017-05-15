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
    name = "uploadFile", 
    urlPatterns = { "/upload-file" }
)
 
public class UploadFile extends HttpServlet {
 
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
 
        String urlForward = "/uploadFile.jsp";
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(urlForward);
        dispatcher.forward(request, response);
    }
 
}





