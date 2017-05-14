package java112.project4;


import java.io.*;
import java.util.*;

import java112.analyzer.AnalyzeFile;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * Uses the uploaded bigFile and keywords file to run the analyzer program.
 *
 *@author  Thomas Hawkins
 */
@WebServlet(
name = "runAnalyzer",
urlPatterns = {"/run-analyzer"}
) public class RunAnalyzer extends HttpServlet {

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

        String[] arguments = new String [2];

        arguments[0] = "/tmp/bigFile.txt";
        arguments[1] = "/webanalyzer.properties";

        AnalyzeFile analyzer = new AnalyzeFile();
        analyzer.runAnalysis(arguments);

        String urlForward = "/analyzerResults.jsp";
        RequestDispatcher dispatcher
        = getServletContext().getRequestDispatcher(urlForward);
        dispatcher.forward(request, response);
    }


    /**
     *  Init method loading the properties and employee directory into the servlet
     * context for use across all servlets.
     *@exception  ServletException  if there is a general
     *                              servlet exception
     */
    public void init() throws ServletException {
        loadProperties("/webanalyzer.properties");
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
