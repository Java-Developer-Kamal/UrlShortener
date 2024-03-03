<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/stylesheet.jsp" %>
<%@ include file="/util/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Url-Shortener</title>
</head>
<body class="wh-full">
    <div class="center fd-col w-full mt5">
        <h1>Login</h1>
        <form action="/UrlShortener/login" method="post" class="center fd-col w-full mt2">
            <input type="email" required="required" name="email" placeholder="Enter Email:" class="input"> 
            <input type="password" required="required" name="password" placeholder="Enter Password:" class="input"> 
            <input type="submit" value="Confirm" class="btn">
        </form>
    </div>
</body>
</html>
