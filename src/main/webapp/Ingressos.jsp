<%-- 
    Document   : Ingressos
    Created on : 26/11/2016, 23:42:56
    Author     : Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingressos</title>
        <link rel="icon" type="image/png" sizes="96x96" href="imagens/favicon-96x96.png">
    </head>
    <body>
        <jsp:useBean id="daoSetor" class="br.com.leprechaun.dao.ControlSetor"/>
        <jsp:useBean id="daoSD" class="br.com.leprechaun.dao.ControlSD"/>

        <c:import url="cabecalho.jsp"/>

        <div class="parallax-window" data-parallax="scroll" data-image-src="imagens/Estadio2.jpg" style="min-height: 500px" ></div>

        <div class="row" style="padding-top: 70px; padding-bottom: 20px">
            <div class="offset-md-1 col-md-8">
                <h3>Dia de jogo</h3>
                <p class="lead text-justify">
                    &nbsp;&nbsp;A Leprechaun está promovendo uma competição 
                    entre os dois melhores times da cidade. Não fique de fora dessa, garanta já seu ingresso!
                </p>
                <p class="lead text-justify">
                    &nbsp;&nbsp;A princípio o evento vai durar dois dias, 
                    sendo o primeiro dia de treino e o segundo valendo a
                    Taça Leprechaun.
                <p class="lead text-justify"><b>Obs:</b> Em caso de empate, pode haver mais dias
                    de jogos!
                </p>
                <h3>Setores</h3>
                <p class="lead text-justify">
                    &nbsp;&nbsp;Nosso estádio conta com <b>2000</b> mil lugares, sendo 
                    dividivo em <b>4</b> setores, cada setor contém <b>25</b> 
                    fileiras, <b>20</b> cadeiras em cada fileira, resultando em 
                    <b>500</b> lugares por setor.
                </p>
                <p class="lead text-justify">
                    &nbsp;&nbsp;Confira abaixo a lista de setores disponíveis e 
                    seus respectivos preços.
                </p>
                <div class=" table-responsive">
                    <table class="table table-sm table-hover table-inverse">
                        <thead>
                            <tr>
                                <th>Descrição</th>
                                <th>Dia</th>
                                <th>Preço</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="sd" items="${daoSD.list}">
                                <tr>
                                    <td>${sd.setor.descricao}</td>
                                    <td>${sd.dia.idDia}</td>
                                    <td>R$${sd.preco}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <h3>Fileiras</h3>
                <p class="lead text-justify">
                    &nbsp;&nbsp;As fileiras de cada setor são enumeradas de <b>1</b> à 
                    <b>25</b>, sendo a fileira <b>1</b> a mais próxima do gramado e a fileira <b>25</b> a mais longe.
                </p>
                <h3>Garanta já seu lugar e fique mais perto de seu ídolo!</h3>
            </div>
        </div>
        <c:import url="rodape.jsp"/>
    </body>
</html>
