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
<body class="wh-full" style="background-color: #f0f0f0;">
    <div class="center fd-col w-full mt5">
        <h1 style="color: #333;">Register</h1>
        <form action="/UrlShortener/register" method="post" class="center fd-col w-full mt2">
            <input type="text" required="required" name="username" placeholder="Enter Name:" class="input"> 
            <input type="email" required="required" name="email" placeholder="Enter Email:" class="input"> 
            <input type="password" required="required" name="password" placeholder="Enter Password:" class="input"> 
            <input type="submit" value="Confirm" class="btn">
        </form>
    </div>
</body>
</html>
