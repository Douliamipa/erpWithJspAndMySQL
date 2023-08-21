<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Επιτυχής Εισαγωγή</title>
</head>
<body>
<h1>Client inserted successfully</h1>
<%--<div>--%>
<%--  <p>${requestScope.insertedClient.COMPANY_NAME}</p>--%>
<%--  <p>${requestScope.insertedCLient.VAT_NO}</p>--%>
<%--  <p>${requestScope.insertedClient.CITY}</p>--%>
<%--  <p>${requestScope.insertedCLient.Street}</p>--%>
<%--  <p>${requestScope.insertedClient.STREET_NO}</p>--%>
<%--  <p>${requestScope.insertedClient.ZIPCODE}</p>--%>
<%--  <p>${requestScope.insertedClient.Country}</p>--%>
<%--  <p>${requestScope.insertedClient.PaymentMethod}</p>--%>
<%--  <p>${requestScope.insertedClient.AccountingCategory}</p>--%>
<%--</div>--%>

<div>
  <a href="${pageContext.request.contextPath}/erpProjectWithSQLAndJsp/menu">Επιστροφή</a>
</div>
</body>
</html>