
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
        <jsp:useBean id="daoDia" class="br.com.leprechaun.dao.ControlDia"/>

        <c:import url="cabecalho.jsp"/>
        <div class="row offset-md-1" style="padding-top: 70px; padding-bottom: 15px">
            <button type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#modalSetor">
                <span class="fa fa-plus"></span>
                Cadastra Setor
            </button>

            <button type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#modalDia">
                <span class="fa fa-plus"></span>
                Cadastra Dia
            </button>

            <button type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#modalFileira">
                <span class="fa fa-plus"></span>
                Cadastra Fileira
            </button>

            <!-- Modal Setor-->
            <div class="modal fade" id="modalSetor" tabindex="-1" role="dialog" aria-labelledby="modalTitulo" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="modalTitulo">Cadastrar novo setor</h4>
                        </div>
                        <div class="modal-body">
                            <form class="row" name="formSetor" action="ServletAdministrador" method="post">

                                <div class="form-group col-md-3">
                                    <label for="dia">Dia</label>
                                    <select class="form-control" name="dia">
                                        <option>Dia</option>
                                        <c:forEach var="dia" items="${daoDia.dia}">
                                            <option id="d${dia.idDia}">${dia.idDia}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group col-md-4">
                                    <label for="descricaoSetor" id="descricao">Nome</label>
                                    <input name="descricaoSetor" type="text" class="form-control" placeholder="Ex: Vermelho">
                                    <input type="hidden" id="acao" name="acao" value="CadastraSetor"/>
                                </div>

                                <div class="form-group col-md-4">
                                    <label for="descricaoSetor" id="descricao">Preço</label>
                                    <div class="input-group">
                                        <div class="input-group-addon">R$</div>
                                        <input type="text" class="form-control" id="exampleInputAmount" placeholder="Ex: 50">
                                        <div class="input-group-addon">,00</div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-outline-danger" data-dismiss="modal">Cancelar</button>
                            <button type="button" onclick="javascript:formSetor.submit()" class="btn btn-outline-success">Cadastrar</button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Modal Dia-->
            <div class="modal fade" id="modalDia" tabindex="-1" role="dialog" aria-labelledby="modalTitulo" aria-hidden="true">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="modalTitulo">Cadastrar novo dia</h4>
                        </div>
                        <div class="modal-body">
                            <form class="row" name="formDia" action="ServletAdministrador" method="post">
                                <div class="form-group col-md-10">
                                    <label for="novoDia" id="novoDia">Dia</label>
                                    <input name="novoDia" type="number" class="form-control" placeholder="Ex: 5">
                                    <input type="hidden" id="acao" name="acao" value="CadastraDia"/>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-outline-danger" data-dismiss="modal">Cancelar</button>
                            <button type="button" onclick="javascript:formDia.submit()" class="btn btn-outline-success">Cadastrar</button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Modal Fileira-->
            <div class="modal fade" id="modalFileira" tabindex="-1" role="dialog" aria-labelledby="modalTitulo" aria-hidden="true">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="modalTitulo">Cadastrar novo fileira</h4>
                        </div>
                        <div class="modal-body">
                            <form class="row" name="formFileira" action="ServletAdministrador" method="post">
                                <div class="form-group col-md-10">
                                    <label for="novaFileira" id="novaFileira">Fileira</label>
                                    <input name="novaFileira" type="number" class="form-control" placeholder="Ex: 5">
                                    <input type="hidden" id="acao" name="acao" value="CadastraFileira"/>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-outline-danger" data-dismiss="modal">Cancelar</button>
                            <button type="button" onclick="javascript:formFileira.submit()" class="btn btn-outline-success">Cadastrar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <c:import url="rodape.jsp"/>
</body>
</html>
