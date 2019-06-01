<%@ page import="java.util.List" %>
<%@ page import="entity.Brand" %>
<%@ page import="controller.user.Session" %>

    <jsp:useBean id="dao" class="dao.BrandDAO"/>
    <%List<Brand> brands = dao.getAll(); %>
    <a href="home" class="logo"> Effluve</a>
    <% for(Brand brand : brands){ %>
	    <a href="search?brand=<%= brand.getId()%>"> <%= brand.getName() %></a>
    <% } %>
    <form method="GET" action="search">
        <div class="input-group">
            <input type="text" class="form-control" name="text" size="40" placeholder="O que você precisa?">
            <span class="input-group-btn">
                <button class="btn btn-default">Pesquisar</button>
            </span>
        </div>
    </form>
    <%if(!Session.isValid(request)){ %>
    	<a href="login"><i class="fa fa-user"></i> Entrar</a>
   	<% } %>
   	<%if(Session.isValid(request)){ %>
	    <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	        <i class="fa fa-user"></i> Olá, <%= session.getAttribute("user") %>
	    </a>
	    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
	        <a class="dropdown-item" href="productManaging"><i class="fa fa-wrench"></i> Gerenciar produtos</a>
	        <a class="dropdown-item" href="brandManaging"><i class="fa fa-wrench"></i> Gerenciar marcas</a>
	        <a class="dropdown-item" href="orders"><i class="fa fa-list"></i> Meus pedidos</a>
	        <!-- <a class="dropdown-item" href="settings.html"><i class="fa fa-gear"></i> Meus dados</a> -->
	        <a class="dropdown-item" href="logout"><i class="fa fa-sign-out"></i> Sair</a>
	    </div>
    <% } %>
    