<%@ page import="ru.geekbrains.enterprise.constant.FieldConst" %>
<%@ page import="ru.geekbrains.enterprise.entity.Product" %>
<%@ page import="java.util.Collection" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalog</title>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">

    <jsp:include page="/WEB-INF/template/navmenu.jsp"/>

    <article>
        <p>Catalog page servlet</p>

        <sql:query var="result" dataSource="jdbc/JavaEEDS">
            SELECT * from product;
        </sql:query>

        <div class="product-figures">
            <c:forEach var="test" items="${result.rows}">
                <a href="#">
                    <figure>
                        <p><c:out value="${test.name}"/></p>
                        <figcaption>
                            <p><c:out value="${test.description}"/></p>
                        </figcaption>
                    </figure>
                </a>

            </c:forEach>
        </div>

    </article>

    <jsp:include page="/WEB-INF/template/footer.jsp"/>

</div>
</body>
</html>
