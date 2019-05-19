<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="assets/style/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/style/css/style.css">
    <link rel="stylesheet" href="assets/style/css/font-awesome.min.css">
    <title>Effluve: Home</title>
</head>

<body>
    <nav id="menu">
       <!-- filled dynamically by jQuery-->
    </nav>
    <main>
        <section class="banner">
        </section>
        <section class="container">
            <div class="row title-row">
                <div class="col-lg-12">
                    <h1>Destaques</h1>
                </div>
            </div>
            <ul class="row">
            <% for(int i = 0; i < 5; i++){ %>
                <li class="col-lg-3 col-sm-12 col-md-6 col-xl-3" id="perfume">
                    <a href="single.html" class="card">
                        <img class="card-img-top" src="assets/img/perfume.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Generic perfume</h5>
                            <p class="card-text">R$ 220</p>
                        </div>
                    </a>
                </li>
            <%}%>
            </ul>
        </section>
    </main>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/main.js"></script>
</body>

</html>