<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Url-Shortener</title>
</head>
<body>
    <% 
        if(session.getAttribute("user") == null){
            response.sendRedirect("/UrlShortener/user/login.jsp");
        }
    %>
</body>
</html>
