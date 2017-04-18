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
name = "requestServlet",
urlPatterns = {"/request-servlet"}
) public class HttpRequestServlet extends HttpServlet {

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

        HttpRequestData data = new HttpRequestData();

        data.setRemoteComputerRequest(request.getRemoteHost());
        data.setRemoteComputerAddress(request.getRemoteAddr());
        data.setHttpMethodRequest(request.getMethod());
        data.setRequestUri(request.getRequestURI());
        data.setRequestUrl(request.getServletPath());
        data.setRequestProtocol(request.getProtocol());
        data.setServerName(request.getServerName());
        data.setServerPort(request.getServerPort());
        data.setServerLocation(request.getLocale().toString());
        data.setQueryString(request.getQueryString());
        data.setQueryParameter(request.getParameter("queryParameter"));
        data.setRequestHeader(request.getHeader("User-Agent"));

        request.setAttribute("dataRequest", data);

        String urlForward = "/requestData.jsp";
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(urlForward);
        dispatcher.forward(request, response);
    }
}
