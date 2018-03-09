<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Meals</title>
</head>
<body>
    <h3><a href="index.html">Home</a></h3>
    <h2>Meals</h2>
    <hr/>
    <table border="1">
        <thead>
            <tr>
                <th>All Information</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${meals}" var="meal">
                <tr>
                    <td><c:out value="${meal}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
