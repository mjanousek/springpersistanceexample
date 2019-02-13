<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Books</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
    <h1>Books</h1>

    <c:forEach items="${books}" var="book" >
        <p>Title: ${book.title}</p>
        <p>Author: ${book.author}</p>
    </c:forEach>
</body>
</html>
