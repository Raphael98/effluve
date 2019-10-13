<%@ page import="java.util.List" %>
<%@ page import="entity.Brand" %>
<%@ page import="entity.Gender" %>
<%@ page import="entity.Product" %>
<%@ page import="controller.user.Session" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="assets/style/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/style/css/style.css">
    <link rel="stylesheet" href="assets/style/css/font-awesome.min.css">
    <title>Effluve: Produto</title>
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
        <%Product product = (Product) request.getAttribute("product");%>
        <% Session mySession = new Session(request); %>
            <figure class="col-lg-4 col-xl-4">
                <img src="assets/img/perfume.jpg">
            </figure>
            <div class="col-lg-4 col-xl-4">
                <h1><%= product.getName() %></h1>
                <h2><%= product.getBrand().getName() %></h2>
                <p>
                    <spa class="price">R$ <%= product.getPrice() %></spa>
                </p>
                <%if(mySession.isValid()){ %>
	                <form method="POST" action="orders">
	                	<input type="hidden" name="product" value="<%= product.getId() %>">
	                	<input type="hidden" name="user" value="<%= session.getAttribute("id") %>">
	                	<p><button class="btn btn-dark icon-btn" style="font-size:1.8rem"><i class="fa fa-cart-plus white"></i></button></p>
	                </form>
                <% } %>
            </div>
            <div class="col-lg-4 col-xl-4">
                    <h2>Descrição</h2>
                    <p>
                        <%= product.getDescription()  %>
                    </p>
                </div>
        </section>
    </main>
    <script src="/assets/js/popper.min.js"></script>
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/main.js"></script>
</body>

</html>