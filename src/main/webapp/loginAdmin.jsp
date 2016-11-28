
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="icon" type="image/png" sizes="96x96" href="imagens/favicon-96x96.png">

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


        <div style="background-image: url(imagens/Estadio1.jpg); background-size: 100%; width: 100%; height: 100%; position: fixed;-webkit-filter: blur(3px);">
        </div>

        <div class="row" style="padding-top: 200px">
            <div class="col-md-3 offset-md-4">
                <div class="card card-outline-success text-xs-center" style="background-color: white">
                    <div class="card-header">
                        Login para acesso Administrativo
                    </div>
                    <div class="card-block">
                        <blockquote class="card-blockquote">
                            <form name="formLogin" action="ServletLogin" method="post">
                                <div class="form-group">
                                    <label for="login">Usuário</label>
                                    <input name="login" type="text" class="form-control" id="login" placeholder="Usuário">
                                </div>
                                <div class="form-group">
                                    <label for="password">Senha</label>
                                    <input name="senha" type="password" class="form-control" id="password" placeholder="Senha">
                                </div>
                            </form>
                        </blockquote>
                    </div>
                    <div class="card-footer">
                        <a href="index.jsp"><button type="button" class="btn btn-outline-danger">Cancelar</button></a>
                        <button type="submit" class="btn btn-outline-success" onclick="javascript:formLogin.submit()">Logar</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
