<%@ page import="ru.geekbrains.enterprise.entity.Product" %>
<%@ page import="ru.geekbrains.enterprise.constant.FieldConst" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
</head>
<body>

<div class="container">

    <jsp:include page="/WEB-INF/template/navmenu.jsp"/>

    <article>

        <p>Edit Product</p>

        <%
            final Object productObject = request.getAttribute(FieldConst.PRODUCT);
            final Product product = (Product) productObject;
        %>

        <form action="product-save" method="post">
            <table width="100%" cellspacing="10" cellpadding="10" border="1" style="border-collapse: collapse;">
                <tr>
                    <td width="300" nowrap="nowrap" align="left">
                        ID:
                    </td>
                    <td width="100%" align="left">
                        <input class="edit-input" name="id" value="<%=product.getId()%>"/>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        NAME:
                    </td>
                    <td align="left">
                        <input class="edit-input" name="name" value="<%=product.getName()%>"/>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        DESCRIPTION:
                    </td>
                    <td align="left">
                        <input class="edit-input" name="description" value="<%=product.getDescription()%>"/>
                    </td>
                </tr>
            </table>

            <br/>
            <button class="form-button" type="submit">SAVE</button>
        </form>
    </article>

    <jsp:include page="/WEB-INF/template/footer.jsp"/>

</div>

</body>
</html>