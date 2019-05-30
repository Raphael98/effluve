<%@ page import="java.util.List" %>
<%@ page import="entity.Brand" %>
<%@ page import="entity.Gender" %>
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
    <title>Effluve: Pesquisa</title>
</head>

<body>
    <nav id="menu">
    </nav>
    <main class="container">
        <section class="row">
            <div class="col-lg-12 col-xl-12">
                <ul class="breadcrumbs">
                    <li>Perfumes</li>
                    <li>Masculino</li>
                </ul>
            </div>
        </section>
        <section class="row">
            <aside class="col-lg-4 col-xl-4">
                <div class="row">
                    <form method="get" action="search" style="width:80%">
                        <div class="col-lg-12 col-xl-12 fieldset">
                            <strong>Marcas</strong><br>
                            <jsp:useBean id="brandDao" class="dao.BrandDAO"/>
                            <% List<Brand> brands = brandDao.getAll(); %>
                            <% for(Brand brand : brands){ %>
	                            <div class="form-check">
	                                <label class="form-check-label">
	                                    <input class="form-check-input" name="brand[]" type="checkbox" value="<%= brand.getId() %>">
	                                    <%= brand.getName() %>
	                                </label>
	                            </div>
                            <% } %>
                        </div>
                        <div class="col-lg-12 col-xl-12 fieldset">
                        	<jsp:useBean id="genderDao" class="dao.GenderDAO"/>
                        	<%List<Gender> genders = genderDao.getAll();%>
                            <strong>Gênero</strong><br>
                            <%for(Gender gender : genders){ %>
	                            <div class="form-check">
	                                <label class="form-check-label">
	                                    <input class="form-check-input" name="gender[]" type="checkbox" value="<%= gender.getId()%>">
	                                    <%= gender.getName() %>
	                                </label>
	                            </div>
                            <% } %>
                        </div>
                        <input type="submit" class="btn btn-dark" value="Filtrar">
                    </form>
                </div>
            </aside>
            <div class="col-lg-8 col-xl-8">
                <div class="row">
                    <div class="col-lg-4 col-xl-4">
                        <h1>Perfumes</h1>
                    </div>
                </div>
                <ul class="row">
                	<%List<Product> products = (List<Product>) request.getAttribute("products"); %>
                	<% for(Product product : products){ %>
	                    <li class="col-lg-4 col-xl-4">
	                        <a href="single?id=<%= product.getId() %>" class="card">
	                            <img class="card-img-top" src="assets/img/perfume.jpg" alt="Card image cap">
	                            <div class="card-body">
	                                <h5 class="card-title"><%= product.getName() %></h5>
	                                <p class="card-text">R$ <%= product.getPrice() %></p>
	                            </div>
	                        </a>
	                    </li>
                    <% } %>
                </ul>
            </div>
        </section>
    </main>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/main.js"></script>
</body>

</html>