<%-- 
    Document   : Slides
    Created on : 26/11/2016, 12:54:56
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Slide Leprechaun</title>
        <link rel="icon" type="image/png" sizes="96x96" href="imagens/favicon-96x96.png">
        <link rel="stylesheet" href="css/Slides.css">
    </head>
    <body>
        <c:import url="cabecalho.jsp"/>
        <div id="main">
            <header data-center="background-position: 50% 0px;" data-top-bottom="background-position: 50% -200px;">
                <div id="headercontent" data-top=" opacity:1; transform[swing]:scale(1) " data-top-bottom=" opacity:0; transform[swing]:scale(0.5) " data-anchor-target="header">
                    <h1>Leprechaun Irish situation</h1>
                    <br/><br/>
                </div>
                <div class="mouse animated fadeInUp" data-top=" opacity:1;  " data-top-bottom=" opacity:0; " data-anchor-target="header">
                    <div class="scroll">
                    </div>
                </div>
            </header>
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
        </div>
        <section class="fullwidth">
            <div class="paralax1" data-center="background-position: 50% 0px;" data-top-bottom="background-position: 50% -200px;" data-bottom-top="background-position: 50% 100px;">
                <div class="paralaxtext" data-bottom-top=" opacity:0; transform[swing]:scale(0.5) " data-top=" opacity:1; transform[swing]:scale(1) ">
                    <h2 style="color:white"> Qual o problema proposto </h2> 
                </div>
            </div>
        </section>
        <div class="row" style="padding: 50px">
            <div class="offset-md-1 col-md-8" style="padding-top: 50px">
                <blockquote class="blockquote">
                    <h3>Qual o problema proposto</h3>
                    <p class="lead text-justify">
                        &nbsp;&nbsp;Várias empresas de informática foram contratadas para informatizar um estádio para um grande campeonato de futebol a ser realizado em breve. As empresas terão
                        que desenvolver programas que formarão um pacote de sistemas para controlar todas as operações realizadas no estádio durante o campeonato e durante
                        outros eventos futuros.O primeiro sistema desse pacote deverá controlar a arrecadação das cadeiras do estádio, em especial, para os jogos que ocorrerão em dois dias separados, um na primeira semana do campeonato e
                        outro 7 dias depois.O estádio possui 32000 assentos na arquibancada e 20000 cadeiras. As cadeiras são setorizadas. Há 4 setores: o Setor Verde, o Setor Amarelo, o Setor
                        Azul e o Setor Branco. Os setores tem tamanho exatamente iguais, contendo 25 fileiras (A, mais perto do gramado até Y, mais longe do gramado).
                        Por causa da visibilidade dos setores Verde e Branco, eles são mais caros. Assim, no primeiro jogo o preço dos setores Verde e Branco será R$ 45,00 e os outros setores R$ 25,00. No segundo jogo
                        os preços serão R$ 50,00 e R$ 30,00 respectivamente.
                    </p>
                </blockquote>
            </div>
        </div>
        <section class="fullwidth">
            <div class="paralax2" data-center="background-position: 50% 0px;" data-top-bottom="background-position: 50% -200px;" data-bottom-top="background-position: 50% 100px;">
                <div class="paralaxtext">
                    <h2 style="color:white" data-bottom-top="letter-spacing: 10px;" data-top="letter-spacing: 20px; "> Algoritimos </h2>
                </div>
            </div>
        </section>
        <div class="row" style="padding: 50px">
            <div class="offset-md-1 col-md-8" style="padding-top: 50px">
                <blockquote class="blockquote">
                    <h3>Algoritimos</h3>
                    <p class="lead text-justify">
                        &nbsp;&nbsp;Um algoritmo que calcule a arrecadação total dos dois dias de jogos.
                        Um algoritmo que informe qual foi o jogo que mais vendeu ingressos.<br/>
                        Um algoritmo que verifique qual foi o setor mais lotado do segundo jogo.<br/>
                        Uma função de algoritmo que informe qual é a cadeira vazia mais próxima do gramado, sabendo
                        Verde e Branco são sempre os de melhor visibilidade e que estando na mesma fileira não há diferença
                        (essa função será usada na tela que vende o ingresso para sugerir cadeiras para o torcedor).
                    </p>
                </blockquote>
            </div>
        </div>
        <section class="fullwidth">
            <div class="paralax3" data-center="background-position: 50% 0px;" data-top-bottom="background-position: 50% -200px;" data-bottom-top="background-position: 50% 100px;">
                <div class="paralaxtext" data-bottom-top="transform[bounce]:scale(0.5);" data-top="transform[bounce]:scale(1)">
                    <h2 style="color:black">Banco de Dados </h2>
                </div>
            </div>
        </section>
        <div class="row" style="padding: 50px">
            <div class="offset-md-1 col-md-8" style="padding-top: 50px">
                <blockquote class="blockquote">
                    <h3>Mysql</h3>
                    <p class="lead text-justify">
                        &nbsp;&nbsp;O MySQL é um sistema de gerenciamento de banco de dados(SGBD)que utiliza a linguagem SQL<br/>
                        (Linguagem de Consulta Estruturada, do inglês Structured Query Language)como interface.<br/>
                        É atualmente um dos bancos de dados mais populares, com mais de 10 milhões de instalações pelo mundo.
                    </p>
                </blockquote>
            </div>
        </div>
        <section class="fullwidth">
            <div class="paralax4" data-center="background-position: 50% 0px;" data-top-bottom="background-position: 50% -200px;" data-bottom-top="background-position: 50% 100px;">
                <div  class="paralaxtext" data-bottom-top="transform[bounce]:scale(0.5);" data-top="transform[bounce]:scale(1)">
                    <h2 style="color:black">NetBeans </h2>
                </div>
            </div>
        </section>
    </div>
    <div class="row" style="padding: 50px">
        <div class="offset-md-1 col-md-8" style="padding-top: 50px">
            <blockquote class="blockquote">
                <h3>NetBeans</h3>
                <p class="lead text-justify">
                    &nbsp;&nbsp;A IDE NetBeans auxilia programadores a escrever, compilar, debugar e instalar
                    aplicações, e foi arquitetada em forma de uma estrutura reutilizável
                    que visa simplificar o desenvolvimento e aumentar a produtividade<br/>
                    pois reúne em uma única aplicação todas estas funcionalidades. 
                    Totalmente escrita em Java, mas que pode suportar qualquer outra linguagem
                    de programação que desenvolva com Swing, como C, C++, Ruby e PHP.<br/>
                    Também suporta linguagens de marcação como XML e HTML.
                </p>
            </blockquote>
        </div>
    </div>
        <section class="fullwidth">
            <div class="paralax8" data-center="background-position: 50% 0px;" data-top-bottom="background-position: 50% -200px;" data-bottom-top="background-position: 50% 100px;">
                <div  class="paralaxtext" data-bottom-top="transform[bounce]:scale(0.5);" data-top="transform[bounce]:scale(1)">
                    <h2 style="color:black">GlassFish </h2>
                </div>
            </div>
        </section>
    </div>
    <div class="row" style="padding: 50px">
        <div class="offset-md-1 col-md-8" style="padding-top: 50px">
            <blockquote class="blockquote">
                <h3>GlassFish</h3>
                <p class="lead text-justify">
                    &nbsp;&nbsp;GlassFish é um servidor de aplicação open source 
                    liderado pela Sun Microsystems para a plataforma J2EE. Sua versão proprietária é chamada
                    Sun GlassFish Enterprise Server. GlassFish é software livre, sendo duplamente licenciado 
                    sob duas licenças de software livre: Common Development and Distribution License (CDDL) e GNU
                    General Public License (GPL) alterada exceção para classpath.
                </p>
            </blockquote>
        </div>
    </div>
    <section class="fullwidth">
        <div class="paralax5" data-center="background-position: 50% 0px;" data-top-bottom="background-position: 50% -200px;" data-bottom-top="background-position: 50% 100px;">
            <div class="paralaxtext" data-bottom-top="transform[bounce]:scale(0.5);" data-top="transform[bounce]:scale(1)">
                <h2 style="color:black">Github </h2>
            </div>
        </div>
    </section>
    <div class="row" style="padding: 50px">
        <div class="offset-md-1 col-md-8" style="padding-top: 50px">
            <blockquote class="blockquote">
                <h3>Github</h3>
                <p class="lead text-justify">
                    &nbsp;&nbsp;GitHub é um Serviço de Web Hosting Compartilhado para projetos que usam 
                    o controle de versionamento Git.O Github, é na verdade uma rede social ou uma fábrica 
                    social de software, que desenvolve e promove milhares de códigos fontes pré armazenados
                    para as mais diversas finalidades.<br/>
                    Este site possui funcionalidades de uma rede social como feeds, followers, wiki e um
                    gráfico que mostra como os desenvolvedores trabalham as versões de seus repositórios.<br/>
                    O GitHub também possui um serviço parecido com o pastebin chamado Gist.
                </p>
            </blockquote>
        </div>
    </div>
    <section class="fullwidth">
        <div class="paralax6" data-center="background-position: 50% 0px;" data-top-bottom="background-position: 50% -200px;" data-bottom-top="background-position: 50% 100px;">
            <div class="paralaxtext" data-bottom-top="transform[bounce]:scale(0.5);" data-top="transform[bounce]:scale(1)">
                <<h2 style="color:black">Maven </h2>
            </div>
        </div>
    </section>
    <div class="row" style="padding: 50px">
        <div class="offset-md-1 col-md-8" style="padding-top: 50px">
            <blockquote class="blockquote">
                <h3>Maven</h3>
                <p class="lead text-justify">
                    &nbsp;&nbsp;O Maven utiliza um arquivo XML (POM) para descrever o projeto de software
                    sendo construído, suas dependências sobre módulos e componentes externos, a ordem de compilação,
                    diretórios e plug-ins necessários. Ele vem com objetivos pré-definidos para realizar certas
                    tarefas bem definidas como compilação de código e seu empacotamento.
                    O Maven baixa bibliotecas Java e seus plug-ins dinamicamente de um ou mais repositórios, 
                    como o Maven 2 Central Repository, e armazena-os em uma área de cache local.Este cache 
                    local de artefatos baixados pode também ser atualizado com artefatos criados por projetos locais.
                    Repositórios públicos podem também ser atualizados.
                </p>
            </blockquote>
        </div>
    </div>
    <section class="fullwidth">
        <div class="paralax7" data-center="background-position: 50% 0px;" data-top-bottom="background-position: 50% -200px;" data-bottom-top="background-position: 50% 100px;">
            <div class="paralaxtext" data-bottom-top="transform[bounce]:scale(0.5);" data-top="transform[bounce]:scale(1)">
                <h2 style="color:black">Bootstrap </h2>
            </div>
        </div>
    </section>
    <div class="row" style="padding: 50px">
        <div class="offset-md-1 col-md-8" style="padding-top: 50px">
            <blockquote class="blockquote">
                <h3>Bootstrap</h3>
                <p class="lead text-justify">
                    &nbsp;&nbsp;Bootstrap é uma livre e de código aberto front-end framework web para a concepção de websites e aplicações web .
                    Ele contém HTML - e CSS modelos de design baseados em
                    tipografia , formas, botões, navegação e outros componentes da interface
                    bem como opcionais JavaScript extensões. Ao contrário de muitos frameworks web, ele se preocupa
                    com o desenvolvimento front-end somente.
                </p>
            </blockquote>
        </div>
    </div>
    <c:import url="rodape.jsp"/>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="http://arielbeninca.com/Storage/skrollr.min.js"></script>
    <script type="text/javascript">var s = skrollr.init({forceHeight: false});</script>
</body>
</html>
