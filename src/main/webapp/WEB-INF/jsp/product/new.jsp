<%@ page import="java.util.List" %>
<%@ page import="bean.Brand" %>
<%@ page import="bean.Gender" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="assets/style/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/style/css/style.css">
    <link rel="stylesheet" href="assets/style/css/font-awesome.min.css">
    <title>Effluve: Novo produto</title>
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
            <form class="col-xl-8 offset-xl-2" method="POST" action="createProduct">
                <h1>Novo produto</h1>
                 <% if(request.getAttribute("success") != null){ %>
	                <div class="alert alert-success" role="alert">
	  					Cadastrado com sucesso
					</div>
				<% } %>
                <div class="row form-group">
                    <div class="col">
                        <label for="name">Nome</label>
                        <input type="name" id="name" name="name" class="form-control">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col">
                        <label for="price">Preço</label>
                        <input type="text" id="price" name="price" class="form-control">
                    </div>
                     <div class="col">
                        <label for="price">Gênero</label>
                        <jsp:useBean id="genderDao" class="dao.GenderDAO"/>
                        <% List<Gender> genders = genderDao.getAll(); %>
                        <select id="gender" name="gender" class="form-control">
                        	<option>-- SELECIONE --</option>
                        	<% for(Gender gender : genders){ %>
                        		<option value="<%= gender.getId() %>"><%= gender.getName() %></option>
                        	<% } %>
                        </select>
                    </div>
                    <div class="col">
                        <label for="brand">Marca</label>
                        <jsp:useBean id="dao" class="dao.BrandDAO"/>
                        <select id="brand" name="brand" name="brand" class="form-control">
                            <option> -- SELECIONE --</option>
                            <% List<Brand> brands = dao.getAll(); %>
                            <% for(Brand brand : brands){ %>
	                            <option value="<%= brand.getId() %>"><%= brand.getName() %></option>
                            <% } %>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="description">Descricao</label>
                    <textarea id="description" name="description" class="form-control"></textarea>
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