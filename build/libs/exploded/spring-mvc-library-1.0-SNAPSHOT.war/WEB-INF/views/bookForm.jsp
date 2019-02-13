<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
    <h1>Add Book</h1>

    <form method="POST">
        Title: <input type="text" name="title" /><br/>
        Author: <input type="text" name="author" /><br/>
        <input type="submit" value="Save" />
    </form>
</body>
</html>
