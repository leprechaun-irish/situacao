
<%@page import="br.com.leprechaun.dao.ControlIngresso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin: Cadastra Setor</title>
        <link rel="icon" type="image/png" sizes="96x96" href="imagens/favicon-96x96.png">
    </head>
    <body>

        <%
            String usuario = (String) session.getAttribute("administrador");
            if (usuario == null) {
                throw new ServletException("Administrador não logado!");
            }
        %>

        <jsp:useBean id="daoDia" class="br.com.leprechaun.dao.ControlDia"/>
        <jsp:useBean id="daoSetor" class="br.com.leprechaun.dao.ControlSetor"/>
        <jsp:useBean id="daoSD" class="br.com.leprechaun.dao.ControlSD"/>
        <jsp:useBean id="daoFileira" class="br.com.leprechaun.dao.ControlFileira"/>
        <jsp:useBean id="daoIngresso" class="br.com.leprechaun.dao.ControlIngresso"/>

        <c:import url="cabecalho.jsp"/>
        <div style="padding-top: 70px; padding-bottom: 15px">

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
                            <form class="row" name="formSetor" action="ServletAdministrador" method="get">
                                <div class="form-group col-md-3">
                                    <label for="diaSetor">Dia</label>
                                    <select class="form-control" name="diaSetor">
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
                                <div class="form-group col-md-5">
                                    <label for="precoSetor" id="descricao">Preço</label>
                                    <div class="input-group">
                                        <div class="input-group-addon">R$</div>
                                        <input name="precoSetor" type="number" class="form-control" id="precoSetor" placeholder="Ex: 50">
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
                            <form class="row" name="formDia" action="ServletAdministrador" method="get">
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
                            <h4 class="modal-title" id="modalTitulo">Cadastrar nova fileira</h4>
                        </div>
                        <div class="modal-body">
                            <form class="row" name="formFileira" action="ServletAdministrador" method="get">
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


            <div class="row">
                <div class="offset-md-1 col-md-10" id="accordion" role="tablist" aria-multiselectable="true">
                    <div class="card">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                            <div class="btn-group" role="group">
                                <button class="btn btn-outline-success" role="tab" id="headingOne">
                                    <span class="fa fa-th-list"></span>
                                    Lista de setores
                                </button>
                                <button type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#modalSetor">
                                    <span class="fa fa-plus"></span>
                                    Cadastra Setor
                                </button>
                            </div>
                        </a>
                        <div id="collapseOne" class="collapse in" role="tabpanel" aria-labelledby="headingOne">
                            <div class=" table-responsive">
                                <form name="formListaSetor" action="ServletAdministrador" method="get">
                                    <table class="table table-sm table-hover table-inverse">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Descrição</th>
                                                <th>Dia</th>
                                                <th>Preço</th>
                                                <th>Excluir</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <input type="hidden" name="acao" id="acao" value="removeSetor">
                                        <input type="hidden" name="itemSD" id="itemSD" value="">
                                        <input type="hidden" name="itemSetor" id="itemSetor" value="">
                                        <c:forEach var="sd" items="${daoSD.list}">
                                            <tr>
                                                <td>${sd.idSD}</td>
                                                <td>${sd.setor.descricao}</td>
                                                <td>${sd.dia.idDia}</td>
                                                <td>${sd.preco}</td>
                                                <td><span class="fa fa-remove" onclick="document.getElementById('itemSD').value = '${sd.idSD}';
                                                        document.getElementById('itemSetor').value = '${sd.setor.idSetor}';
                                                        javascript:formListaSetor.submit()"></span></td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="true" aria-controls="collapseOne">
                            <div class="btn-group" role="group">
                                <button class="btn btn-outline-success" role="tab" id="headingOne">
                                    <span class="fa fa-th-list"></span>
                                    Lista de dias
                                </button>
                                <button type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#modalDia">
                                    <span class="fa fa-plus"></span>
                                    Cadastra Dia
                                </button>
                            </div>
                        </a>
                        <div id="collapseTwo" class="collapse" role="tabpanel" aria-labelledby="headingTwo">
                            <div class=" table-responsive">
                                <form name="formListaDia" method="get" action="ServletAdministrador">
                                    <table class="table table-sm  table-hover table-inverse">
                                        <thead>
                                            <tr>
                                                <th>Dia</th>
                                                <th>Excluir</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <input type="hidden" name="acao" id="acao" value="removeDia">
                                        <input type="hidden" name="itemDia" id="itemDia" value="">
                                        <c:forEach var="dia" items="${daoDia.dia}">
                                            <tr>
                                                <td>${dia.idDia}</td>
                                                <td><span class="fa fa-remove" onclick="document.getElementById('itemDia').value = '${dia.idDia}';
                                                        javascript:formListaDia.submit()"></span></td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="true" aria-controls="collapseOne">
                            <div class="btn-group" role="group">
                                <button class="btn btn-outline-success" role="tab" id="headingOne">
                                    <span class="fa fa-th-list"></span>
                                    Lista de fileiras
                                </button>
                                <button type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#modalFileira">
                                    <span class="fa fa-plus"></span>
                                    Cadastra Fileira
                                </button>
                            </div>
                        </a>
                        <div id="collapseThree" class="collapse" role="tabpanel" aria-labelledby="headingThree">
                            <div class=" table-responsive">
                                <form name="formListaFileira" method="get" action="ServletAdministrador">
                                    <table class="table table-sm  table-hover table-inverse">
                                        <thead>
                                            <tr>
                                                <th>Fileira</th>
                                                <th>Excluir</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <input type="hidden" name="acao" id="acao" value="removeFileira">
                                        <input type="hidden" name="itemFileira" id="itemFileira" value="">
                                        <c:forEach var="fileira" items="${daoFileira.fileira}">
                                            <tr>
                                                <td>${fileira.idFileira}</td>
                                                <td><span class="fa fa-remove" onclick="document.getElementById('itemFileira').value = '${fileira.idFileira}';
                                                        javascript:formListaFileira.submit()"></span></td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            Total Arrecadado: R$ ${daoIngresso.totalArrecadado()}
            
            <br><br>
        </div>

        <c:import url="rodape.jsp"/>
    </body>
</html>
