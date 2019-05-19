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
                    <form method="get" style="width:80%">
                        <div class="col-lg-12 col-xl-12 fieldset">
                            <strong>Categoria</strong><br>
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="checkbox" value="amadeirado">
                                    Amadeirado
                                </label>
                            </div>
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="checkbox" value="doce">
                                    Doce
                                </label>
                            </div>
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="checkbox" value="citrico">
                                    Cítrico
                                </label>
                            </div>
                        </div>
                        <div class="col-lg-12 col-xl-12 fieldset">
                            <strong>Gênero</strong><br>
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" name="" type="checkbox" value="f">
                                    Feminino
                                </label>
                            </div>
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" name="" type="checkbox" value="m">
                                    Masculino
                                </label>
                            </div>
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" name="" type="checkbox" value="u">
                                    Unisex
                                </label>
                            </div>
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
                    <li id="perfume" class="col-lg-4 col-xl-4">
                        <a href="single.html" class="card">
                            <img class="card-img-top" src="assets/img/perfume.jpg" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">212 VIP</h5>
                                <p class="card-text">R$ 220</p>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>
        </section>
    </main>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/main.js"></script>
    <script>
        var card = $('#perfume');
        var section = $('ul.row');
        for (var i = 0; i < 10; i++) {
            section.append(card.clone());
        }
    </script>
</body>

</html>