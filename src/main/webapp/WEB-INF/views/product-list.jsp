<%@ page import="java.util.Collection" %>
<%@ page import="ru.geekbrains.enterprise.entity.Product" %>
<%@ page import="ru.geekbrains.enterprise.constant.FieldConst" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
</head>

<body>

<div class="container">

    <jsp:include page="/WEB-INF/template/navmenu.jsp"/>

    <article>
        <p>Product Catalog Management</p>

        <%
            final Object productsObject = request.getAttribute(FieldConst.PRODUCTS);
            final Collection<Product> products = (Collection<Product>) productsObject;
        %>
        <table id="product-list-table">
            <tr>
                <th>№</th>
                <th align="left">NAME</th>
                <th align="left">DESCRIPTION</th>
                <th></th>
                <th></th>
            </tr>
            <% int index = 1; %>
            <% for (final Product product : products) { %>
            <tr>
                <td align="center"><%=index%>.</td>
                <td width="200" align="left" nowrap="nowrap"><%=product.getName()%>
                </td>
                <td width="100%" align="left"><%=product.getDescription()%>
                </td>
                <td align="center" nowrap="nowrap">
                    <a href="product-edit?id=<%=product.getId()%>">EDIT</a>
                </td>
                <td align="center" nowrap="nowrap">
                    <a href="product-remove?id=<%=product.getId()%>">REMOVE</a>
                </td>
            </tr>
            <% index++; %>
            <% } %>
        </table>

        <br/>

        <form action="product-create" method="get">
            <button class="form-button" type="submit">CREATE</button>
        </form>
    </article>

    <jsp:include page="/WEB-INF/template/footer.jsp"/>

</div>

</body>
</html>
