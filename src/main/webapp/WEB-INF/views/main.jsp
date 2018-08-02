<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <nav>
        <ul class="menu">
            <li><a href="main">Main Servlet</a></li>
            <li><a href="catalog">Catalog Servlet</a></li>
            <li><a href="product">Product Servlet</a></li>
            <li><a href="cart">Cart Servlet</a></li>
            <li><a href="order">Order Servlet</a></li>
        </ul>
    </nav>
    <article>
        <p>Main page servlet</p>
        <p>Тест русского языка</p>
    </article>
</div>
</body>
</html>
