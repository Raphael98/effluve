<%@ page import="java.util.List" %>
<%@ page import="bean.Gender" %>
<%@ page import="bean.Brand" %>
<%@ page import="bean.Product" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="assets/style/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/style/css/style.css">
    <link rel="stylesheet" href="assets/style/css/font-awesome.min.css">
    <title>Effluve: Editar produto</title>
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
        	<jsp:useBean id="productDao" class="dao.ProductDAO"/>
        	<% Product product = productDao.get(Integer.parseInt(request.getParameter("id"))); %>
            <form class="col-xl-8 offset-xl-2" method="POST">
                <h1>Editar produto</h1>
                <div class="row form-group">
                    <div class="col">
                        <label for="name">Nome</label>
                        <input type="name" id="name" class="form-control" value="<%= product.getName()%>">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col">
                        <label for="price">Preço</label>
                        <input type="price" id="price" class="form-control" value="<%= product.getPrice() %>">
                    </div>
                    <div class="col">
                        <label for="brand">Marca</label>
                        <jsp:useBean id="dao" class="dao.BrandDAO"/>
                        <select id="brand" name="brand" name="brand" class="form-control">
                            <option value="a"> -- SELECIONE --</option>
                            <% List<Brand> brands = dao.getAll(); %>
                            <% for(Brand brand : brands){ %>
	                            <option value="<%= brand.getId() %>" <% if(brand.getId() == product.getBrand().getId()){out.println("selected");} %>><%= brand.getName() %></option>
                            <% } %>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="description">Descricao</label>
                    <textarea id="description" class="form-control"><%= product.getDescription() %></textarea>
                </div>
                <input type="submit" class="btn btn-dark" value="Editar">
                <a href="list-delete-product.html" class="-slight-margin">Voltar</a>
            </form>
        </section>
    </main>
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/main.js"></script>
</body>

</html>