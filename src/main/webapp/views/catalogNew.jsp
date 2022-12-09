<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/12/2022
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Catalog</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/CatalogController/create" method="post">
<table border="2">
  <tr>
    <td>CatalogName</td>
    <td><input type="text" name="catalogName"></td>
  </tr>
  <tr>
    <td>Descriptions</td>
    <td><input type="text" name="descriptions"></td>
  </tr>
  <tr>
    <td>CatalogCStatus</td>
    <td>
      <input type="radio" name="catalogStatus" id="Active" value="true" checked/>
      <lable for="Active">Hoạt Động</lable>
      <input type="radio" name="catalogStatus" id="InActive" value="false"/>
      <lable for="InActive">Không hoạt Động</lable>
    </td>
  </tr>
  <tr>
    <td><input type="submit" name="create"></td>
  </tr>
</table>
</form>
</body>
</html>
