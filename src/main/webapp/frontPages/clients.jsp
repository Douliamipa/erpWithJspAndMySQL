<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Customers Found</title>
</head>
<body>

<div>
    <table>
        <tr>
            <th>ID</th>
            <th>CompanysName</th>
            <th>Vat No</th>
            <th>city</th>
            <th>street</th>
            <th>street no</th>
            <th>zip code</th>
            <th>country</th>
            <th>payment method</th>
            <th>accounting category</th>

            <th>Delete</th>
            <th>Update</th>
        </tr>
        <c:forEach var = "clients" items = "${requestScope.clients}">
            <tr>
                <td>${clients.id}</td>
                <td>${clients.companysName}</td>
                <td>${clients.vatNo}</td>
                <td>${clients.street}</td>
                <td>${clients.streetNo}</td>
                <td>${clients.city}</td>
                <td>${clients.zipCode}</td>
                <td>${clients.country}</td>
                <td>${clients.paymentMethod}</td>
                <td>${clients.accountingCategory}</td>

                <td><a href="${pageContext.request.contextPath}/erpProjectWithSQLAndJsp/ClientDeleteController?
                      companysName=${clients.companysName}&VatNo=${clients.vatNo}&City=${clientst.city}&street=${clients.street}&streetNo=${clientst.streetNo}&zipCode=${clients.zipCode}&country=${clients.country}&paymentMethod=${clients.paymentMethod}
                        &accountingCategory=${clients.accountingCategory}"
                       onclick="return confirm('Are you sure you want to delete this teacher?')">Delete</a></td>

                <td><a href="${pageContext.request.contextPath}/frontPages/clientUpdate.jsp?
                      companysName=${clients.companysName}&VatNo=${clients.vatNo}&City=${clients.city}&street=${clients.street}&streetNo=${clients.streetNo}&zipCode=${clients.zipCode}&country=${clients.country}&paymentMethod=${clients.paymentMethod}
                        &accountingCategory=${clients.accountingCategory}">Update</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

<div>
    <c:if test="${requestScope.deleteAPIError}">
        <p>Something went wrong in Delete</p>
    </c:if>
</div>

<div>
    <c:if test="${requestScope.updateAPIError}">
        <p>Something went wrong in Update</p>
    </c:if>
</div>

</body>
</html>
