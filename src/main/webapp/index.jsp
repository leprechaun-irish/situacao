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
            function teste(){
                var e = '${param.dia}';
                document.getElementById("d"+e).selected = "true";
            }
        </script>
    </head>
    <body onLoad="teste()">
        <jsp:useBean id="daoDia" class="br.com.leprechaun.dao.ControlDia"/>
        <jsp:useBean id="daoSetor" class="br.com.leprechaun.dao.ControlSetor"/>
        <jsp:useBean id="daoFileira" class="br.com.leprechaun.dao.ControlFileira"/>
        <jsp:useBean id="daoSD" class="br.com.leprechaun.dao.ControlSD"/>
        <jsp:useBean id="daoCadeira" class="br.com.leprechaun.dao.ControlCadeira"/>
        <jsp:useBean id="modelDia" class="br.com.leprechaun.model.ModelDia"/>

        <c:import url="cabecalho.jsp"/>
        

        <div class="parallax-window" data-parallax="scroll" data-image-src="imagens/Codigo.PNG" style="min-height: 300px" ></div>

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
                        <c:forEach var="setor" items="${daoSD.consulta(param.dia)}">
                            <option value="${setor.idSetor}">${setor.descricao}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group col-md-2">
                    <label for="fileira">Fileira</label>
                    <select class="form-control" name="fileira">
                        <option>Fileira</option>
                        <c:forEach var="fileira" items="${daoFileira.fileira}">
                            <option>${fileira.idFileira}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group col-md-2">
                    <label for="cadeira">Cadeira</label>
                    <select class="form-control" name="cadeira">
                        <option>Cadeira</option>
                        <c:forEach var="cadeira" items="${daoCadeira.cadeira}">
                            <option>${cadeira.idCadeira}</option>
                        </c:forEach>
                    </select>
                </div>
                
                <div class="form-check col-md-11">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input">
                        Vou votar no bolsonaro.
                    </label>
                </div>
                <div class="form-group col-md-11">
                    <button type="submit" class="btn btn-outline-success" onclick="document.getElementById('acao').value = 'compraIngresso'">Comprar</button>
                </div>
            </form>
        </div>
        <div class="parallax-window" data-parallax="scroll" data-image-src="imagens/Codigo.PNG" style="min-height: 300px" ></div>
        <c:import url="rodape.jsp"/>
    </body>
</html>
