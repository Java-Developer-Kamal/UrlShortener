<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/stylesheet.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Url-Shortener</title>

</head>
<body class="w-full">
    <header>
        <nav class="w-full center even">
            <a href="/UrlShortener/user/dashboard.jsp" class="logo">Best Url-Shortener</a>

            <%
            if (session.getAttribute("user") == null) {
            %>
            <div class="center end w-40">
                <a href="/UrlShortener/user/login.jsp" class="nav-link login-register">Login</a>
                <a href="/UrlShortener/user/register.jsp" class="nav-link login-register">Register</a>
            </div>
            <%
            } else {
            %>
            <div class="center end w-40">
                <a href="/UrlShortener/get-analytics" class="nav-link">Analytics</a>
                <a href="/UrlShortener/logout" class="nav-link">Logout</a>
            </div>
            <%
            }
            %>
        </nav>
    </header>
</body>
</html>
