<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title>ClientsSuppliers</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mainMenu.css">
</head>
<body>
<form method="GET" action="${pageContext.request.contextPath}/erpProjectWithSQLAndJsp/clients-crud">
    <button class="search-btn rounded color-btn" type="submit">Clients</button>
</form>

<form method="GET" action="${pageContext.request.contextPath}/erpProjectWithSQLAndJsp/suppliers-crud">
<button class="search-btn rounded color-btn" type="submit">Suppliers</button>
</form>

<form method="GET" action="${pageContext.request.contextPath}/invoices">
<button class="search-btn rounded color-btn" type="submit">Invoices</button>
</form>

<form method="GET" action="${pageContext.request.contextPath}/expence-invoices">
<button class="search-btn rounded color-btn" type="submit">Expence Invoices </button>
</form>

<form method="POST" action="${pageContext.request.contextPath}/payments">
<button class="search-btn rounded color-btn" type="submit">Payments</button>
</form>

<form method="POST" action="${pageContext.request.contextPath}/collections">
<button class="search-btn rounded color-btn" type="submit">Collections</button>
</form>

<form method="POST" action="${pageContext.request.contextPath}/customers-card">
<button class="search-btn rounded color-btn" type="submit">Customers Card</button>
</form>

<form method="POST" action="${pageContext.request.contextPath}/suppliers-card">
<button class="search-btn rounded color-btn" type="submit">Suppliers Card</button>
</form>

</body>
</html>
