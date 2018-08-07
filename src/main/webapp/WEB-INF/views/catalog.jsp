<%@ page import="ru.geekbrains.enterprise.constant.FieldConst" %>
<%@ page import="ru.geekbrains.enterprise.entity.Product" %>
<%@ page import="java.util.Collection" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalog</title>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">

    <jsp:include page="/WEB-INF/template/navmenu.jsp"/>

    <article>
        <p>Catalog page servlet</p>

        <%
            final Object productsObject = request.getAttribute(FieldConst.PRODUCTS);
            final Collection<Product> products = (Collection<Product>) productsObject;
        %>

        <div class="product-figures">

            <% int index = 1; %>
            <% for (final Product product : products) { %>

            <a href="#">
                <figure>
                    <p><%=index%>, <%=product.getName()%>
                    </p>
                    <figcaption>
                        <p><%=product.getDescription()%>
                        </p>
                    </figcaption>
                </figure>
            </a>

            <% index++; %>
            <% } %>

        </div>


    </article>

    <jsp:include page="/WEB-INF/template/footer.jsp"/>

</div>
</body>
</html>
