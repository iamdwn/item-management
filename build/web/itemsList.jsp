

<%@page import="java.util.List"%>
<%@page import="entities.items"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        table, th, td {
            border: 1px solid black;
        }

        th, td {
            padding: 10px;
        }
    </style>
    <body>     
        <h3>Items List &nbsp <input type="button" value="Back" onclick="back()"></h3> 
        <table>
            <thead>
            <th>ID</th>
            <th>Name</th>
            <th>Action</th>
        </thead>
        <%
            List<items> list = (List<items>) session.getAttribute("items_list");
            for (items i : list) {
        %>
        <tbody>
        <td id="itemid" name="itemid"><%=i.getItemId()%></td>
        <td id="name" name="name"><%=i.getItemName()%></td>
        <td><a href="MainController?myAction=Edit&id_origin=<%=i.getItemId()%>">Edit</td>
        <td><a href="MainController?myAction=Delete&id_origin=<%=i.getItemId()%>">Delete</td>
    </tbody>

    <%
        }
    %>
</table>
<script>
    function back(){
        document.location.assign("index.jsp");
    }
</script>
</body>
</html>
