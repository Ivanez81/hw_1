<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalog</title>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
    <script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue-resource@1.5.1"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment-with-locales.js"></script>
</head>
<body>

<div class="container">
    <jsp:include page="/WEB-INF/template/navmenu.jsp"/>
    <article>
        <p>Catalog page servlet</p>
        <div class="product-figures">

                <product-list v-for="product in products" v-bind:key="product.id"
                              v-bind:product="product"></product-list>

        </div>
    </article>
</div>

<script>
    Vue.component('product-list', {
        props: ['product'],
        template: '' +
            '<a href="#">' +
            '<figure class="product-list">' +
            '<p>{{ product.name }}</p>' +
            '<figcaption>' +
            '<p>{{ product.description }}</p>' +
            '</figcaption>' +
            '</figure>' +
            '</a>' +
            ''
    });
    new Vue({
        el: ".product-figures",
        data: {
            products: [{
                id: '',
                created: '',
                updated: '',
                category_id: '',
                name: '',
                description: ''
            }]
        },
        created() {
            var vm = this;
            this.$http.get('/api/ProductService/getListProduct')
                .then(response => {
                    return response.json()
                })
                .then(data => {
                    vm.products = data
                })
                .catch(Error => alert(Error.toString()))
        }
    });
</script>

<jsp:include page="/WEB-INF/template/footer.jsp"/>

</body>
</html>