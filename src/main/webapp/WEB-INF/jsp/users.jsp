<%@ page import="novella_models.users.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: rumro
  Date: 15.10.2024
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <div>
        <%
            List<User> users = (List<User>) request.getAttribute("List users");
            for (User user : users) {
                out.print(user.getLogin());
                out.print(user.getPassword());
            }
        %>
    </div>
</head>
<body>

</body>
</html>
