<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>WeatherApp</title>
</head>
<body>
<h1>Welcome to our weather App </h1>
<br/>
<form action="${pageContext.request.contextPath}/My-Servlet" method="post">
    <input name="userInput">
    <button>Submit</button>
</form>

</body>
</html>