

<%@page import="entities.FAQs"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.items"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="MainController?myAction=Item management">Item management</a></br></br>
        <a href="MainController?myAction=FAQs management">FAQs management</a>
        <%
            List<FAQs> list = new ArrayList<>();
            session.setAttribute("FAQslist", list);
            session.setAttribute("item_selected", "Select ...");
        %>
    </body>
</html>
