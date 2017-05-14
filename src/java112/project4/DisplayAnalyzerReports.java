package java112.project4;


import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * Servlet recieves the selected report option and parses the processed report file
 * to output to the page.
 *
 *@author    Thomas Hawkins
 */
@WebServlet(
name = "displayAnalyzerReports",
urlPatterns = {"/display-analyzer-reports"}
) public class DisplayAnalyzerReports extends HttpServlet {

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

        String report = "";
        String selectedReport = request.getParameter("analyzerReports");
        try (BufferedReader input = new BufferedReader(new FileReader(selectedReport))
        ) {

            StringBuilder sb = new StringBuilder();
            String line;

            while (input.ready()) {
                line = input.readLine();
                sb.append(line + "\n");
            }

            report = sb.toString();
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        if (report == null || report.isEmpty()) {
            request.setAttribute("report", "failed");
        }

        request.setAttribute("analyzer", report);

        String urlForward = "/analyzerResults.jsp";
        RequestDispatcher dispatcher
        = getServletContext().getRequestDispatcher(urlForward);
        dispatcher.forward(request, response);
    }
}
