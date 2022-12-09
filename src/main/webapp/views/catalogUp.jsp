<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/12/2022
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/CatalogController/update" method="post">
  <table border="2">
    <tr>
      <td>CatalogId</td>
      <td><input type="number" name="catalogId" value="${catalogUp.catalogId}" readonly></td>
    </tr>
    <tr>
      <td>CatalogName</td>
      <td><input type="text" name="catalogName" value="${catalogUp.catalogName}"></td>
    </tr>
    <tr>
      <td>Descriptions</td>
      <td><input type="text" name="descriptions" value="${catalogUp.descriptions}"></td>
    </tr>
    <tr>
      <td>Catalog Status</td>
      <td>
        <c:choose>
          <c:when test="${catalogUp.catalogStatus}">
            <input type="radio" name="catalogStatus" id="Active" value="true" checked/><lable for="Active">Hoạt Động</lable>
            <input type="radio" name="catalogStatus" id="InActive" value="false"/><lable for="InActive">Không Hoạt Động</lable>
          </c:when>
          <c:otherwise>
            <input type="radio" name="catalogStatus" id="Active" value="true" /><lable for="Active">Hoạt Động</lable>
            <input type="radio" name="catalogStatus" id="InActive" value="false"checked/><lable for="InActive">Không Hoạt Động</lable>
          </c:otherwise>
        </c:choose>

      </td>
    </tr>
    <tr>
      <td><input type="submit" name="update"></td>
    </tr>
  </table>
</form>
</body>
</html>
