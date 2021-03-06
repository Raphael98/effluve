<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="assets/style/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/style/css/style.css">
    <link rel="stylesheet" href="assets/style/css/font-awesome.min.css">
    <title>Effluve: Cadastro</title>
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
            <form class="col-xl-8 offset-xl-2" method="POST" action="userRegister">
                <h1>Cadastro</h1>
                <div class="row form-group">
                    <div class="col">
                        <label for="name">Nome</label>
                        <input type="text" name="name" id="name" class="form-control">
                    </div>
                    <div class="col">
                        <label for="email">Email</label>
                        <input type="email" name="email" id="email" class="form-control">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col">
                        <label for="passoword">Senha</label>
                        <input type="password" name="password" id="password" class="form-control">
                    </div>
                    <div class="col">
                        <label for="confirm">Confirmar senha</label>
                        <input type="password" name="confirm" id="confirm" class="form-control">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col">
                        <label for="cep">CEP</label>
                        <input type="text" name="cep" id="cep" class="form-control">
                    </div>
                    <div class="col">
                        <label for="number">N�mero</label>
                        <input type="text" name="number" id="number" class="form-control">
                    </div>
                </div>
                <input type="submit" class="btn btn-dark" value="Cadastrar">
            </form>
        </section>
    </main>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/main.js"></script>
</body>

</html>