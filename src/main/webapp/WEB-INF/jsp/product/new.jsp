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
            <form class="col-xl-8 offset-xl-2">
                <h1>Novo produto</h1>
                <div class="row form-group">
                    <div class="col">
                        <label for="name">Nome</label>
                        <input type="name" id="name" class="form-control">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col">
                        <label for="price">Preço</label>
                        <input type="price" id="price" class="form-control">
                    </div>
                    <div class="col">
                        <label for="brand">Marca</label>
                        <select id="brand" name="brand" class="form-control">
                            <option> -- SELECIONE --</option>
                            <option>Paco Rabanne</option>
                            <option>Azzaro</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="description">Descricao</label>
                    <textarea id="description" class="form-control"></textarea>
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