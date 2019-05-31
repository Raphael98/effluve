<%@ page import="java.util.List" %>
<%@ page import="entity.Product" %>
<%@ page import="entity.Brand" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="assets/style/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/style/css/style.css">
    <link rel="stylesheet" href="assets/style/css/font-awesome.min.css">
    <title>Effluve: Gerenciar</title>
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
            <h1>Produtos</h1>
        </section>
        <section class="row">
	        <% if(request.getAttribute("deleted") != null){ %>
               <div class="alert alert-success col-md-12 col-lg-12" role="alert">
 					Deletado com sucesso
				</div>
			 <% } %>
            <a href="createProduct" class="btn btn-dark mb-2 -slight-margin"><i class="fa fa-plus"></i> Novo</a>
        </section>
        <section class="row">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Preço</th>
                        <th scope="col">Fabricante</th>
                        <th scope="col">G�nero</th>
                        <th scope="col">Editar</th>
                        <th scope="col">Excluir</th>
                    </tr>
                </thead>
                <tbody>
                	<jsp:useBean id="productDao" class="dao.ProductDAO"/>
                	<% List<Product> products = productDao.getAll(); %>
                	<% for(Product product : products){ %>
	                    <tr>
	                        <th scope="row"><%= product.getId() %></th>
	                        <td><%= product.getName()  %></td>
	                        <td><%= product.getPrice()  %></td>
	                        <td><%= product.getBrand().getName() %></td>
	                       	<td><%= product.getGender().getName() %></td>
	                        <td><a href="updateProduct?id=<%= product.getId() %>" class="crud-icon"><i class="fa fa-edit"></i></a></td>
	                        <td><a href="deleteProduct?id=<%= product.getId() %>" class="crud-icon" onclick="return confirm('Tem certeza que deseja deletar?')"><i class="fa fa-times"></i></a></td>
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
</body>

</html>