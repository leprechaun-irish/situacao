<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cabecalho</title>

        <link rel="icon" type="image/png" sizes="96x96" href="imagens/favicon-96x96.png">
        
        <!--Parallax-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

        <script src="javascript/parallax.js"></script>

        <link rel="stylesheet" href="css/parallax.css">
        <!--Fim-->

        <!--Livraria JQuery-->
        <script src="https://code.jquery.com/jquery-3.1.1.js" integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA=" crossorigin="anonymous"></script>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.5/css/bootstrap.min.css" integrity="sha256-mIfhv/h3MLq3WSiSlduuZO3saRNzzuf1LK8w3z3l3JY=" crossorigin="anonymous" />

        <!-- Bootstrap JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.5/js/bootstrap.min.js" integrity="sha256-j+XrvkQ4jJ99Hj0pJKPr6k0RCgxDDSTs3PBqLrX2EMc=" crossorigin="anonymous"></script>
       
    </head>
    <body>
        <nav class="navbar navbar-fixed-top navbar-dark bg-inverse">
            <ul class="nav navbar-nav" id="collapseExample">
                <li class="nav nav-item">
                    <img src="imagens/leprechaun.png" style="width: 40px">
                </li>
                <div class="col-sm-6 offset-md-4">
                <li class="nav nav-item">
                    <a href="index.jsp"><button class="btn btn-outline-success">Home</button></a>
                </li>
                <li class="nav nav-item">
                    <button class="btn btn-outline-success">Ingressos</button>
                </li>
                <li class="nav nav-item">
                    <button class="btn btn-outline-success">Jogos</button>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-item" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <button class="btn btn-outline-success dropdown-toggle">Sobre</button>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="#">Estadio</a>
                        <a class="dropdown-item" href="#">Setores</a>
                        <a class="dropdown-item" href="promocao.jsp">Promoção</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Contato</a>

                    </div>
                </li>
                </div>
            </ul>
        </nav>

    </body>
</html>
