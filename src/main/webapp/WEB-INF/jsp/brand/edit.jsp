<%@ page import="java.util.List" %>
<%@ page import="entity.Gender" %>
<%@ page import="entity.Brand" %>
<%@ page import="entity.Product" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="assets/style/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/style/css/style.css">
    <link rel="stylesheet" href="assets/style/css/font-awesome.min.css">
    <title>Effluve: Novo marca</title>
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
        	<jsp:useBean id="dao" class="dao.BrandDAO"/>
        	<% Brand brand = dao.get(Integer.parseInt(request.getParameter("id"))); %>
            <form class="col-xl-8 offset-xl-2" method="POST" action="updateBrand">
            	<input type="hidden" name="id" value="<%= brand.getId()%>">
                <h1>Novo marca</h1>
                <div class="row form-group">
                    <div class="col">
                        <label for="name">Nome</label>
                        <input type="text" id="name" name="name" value="<%= brand.getName() %>" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="description">Descrição<small> (opcional)</small></label>
                    <textarea id="description" class="form-control" name="description"><%= brand.getDescription() %></textarea>
                </div>
                <input type="submit" class="btn btn-dark" value="Cadastrar">
                <a href="list-delete-product.html" class="-slight-margin">Voltar</a>
            </form>
        </section>
    </main>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/main.js"></script>
</body>

</html>