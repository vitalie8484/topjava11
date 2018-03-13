<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
                <th>Description</th>
                <th>Calories</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${meals}" var="mealWithExceed">
                <tr>
                    <td><c:out value="${mealWithExceed.description}" /></td>
                    <td><c:out value="${mealWithExceed.calories}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
