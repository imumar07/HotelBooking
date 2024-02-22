<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
</head>
<body>
<%@ page import="java.util.*" %>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Brand</th>
            <th>Category</th>

        </tr>
        
        <% for (String[] product : (List<String[]>) request.getAttribute("products")) { %>
            <tr>
                <td><%= product[0].toLowerCase() %></td>
                <td><%= product[1] %></td>
                <td><%= product[2] %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>
