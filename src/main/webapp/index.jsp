<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leprechaun</title>
        <link rel="icon" type="image/png" sizes="96x96" href="imagens/favicon-96x96.png">
    </head>
    <body>
        <c:import url="cabecalho.jsp"/>

        <div class="parallax-window" data-parallax="scroll" data-image-src="imagens/Codigo.PNG" style="min-height: 300px" ></div>

        <div class="container" style="padding: 50px">
            <h4>Compre agora seu ingresso!</h4>
            <form>
                <div class="form-group">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" id="nome" placeholder="Ex: Jair Bolsonaro">
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Ex: bolsonaro2018@gmail.com">
                </div>
                <fieldset class="form-group">
                    <legend>Dia de jogo</legend>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                            Primeiro jogo
                        </label>
                    </div>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input" name="optionsRadios" id="optionsRadios2" value="option2">
                            Segundo jogo
                        </label>
                    </div>
                </fieldset>
                <div class="form-group">
                    <label for="exampleSelect1">Setor do jogo</label>
                    <select class="form-control" id="exampleSelect1">
                        <option>Setor</option>
                        <option>Amarelo</option>
                        <option>Azul</option>
                        <option>Branco</option>
                        <option>Verde</option>
                    </select>
                </div>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input">
                        Vou votar no bolsonaro.
                    </label>
                </div>
                <button type="submit" class="btn btn-outline-success">Comprar</button>
            </form>
        </div>

        <c:import url="rodape.jsp"/>
    </body>
</html>
