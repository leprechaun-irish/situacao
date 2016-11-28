<%-- 
    Document   : promocao
    Created on : 20/11/2016, 01:22:54
    Author     : Lucas
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promocao</title>
        <link rel="icon" type="image/png" sizes="96x96" href="imagens/favicon-96x96.png">
        
    </head>
    <body>
        <c:import url="cabecalho.jsp"/>

        <div class="parallax-window" data-parallax="scroll" data-image-src="imagens/Estadio.jpg"></div>

        <div class="container" style="padding: 70px">
            <p>*Essa é uma promoção exclusiva para programadores com conhecimento
                JAVA.<br></p>
            <P>Cadastre-se abaixo e receba em seu email um código promocional,
                apresente0 o código a um de nossos revendedores e ganhe imediatamente
                10% de desconto na compra de qualquer ingresso de nossa loja.</p>
            <p>Obrigado pela preferência.</p><br>
            <form action="Email" method="GET">
                <div class="form-group row">
                    <label for="nome" class="col-sm-2 col-form-label">Nome</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="nome" placeholder="Ex: Jair Bolsonaro">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="email" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" name="email" placeholder="Ex: bolsonaro2018@gmail.com">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="idade" class="col-xs-2 col-form-label">Idade</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="number" value="17" name="idade">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="offset-sm-2 col-sm-10">
                        <button type="submit" class="btn btn-outline-success">Enviar</button>
                    </div>
                </div>
            </form>
        </div>

        <div class="parallax-window" data-parallax="scroll" data-image-src="imagens/Codigo.PNG" style="min-height: 300px" ></div>

        <c:import url="rodape.jsp"/>
    </body>
</html>
