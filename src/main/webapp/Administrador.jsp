
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin: Cadastra Setor</title>
        <script src="javascript/script.js"></script>
        <link  href="javascript/script.js"/>
    </head>
    <body>

        <table>
            <!--Form para cadastrar Setor -->
            <tr>
                <td>
                    <form name="formSetor" action="ServletAdministrador" method="post">
                        <label for="descricao">Cadastrar novo Setor: </label>
                        <input type="text" id="descricao" name="descricaoSetor" placeholder="Ex: Vermelho"/>
                        <input type="hidden" id="acao" name="acao" value="CadastraSetor"/>
                    </form>
                </td>
                <td>
                    <a href='javascript:formSetor.submit()'>
                        <img src="imagens/iconSalvar.png" width="30px"/>
                    </a>
                </td>
            </tr>
            <!--Form para cadastrar Dia -->
            <tr>
                <td>
                    <form name="formDia" action="ServletAdministrador" method="post">
                        <label for="novoDia">Cadastrar novo Dia: </label>
                        <input type="number" id="novoDia" name="novoDia" placeholder="Ex: 5"/>
                        <input type="hidden" id="acao" name="acao" value="CadastraDia"/>
                    </form>
                </td>
                <td>
                    <a href='javascript:formDia.submit()'>
                        <img src="imagens/iconSalvar.png" width="30px"/>
                    </a>
                </td>
            </tr>
            <!--Form para cadastrar Fileira -->
            <tr>
                <td>
                    <form name="formFileira" action="ServletAdministrador" method="post">
                        <label for="novaFileira">Cadastrar nova Fileira: </label>
                        <input type="number" id="novaFileira" name="novaFileira" placeholder="Ex: 27"/>
                        <input type="hidden" id="acao" name="acao" value="CadastraFileira"/>
                    </form>
                </td>
                <td>
                    <a href='javascript:formFileira.submit()'>
                        <img src="imagens/iconSalvar.png" width="30px"/>
                    </a>
                </td>
            </tr>
        </table>

    </body>
</html>
