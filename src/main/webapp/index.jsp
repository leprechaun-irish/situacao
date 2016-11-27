<!-- SUJEITO A DIREITOS AUTORAIS -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leprechaun</title>
        <link rel="icon" type="image/png" sizes="96x96" href="imagens/favicon-96x96.png">

        <script type="text/javascript">
            function carregaDia() {
                var d = '${param.dia}';
                document.getElementById("d" + d).selected = "true";
                
                var s = '${param.setor}';
                document.getElementById("s" + s).selected = "true";
                
                var f = '${param.fileira}';
                document.getElementById("f" + f).selected = "true";

                $(document).ready(function () {
                    window.location.href = '#foo';
                });
            }
            function HabilitaDesabilita() {
                if (document.getElementById('habilita').checked === true) {
                    document.getElementById('envia').disabled = ""
                }
                if (document.getElementById('habilita').checked === false) {
                    document.getElementById('envia').disabled = "disabled"
                }
            }
        </script>
    </head>
    <body onLoad="carregaDia()">
        <jsp:useBean id="daoDia" class="br.com.leprechaun.dao.ControlDia"/>
        <jsp:useBean id="daoSetor" class="br.com.leprechaun.dao.ControlSetor"/>
        <jsp:useBean id="daoFileira" class="br.com.leprechaun.dao.ControlFileira"/>
        <jsp:useBean id="daoSD" class="br.com.leprechaun.dao.ControlSD"/>
        <jsp:useBean id="daoCadeira" class="br.com.leprechaun.dao.ControlCadeira"/>
        <jsp:useBean id="modelDia" class="br.com.leprechaun.model.ModelDia"/>

        <c:import url="cabecalho.jsp"/>
        <div class="row" style="padding: 50px">
            <div class="offset-md-1 col-md-8" style="padding-top: 50px">
                <blockquote class="blockquote">
                    <h3>A Leprechaun</h3>
                    <p class="lead text-justify">
                        &nbsp;&nbsp;A Leprechaun é uma das principais empresas gerenciadoras de estadios 
                        do País. Com 35 anos de existência, a empresa atua 
                        nacionalmente e ao longo de sua história esteve presente em 
                        competições de nível internacional. Estamos
                        presentes em mais de 200 cidades, e administramos cerca de 90 
                        estadios no Brasil. Sendo hoje a empresa que lidera o
                        ranking de melhor gerenciamento e organização.
                    </p>
                    <p class="lead text-justify">
                        &nbsp;&nbsp;Nossa empresa hoje entende que sua missão vai além da gerenciar
                        estadios. Seu compromisso é com o bem estar das pessoas, 
                        com a cultura e com os esportes. Com base em valores como inovação, 
                        valorização das pessoas e sustentabilidade, a empresa 
                        acredita na construção de relacionamentos de longo prazo com
                        colaboradores, clientes, fornecedores, parceiros e 
                        acionistas.
                    </p>
                    <footer class="blockquote-footer">Leprechaun, 2016</footer>
                </blockquote>
            </div>
        </div>

        <div class="parallax-window" data-parallax="scroll" data-image-src="imagens/Estadio1.jpg" style="min-height: 800px" ></div>

        <a href="#" id="foo"></a>

        <div class="row" style="padding: 20px">
            <div class="offset-md-1 col-md-8" style="padding-top: 50px">
                <h3>Para saber qual lugar escolher, <a href="Ingressos.jsp">clique aqui!</a></h3>

            </div>
        </div>

        <div class="row" style="padding: 50px">
            <form class="offset-md-1" method="GET" action="ServletCompra">
                <h4>Compre agora seu ingresso!</h4>
                <input type="hidden" value="" name="acao" id="acao">

                <div class="form-group col-md-11">
                    <label for="nome">Nome</label>
                    <input name="nome" type="text" class="form-control" placeholder="Ex: Jair Bolsonaro">
                </div>
                <div class="form-group col-md-11">
                    <label for="email">Email</label>
                    <input name="email" type="email" class="form-control" aria-describedby="emailHelp" placeholder="Ex: bolsonaro2018@gmail.com">
                </div>

                <div class="form-group col-md-2">
                    <label for="dia">Dia</label>
                    <select id="selec" class="form-control" name="dia"
                            onchange="document.getElementById('acao').value = 'selecionaDia';
                                    this.form.submit()">
                        <option>Dia</option>
                        <c:forEach var="dia" items="${daoDia.dia}">
                            <option id="d${dia.idDia}">${dia.idDia}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group col-md-2">
                    <label for="setor">Setor</label>
                    <select class="form-control" name="setor">
                        <option>Setor</option>
                        <c:forEach var="setor" items="${daoSD.consultaDiaSetor(param.dia)}">
                            <option id="s${param.setor}" value="${setor.idSetor}">${setor.descricao}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group col-md-2">
                    <label for="fileira">Fileira</label>
                    <select class="form-control" name="fileira">
                        <option>Fileira</option>
                        <c:forEach var="fileira" items="${daoFileira.fileira}">
                            <option id="f${param.fileira}">${fileira.idFileira}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group col-md-2">
                    <label for="cadeira">Cadeira</label>
                    <select class="form-control" name="cadeira">
                        <option>Cadeira</option>
                        <c:forEach var="cadeira" items="${daoCadeira.cadeira}">
                            <option value="${cadeira.idCadeira}">${cadeira.idCadeira}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-check col-md-11">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="habilita" id="habilita" onclick="HabilitaDesabilita()">
                        Vou votar no bolsonaro.
                    </label>
                </div>
                <div class="form-group col-md-11">
                    <button disabled name="envia" id="envia" value="envia" type="submit" class="btn btn-outline-success" onclick="document.getElementById('acao').value = 'compraIngresso'">Comprar</button>
                </div>
            </form>
        </div>
        <div class="parallax-window" data-parallax="scroll" data-image-src="imagens/Codigo.PNG" style="min-height: 300px" ></div>
        <c:import url="rodape.jsp"/>
    </body>
</html>
