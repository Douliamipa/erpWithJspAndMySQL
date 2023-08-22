<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Teachers Search</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/teachersmenu.css">
</head>
<body>
<div class="center">
  <p>Hello ${sessionScope.loginName}</p>
</div>

<div class="center">
  <div class="search-wrapper">
    <div class="bot-gap">
      <span class="title">Clients Search</span>
    </div>
    <div class="bot-gap">
      <form method="POST" action="${pageContext.request.contextPath}/erpProjectWithSQLAndJsp/searchClient">
        <input name="CompanyName" type="text" class="search rounded" placeholder="Insert Customers Company Name"
               autofocus/>
        <br><br>
        <button class="search-btn rounded color-btn" type="submit">Search</button>
      </form>
    </div>
  </div>


<%--  <div class="center">--%>
<%--    <div class="search-wrapper">--%>
<%--      <div class="bot-gap">--%>
<%--        <span class="title">Suppliers Search</span>--%>
<%--      </div>--%>
<%--      <div class="bot-gap">--%>
<%--        <form method="POST" action="${pageContext.request.contextPath}/erpProjectWithSQLAndJsp/search">--%>
<%--          <input name="Vat number" type="text" class="search rounded" placeholder="Insert Suppliers Vat No"--%>
<%--                 autofocus/>--%>
<%--          <br><br>--%>
<%--          <button class="search-btn rounded color-btn" type="submit">Search</button>--%>
<%--        </form>--%>
<%--      </div>--%>
<%--    </div>--%>

  <div class="insert-wrapper">
    <div class="bot-gap">
      <span class="title">Clients Insert</span>
    </div>
    <div class="bot-gap">
      <form method="POST" action="${pageContext.request.contextPath}/erpProjectWithSQLAndJsp/insertClient">
        <input name="COMPANY_NAME" type="text" value="${requestScope.insertedClient.COMPANY_NAME}"
               class="insert rounded" placeholder="Cpmpany's Name" autofocus/><br>
        <input name="VAT_NO" type="number" value="${requestScope.insertedCLient.VAT_NO}"
               class="insert rounded" placeholder="Vat No" autofocus/><br>
        <input name="CITY" type="text" value="${requestScope.insertedClient.CITY}"
               class="insert rounded" placeholder="CITY" autofocus/><br>
        <input name="STREET" type="text" value="${requestScope.insertedCLient.Street}"
               class="insert rounded" placeholder="Street" autofocus/><br>
        <input name="STREET_NO" type="text" value="${requestScope.insertedClient.STREET_NO}"
               class="insert rounded" placeholder="Street NO" autofocus/><br>
        <input name="ZIPCODE" type="number" value="${requestScope.insertedClient.ZIPCODE}"
               class="insert rounded" placeholder="Zip Code" autofocus/><br>
        <input name="COUNTRY" type="text" value="${requestScope.insertedClient.Country}"
               class="insert rounded" placeholder="Country" autofocus/><br>


        <input name="PaymentMethod" type="text" value="${requestScope.insertedClient.PaymentMethod}"  autofocus /><br>
        <label for="dropdownInput">Select Payment Method:</label>
        <select id="dropdownInput" name="dropdownPaymentMethodPaymentMethod">
          <option value="option1">Cash</option>
          <option value="option2" >Credit</option>
          <option value="option3">Bank Transfer</option>
        </select>
        </select>





        <input name="AccountingCategory" type="text" value="${requestScope.insertedClient.AccountingCategory}"  autofocus /><br>
        <label for="AccountingCategory">Select Accounting Category:</label>
        <select id="AccountingCategory" name="AccountingCategory">
          <option value="option1">Domestic</option>
          <option value="option2" >EU client</option>
          <option value="option3">Outside Eu Client</option>
        </select>



        <button class="search-btn rounded color-btn" type="submit">Insert</button>
      </form>
    </div>
  </div>
</div>

<%--  <div class="insert-wrapper">--%>
<%--    <div class="bot-gap">--%>
<%--      <span class="title">Suppliers Insert</span>--%>
<%--    </div>--%>
<%--    <div class="bot-gap">--%>
<%--      <form method="POST" action="${pageContext.request.contextPath}/erpProjectWithSQLAndJsp/insert">--%>
<%--        <input name="lastname" type="text" value="${requestScope.insertedTeacher.lastname}"--%>
<%--               class="insert rounded" placeholder="Last name" autofocus/><br>--%>
<%--        <input name="firstname" type="text" value="${requestScope.insertedTeacher.firstname}"--%>
<%--               class="insert rounded" placeholder="First name" autofocus/>--%>
<%--        <br><br>--%>
<%--        <button class="search-btn rounded color-btn" type="submit">Insert</button>--%>
<%--      </form>--%>
<%--    </div>--%>
<%--  </div>--%>
<%--</div>--%>

<div class="center">
  <c:if test="${requestScope.sqlError}">
    <p>${requestScope.message}</p>
  </c:if>
</div>

<div class="center">
  <c:if test="${requestScope.clientsNotFound}">
    <p>No Clients with this Vat No found</p>
  </c:if>

  <c:if test="${requestScope.suppliersNotFound}">
    <p>No Suppliers with this Vat No found</p>
  </c:if>

  <p>${requestScope.error}</p>
</div>
</body>
</html>


