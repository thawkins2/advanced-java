<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta name="generator" content="HTML Tidy, see www.w3.org" />

    <title>JSP Expressions</title>
  </head>

  <body>
    <h3>JSP Expressions</h3>

    <ul>
      <LI>A Number <%= 45 + 5 %></LI>
    
      <li>Current time: <%= new java.util.Date() %></li>

      <li>Server: <%= application.getServerInfo() %></li>

      <li>Session ID: <%= session.getId() %></li>

      <li>The <code>testParam</code> form parameter: 
          <%= request.getParameter("testParam") %></li>
    </ul>
  </body>
</html>
