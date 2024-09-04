

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
        .thongbao{
            color: red;
        }
    </style>
    <body>
        <%
            List<categories> items_category = (List<categories>) session.getAttribute("items_category");
            int id_origin = Integer.parseInt(request.getParameter("id_origin"));
        %>
        <h1>Edit Form &nbsp <input type="button" value="Back" onclick="back()"></h1>
        <div>
            <form action="EditServlet">
                <label for="id_origin">ID</label><input type="number" name="id_origin" readonly="" value="<%=id_origin%>"></br>
                <label for="name">Name</label><input type="text" name="name" required=""></br>
                <label for="price">Price</label><input type="number" name="price" min="0" required=""></br>
                <label for="categories">Category:</label>
                <select id="categories" name="categories" >
                    <%
                        for (categories cate : items_category) {
                    %>
                    <option value="<%=cate.getCateId()%>"><%=cate.getCateName()%></option>
                    <%
                        }
                    %>
                </select>
                </br>
                <input type="submit" name="myAction" value="Save">
            </form>
        </div>
        </br></br>
    </body>
    <div class="thongbao">
        <%
            String alert = (String) request.getAttribute("alert");
            if (alert != null) {
                out.print(alert);
            } else {
                out.print("");
            }
        %>
    </div>
    <script>
        function back() {
            document.location.assign("itemsList.jsp");
        }
    </script> 
</html>
