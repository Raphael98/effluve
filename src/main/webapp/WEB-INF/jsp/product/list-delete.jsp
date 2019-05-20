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
            <form class="form-inline">
                <div class="form-group mx-sm-3 mb-2">
                    <label for="name" class="sr-only">Password</label>
                    <input type="text" class="form-control" id="name" placeholder="Nome, marca ou preço">
                </div>
                <button type="submit" class="btn btn-dark mb-2">Buscar</button>
            </form>
            <a href="new-product.html" class="btn btn-dark mb-2 -slight-margin"><i class="fa fa-plus"></i> Novo</a>
        </section>
        <section class="row">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Preço</th>
                        <th scope="col">Fabricante</th>
                        <th scope="col">Editar</th>
                        <th scope="col">Excluir</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>1 Million</td>
                        <td>R$ 450</td>
                        <td>Paco Rabanne</td>
                        <td><a href="edit-product.html" class="crud-icon"><i class="fa fa-edit"></i></a></td>
                        <td><a href="#" class="crud-icon"><i class="fa fa-times"></i></a></td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>212 NYC</td>
                        <td>R$ 380</td>
                        <td>Paco Rabanne</td>
                        <td><a href="edit-product.html" class="crud-icon"><i class="fa fa-edit"></i></a></td>
                        <td><a href="#" class="crud-icon"><i class="fa fa-times"></i></a></td>
                    </tr>
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