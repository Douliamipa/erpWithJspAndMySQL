<%@ page contentType="text/html;charset=UTF-8"  %>
<!DOCTYPE html>
<html>

<head>
    <title>Customers Found</title>
</head>
<body>

<div>
    <table>
        <tr>
            <th>ID</th>
            <th>Companys Name</th>
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
        <c:forEach var = "client" items = "${requestScope.teachers}">
            <tr>
                <td>${client.id}</td>
                <td>${client.CompanysName}</td>
                <td>${client.vatNo}</td>
                <td>${client.street}</td>
                <td>${client.streetNo}</td>
                <td>${client.city}</td>
                <td>${client.zipCode}</td>
                <td>${client.country}</td>
                <td>${client.paymentMethod}</td>
                <td>${client.accountingCategory}</td>

                <td><a href="${pageContext.request.contextPath}/schoolapp/delete?id=${teacher.id}
                      &firstname=${teacher.firstname}&lastname=${teacher.lastname}"
                       onclick="return confirm('Are you sure you want to delete this teacher?')">Delete</a></td>

                <td><a href="${pageContext.request.contextPath}/school/static/templates/teacherupdate.jsp?id=${teacher.id}&firstname=${teacher.firstname}&lastname=${teacher.lastname}">Update</a></td>
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
