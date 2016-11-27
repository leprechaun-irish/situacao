<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cabecalho</title>

        <link rel="icon" type="image/png" sizes="96x96" href="imagens/favicon-96x96.png">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

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
        
        <style>
            ::-webkit-scrollbar{
                display: none;
            }
        </style>
        
    </head>
    <body>
        <nav class="navbar navbar-fixed-top navbar-dark bg-inverse">
            <ul class="nav navbar-nav" id="collapseExample">

                <div class="col-sm-6 offset-md-1">
                    <li class="nav nav-item">
                        <a href="index.jsp"><img src="imagens/leprechaun.png" style="width: 40px"></a>
                    </li>
                    <li class="nav nav-item">
                        <a href="index.jsp"><button id="btnHome" class="btn btn-outline-success">Home</button></a>
                    </li>
                    <li class="nav nav-item">
                        <a href="Ingressos.jsp"><button id="btnIngresso" class="btn btn-outline-success">Ingressos</button></a>
                    </li>
                    <li class="nav nav-item">
                        <a href="promocao.jsp"><button id="btnPromocao" class="btn btn-outline-success">Promoção</button></a>
                    </li>
                    <li class="nav nav-item">
                        <a href="Slides.jsp"><button id="btnSlide" class="btn btn-outline-success">Sobre"Slides"</button></a>
                    </li>
                    <li class="nav nav-item">
                        <a href="Administrador.jsp"><button id="btnGerenciar" class="btn btn-outline-success">Gerenciar</button></a>
                    </li>
                </div>
            </ul>
        </nav>

    </body>
</html>
