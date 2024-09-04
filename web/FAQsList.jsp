

<%@page import="DAO.dbDAO"%>
<%@page import="entities.FAQs"%>
<%@page import="entities.items"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entities.categories"%>
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
        <input type="button" value="Back" onclick="back()"></br></br>
        <%
            List<items> list = new ArrayList<>();
            list = DAO.dbDAO.getAllItems();
//            int id = dbDAO.getCategoriesIDbyName("com suon");
//            out.print("<h1>"+id +"</h1>");
        %>
        <label for="item_name">Choose the item to get FAQs :</label>
        </br></br>
        <form id="form" action="FAQsServlet">
            <select id="categories" name="item_name" onchange="submit()" >
                <option value="none">${item_selected}</option>
                <%
                    for (items i : list) {
                %>
                <option value="<%=i.getItemName()%>"><%=i.getItemName()%></option>
                <%
                    }
                %>
            </select>
        </form>
        </br>
        <%
            List<FAQs> FAQslist = (List<FAQs>) session.getAttribute("FAQslist");
            if (!FAQslist.isEmpty()) {
        %>
        <table>
            <thead>
            <th>Id</th>
            <th>CustName</th>
            <th>CustContent</th>
            <th>ItemId</th>
        </thead>
        <%
            for (FAQs f : FAQslist) {
        %>
        <tbody>
        <td name="Id"><%=f.getId()%></td>
        <td name="CustName"><%=f.getCustName()%></td>
        <td name="CustContent"><%=f.getCustContent()%></td>
        <td name="ItemId"><%=f.getItemId()%></td>
    </tbody>
    <%
        }
    %>
</table>
<%
    }
%>
</body>
<script>
    function submit() {
        var form = document.getElementById("form");
        form.submit();
    }

    function back() {
        document.location.assign("index.jsp");
    }

</script>
</html>
