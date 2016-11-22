
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra Ingresso</title>
        <link rel="icon" type="image/png" sizes="96x96" href="imagens/favicon-96x96.png">
    </head>
    <body>
        <c:import url="cabecalho.jsp"/>
        
        <form method="post" action="CompraIngresso">
            Cadeira <input type="text" name="cadeira"/> <br>
            Fileira <input type="text" name="fileira"/> <br>
            Nome <input type="text" name="nomeCliente"/> <br>
            Email <input type="text" name="emailCliente"/> <br>
            Dia <input type="text" name="diaJogo"/> <br> 
            Setor <input type="text" name="setor"/> <br>
            <input type="submit" value="Comprar"/>
        </form>
        
        <c:import url="rodape.jsp"/>
    </body>
</html>
