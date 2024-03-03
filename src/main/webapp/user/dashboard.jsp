<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/user/authenticate.jsp" %>
<%@ include file="/stylesheet.jsp" %>
<%@ include file="/util/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Url-Shortener</title>
</head>
<body class="wh-full center" style="background-color: #f0f0f0;">
    <div class="w-full center fd-col mt5">
        <% 
            String shortURL = (String) request.getAttribute("shortURL");
            if(shortURL != null){
        %>
        <p class="mt5 font-lg" style="color: #333;">Your Short URL Here</p>
        <form action="/UrlShortener/user/dashboard.jsp" method="post" class="w-full center fd-col mt5">
            <p class="w-full text-center" style="color: #0066cc;"><%= shortURL %></p>
            <button type="button" onclick="copyToClipboard('<%= shortURL %>')" class="btn">Copy to Clipboard</button>
            <br>
            <input type="submit" value="Back" class="btn" style="margin-top: 10px;"> 
        </form>
        <%
            } else {
        %>
        <p class="mt5 font-lg" style="color: #333;">Get Your Short URL</p>
        <form action="/UrlShortener/shorten-url" method="post" class="w-full center fd-col mt5">
            <input type="text" required="required" name="url" placeholder="Paste your URL here:" class="input">
            <input type="submit" value="Confirm" class="btn" style="margin-top: 10px;"> 
        </form>
        <%
            }
        %>
    </div>

    <script>
        function copyToClipboard(url) {
            
            var tempTextArea = document.createElement('textarea');
            tempTextArea.value = url;

           
            document.body.appendChild(tempTextArea);

           
            tempTextArea.select();

            
            document.execCommand('copy');

           
            document.body.removeChild(tempTextArea);

            
            var copyStatus = document.getElementById('copyStatus');
            copyStatus.innerHTML = 'Text copied to clipboard!';

            setTimeout(function() {
                copyStatus.innerHTML = '';
            }, 3000);
        }
    </script>

</body>
</html>
