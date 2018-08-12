<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My First JavaEE</title>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">

    <jsp:include page="/WEB-INF/template/navmenu.jsp"/>

    <article>
        <p>Start page</p>
    </article>

    <jsp:include page="/WEB-INF/template/footer.jsp"/>

</div>
</body>
</html>
