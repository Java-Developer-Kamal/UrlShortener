<%@page import="com.jsp.assignment.urlshortener.entity.ShortURL"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/user/authenticate.jsp"%>
<%@ include file="/stylesheet.jsp"%>
<%@ include file="/util/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Url-Shortener</title>
</head>
<body class="wh-full center" style="background-color: #f0f0f0;">
    <div class="w-full center fd-col mt5">
        <div class="w-80 center end"><a href="/UrlShortener/user/dashboard.jsp" class="btn">Back</a></div>
        <table class="w-80" cellspacing="0" style="border-collapse: collapse;">
            <tr class="bg1">
                <th class="p1">URL</th>
                <th class="p1">Click Count</th>
                <th class="p1">Delete</th>
            </tr>
            <% 
                List<ShortURL> urls = (List<ShortURL>) request.getAttribute("urls");
                if(urls != null && !urls.isEmpty()){
                    for(ShortURL url : urls){
                %>
                <tr>
                    <td class="bb1 p1"> 
                        <a href="<%= "http://localhost:8080/UrlShortener/" + url.getShortURLKey() %>" style="color: #0066cc;">
                            <%= "http://localhost:8080/UrlShortener/" + url.getShortURLKey() %>
                        </a>
                    </td>
                    <td class="bb1 p1 text-center"><%= url.getClickCount() %></td>
                    <td class="bb1 p1 text-center"> 
                        <a href="/UrlShortener/delete-url?id=<%=url.getUrlId()%>" class="nav-link link-hover" style="color: #333;">Delete</a> 
                    </td>
                </tr>
                <%
                    }
                }
            %>
        </table>
    </div>
</body>
</html>
