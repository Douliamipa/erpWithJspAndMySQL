<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/clientUpdate.css">
</head>
<body>
<div>
    <form method="POST" action="${pageContext.request.contextPath}/erpProjectWithSQLAndJsp/updateClient">
        <label for="Clientid">Client Id</label>
        <input id="Clientid" type="text" name="Clientid" value="${param.id}" readonly><br>

        <label for="CompanysName">Όνομα Επιχ/σης</label>
        <input id="CompanysName" type="text" name="CompanysName" value="${param.CompanysName}"><br>

        <label for="VAT_NO">Όνομα Επιχ/σης</label>
        <input id="VAT_NO" type="text" name="VAT_NO" value="${param.CompanysName}"><br>

        <label for="street">Street</label>
        <input id="street" type="text" name="street" value="${param.street}"><br><br>


        <label for="streetNo">Street No</label>
        <input id="streetNo" type="text" name="streetNo" value="${param.streetNo}"><br><br>


        <label for="city">City</label>
        <input id="city" type="text" name="city" value="${param.city}"><br><br>


        <label for="zipCode">zip Code</label>
        <input id="zipCode" type="text" name="zipCode" value="${param.zipCode}"><br><br>


        <label for="country">Country</label>
        <input id="country" type="text" name="country" value="${param.country}"><br><br>



        <input name="PaymentMethod" type="text" value="${param.PaymentMethod}"  autofocus /><br>
        <label for="dropdownInput">Select Payment Method:</label>
        <select id="dropdownInput" name="PaymentMethod">
            <option value="option1">Cash</option>
            <option value="option2" >Credit</option>
            <option value="option3">Bank Transfer</option>
        </select>




        <input name="AccountingCategory" type="text" value="${param.AccountingCategory}"  autofocus /><br>
        <label for="AccountingCategory">Select Accounting Category:</label>
        <select id="AccountingCategory" name="AccountingCategory">
            <option value="option1">Domestic</option>
            <option value="option2" >EU client</option>
            <option value="option3">Outside Eu Client</option>
        </select>


        <button type="submit">Update Teacher</button>
    </form>
</div>

<c:if test="${requestScope.isError}">
    <p>${requestScope.message}</p>
</c:if>

</body>
</html>
