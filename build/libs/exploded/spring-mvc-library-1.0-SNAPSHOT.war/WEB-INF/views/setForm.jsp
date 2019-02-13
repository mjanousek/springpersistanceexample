<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<html>
<head>
    <title>Add Set</title>
</head>
<body>
<h1>Add Set</h1>

<sf:form method="POST" commandName="set">
    Price: <sf:input path="price"/>
    <sf:errors path="price" cssClass="error"/><br/>
    <sf:select path="book.id">
        <sf:option value="-" label="--Please Select"/>
        <sf:options items="${books}" itemValue="id" itemLabel="title"/>
    </sf:select>
    <sf:errors path="book" cssClass="error"/><br/>
    <input type="submit" value="Save" />

</sf:form>
</body>
</html>
