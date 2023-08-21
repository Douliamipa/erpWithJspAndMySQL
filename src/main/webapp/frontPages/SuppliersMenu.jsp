<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title>Suppliers Menu</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/teachersmenu.css">
</head>
<body>


  <div class="center">
        <div class="search-wrapper">
              <div class="bot-gap">
                <span class="title">Suppliers Search</span>
              </div>
              <div class="bot-gap">
                <form method="POST" action="${pageContext.request.contextPath}/erpProjectWithSQLAndJsp/search">
                  <input name="Vat number" type="text" class="search rounded" placeholder="Insert Suppliers Vat No"
                         autofocus/>
                  <br><br>
                  <button class="search-btn rounded color-btn" type="submit">Search</button>
                </form>
              </div>
        </div>
  </div>


  <div class="insert-wrapper">
    <div class="bot-gap">
      <span class="title">Clients Insert</span>
    </div>
    <div class="bot-gap">
      <form method="POST" action="${pageContext.request.contextPath}/erpProjectWithSQLAndJsp/insertSupplier">
        <input name="COMPANY_NAME" type="text" value="${requestScope.insertedSupplier.COMPANY_NAME}"
               class="insert rounded" placeholder="Cpmpany's Name" autofocus/><br>
        <input name="VAT_NO" type="number" value="${requestScope.insertedSuppliert.VAT_NO}"
               class="insert rounded" placeholder="Vat No" autofocus/><br>
        <input name="CITY" type="text" value="${requestScope.insertedSupplier.CITY}"
               class="insert rounded" placeholder="CITY" autofocus/><br>
        <input name="STREET" type="text" value="${requestScope.insertedSupplier.Street}"
               class="insert rounded" placeholder="Street" autofocus/><br>
        <input name="STREET_NO" type="text" value="${requestScope.insertedSupplier.STREET_NO}"
               class="insert rounded" placeholder="Street NO" autofocus/><br>
        <input name="ZIPCODE" type="number" value="${requestScope.insertedSupplier.ZIPCODE}"
               class="insert rounded" placeholder="Zip Code" autofocus/><br>
        <input name="COUNTRY" type="text" value="${requestScope.insertedSupplier.Country}"
               class="insert rounded" placeholder="Country" autofocus/><br>


        <input name="PaymentMethod" type="text" value="${requestScope.insertedSupplier.PaymentMethod}"  autofocus /><br>
        <label for="dropdownInput">Select Payment Method:</label>
        <select id="dropdownInput" name="dropdownPaymentMethodInput">
          <option value="option1">Cash</option>
          <option value="option2" >Credit</option>
          <option value="option3">Bank Transfer</option>
        </select>




        <input name="AccountingCategory" type="text" value="${requestScope.insertedSupplier.AccountingCategory}"  autofocus /><br>
        <label for="dropdownInput2">Select Accounting Category:</label>
        <select id="dropdownInput2" name="dropdownAccountingCategoryInput">
          <option value="option1">Domestic</option>
          <option value="option2" >EU client</option>
          <option value="option3">Outside Eu Client</option>
        </select>



        <button class="search-btn rounded color-btn" type="submit">Insert</button>
      </form>
    </div>
  </div>
  </div>
</body>
</html>
