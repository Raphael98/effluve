<%@ page import="java.util.List" %>
<%@ page import="bean.Brand" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="assets/style/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/style/css/style.css">
    <link rel="stylesheet" href="assets/style/css/font-awesome.min.css">
    <title>Effluve: Gerenciar marca</title>
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
            <h1>Marca</h1>
            <% if(request.getAttribute("deleted") != null){ %>
                <div class="alert alert-success" role="alert">
  					Deletado com sucesso
				</div>
			<% } %>
        </section>
        <section class="row">
            <form class="form-inline">
                <div class="form-group mx-sm-3 mb-2">
                    <label for="name" class="sr-only">Password</label>
                    <input type="text" class="form-control" id="name" placeholder="Nome, marca ou preço">
                </div>
                <button type="submit" class="btn btn-dark mb-2">Buscar</button>
            </form>
            <a href="createBrand" class="btn btn-dark mb-2 -slight-margin"><i class="fa fa-plus"></i> Novo</a>
        </section>
        <section class="row">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Descrição</th>
                        <th scope="col">Editar</th>
                        <th scope="col">Excluir</th>
                    </tr>
                </thead>
                <tbody>
                	<jsp:useBean id="brandDao" class="dao.BrandDAO"/>
                	<% List<Brand> brands = brandDao.getAll(); %>
                	<% for(Brand brand : brands){ %>
	                    <tr>
	                        <th scope="row">1</th>
	                        <td><%= brand.getName() %></td>
	                        <td><%= brand.getDescription() %></td>
	                        <td><a href="updateBrand?id=<%= brand.getId() %>" class="crud-icon update-link"><i class="fa fa-edit"></i></a></td>
	                        <td><a href="deleteBrand?id=<%= brand.getId() %>" onclick="return confirm('Tem certeza que deseja deletar?')" class="crud-icon delete-link"><i class="fa fa-times"></i></a></td>
	                    </tr>
                    <% } %>
                </tbody>
            </table>
        </section>
    </main>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/main.js"></script>
    <script>
    	
    </script>
</body>

</html>