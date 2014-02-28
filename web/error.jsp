<%-- 
    Document   : error
    Created on : Feb 28, 2014, 11:33:28 AM
    Author     : jensb
--%>

<%@ page isErrorPage="true" import="java.io.PrintWriter" %>

  <html><body>

  <h1 style="color: red">Error</h1>

  <pre>
  <%
  // unwrap ServletExceptions.
  while (exception instanceof ServletException)
    exception = ((ServletException) exception).getRootCause();

  // print stack trace.
  exception.printStackTrace(new PrintWriter(out));
  %>
  </pre>

  </body></html>
