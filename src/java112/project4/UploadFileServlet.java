package java112.project4;
 
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
 
/**
 *  
 *
 *@author Thomas Hawkins
 */
@WebServlet(
    name = "uploadFileServlet", 
    urlPatterns = { "/upload-file-servlet" }
)
@MultipartConfig(
    fileSizeThreshold=1024*1024, 
    maxFileSize=1024*1024*5,
    maxRequestSize=1024*1024*5*5)
public class UploadFileServlet extends HttpServlet {
    private final String UPLOAD_DIRECTORY = "/output";

    /**
     *  Handles HTTP POST requests.
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

        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                        new DiskFileItemFactory()).parseRequest(request);

                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                }
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }
        } else {
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}






