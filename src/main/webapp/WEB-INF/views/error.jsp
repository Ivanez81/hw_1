<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">

    <jsp:include page="/WEB-INF/template/navmenu.jsp"/>

    <article>
        <c:choose>
            <c:when test="${errorCode == '403'}">
                <p>Error <%=request.getAttribute("errorCode")%>. Sorry, access to this page denied.</p>
            </c:when>
            <c:when test="${errorCode == '404'}">
                <p>Error <%=request.getAttribute("errorCode")%>. Sorry, this page couldn't be found.</p>
            </c:when>
            <c:otherwise>
                <p>Error unknown.</p>
            </c:otherwise>
        </c:choose>
    </article>

    <jsp:include page="/WEB-INF/template/footer.jsp"/>

</div>
</body>
</html>
