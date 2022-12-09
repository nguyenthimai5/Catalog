<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/12/2022
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/CatalogController/search" method="post">
    <table style="margin-left: 600px;margin-top: 250px">
        <tr>
            <td><input type="text" name="search"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Search"></td>
        </tr>
    </table>
</form>
<table border="2" style="margin-left: 600px">
    <thead>
    <tr>
        <th>CatalogId</th>
        <th>CatalogName</th>
        <th>Descriptions</th>
        <th>CatalogStatus</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${catalogList}" var="cat" >
        <tr>
            <td>${cat.catalogId}</td>
            <td>${cat.catalogName}</td>
            <td>${cat.descriptions}</td>
            <td>${cat.catalogStatus?"Hoạt Động":"Không hoạt động"}</td>
            <td colspan="2">
                <a href="<%=request.getContextPath()%>/CatalogController/updateCatalog?catalogId=${cat.catalogId}">Update</a>
                <a href="<%=request.getContextPath()%>/CatalogController/delete?catalogId=${cat.catalogId}">Delete</a>
            </td>
        </tr>

    </c:forEach>
    </tbody>

</table>
<a href="<%=request.getContextPath()%>/CatalogController/insertCatalog" style="margin-left: 600px;margin-top: 350px">Create New Catalog</a>
</body>
</html>
