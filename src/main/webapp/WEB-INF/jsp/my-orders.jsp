<%@ page import="java.util.List" %>
<%@ page import="entity.Order" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="assets/style/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/style/css/style.css">
    <link rel="stylesheet" href="assets/style/css/font-awesome.min.css">
    <title>Effluve: Meus pedidos</title>
</head>

<body>
    <nav id="menu">
    </nav>
    <main class="container">
        <section class="row">
            <div class="col-lg-12 col-xl-12"></div>
            <ul class="breadcrumbs">
                <li>Perfumes</li>
                <li>Masculino</li>
            </ul>
            </div>
        </section>
        <section class="row">
            <h1 class="col-lg-12">
                Meus pedidos
            </h1>
        </section>
        <section>
         <jsp:useBean id="dao" class="dao.OrderDAO"/>
         <%List<Order> orders = dao.getAll((int)session.getAttribute("id")); %>
            <ul>
            <% for(Order order : orders){ %>
                <a class="black">
                    <li class="row">
                        <figure class="col-lg-2">
                            <img src="assets/img/perfume.jpg">
                        </figure>
                        <div class="col-lg-6">
                            <h2><%= order.getProduct().getName() %></h2>
                            <p>Data do pedido <%= order.getDate() %></p>
                            <p>Codigo <%= order.getCode() %></p>
                        </div>
                    </li>
                </a>
            <% } %>
            </ul>
        </section>
    </main>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/main.js"></script>
</body>

</html>