
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="icon" type="image/png" sizes="96x96" href="imagens/favicon-96x96.png">
        <style>

            @import url(http://fonts.googleapis.com/css?family=Open+Sans:400,700);

            body {
                background: #456;
                font-family: 'Open Sans', sans-serif;
            }

            .login {
                width: 400px;
                margin: 16px auto;
                font-size: 16px;
            }

            .login-header,
            .login p {
                margin-top: 0;
                margin-bottom: 0;
            }

            .login-triangle {
                width: 0;
                margin-right: auto;
                margin-left: auto;
                border: 12px solid transparent;
                border-bottom-color: #5cb85c;
            }

            .login-header {
                background: #5cb85c;
                padding: 20px;
                font-size: 1.4em;
                font-weight: normal;
                text-align: center;
                color: #fff;
            }

            .login-container {
                background: #ebebeb;
                padding: 12px;
            }

            .login p {
                padding: 12px;
            }

            .login input {
                box-sizing: border-box;
                display: block;
                width: 100%;
                border-width: 1px;
                border-style: solid;
                padding: 16px;
                outline: 0;
                font-family: inherit;
                font-size: 0.95em;
            }

            .login input[type="email"],
            .login input[type="password"] {
                background: #fff;
                border-color: #bbb;
                color: #555;
            }

            .login input[type="email"]:focus,
            .login input[type="password"]:focus {
                border-color: #888;
            }

            .login input[type="submit"] {
                background: #5cb85c;
                border-color: transparent;
                color: #fff;
                cursor: pointer;
            }

            .login input[type="submit"]:hover {
                background: #4c9a4a;
            }

            .login input[type="submit"]:focus {
                border-color: #05a;
            }
        </style>
    </head>
    <body>
        <div class="login">
            <div class="login-triangle"></div>
            <h2 class="login-header">Leprechaun</h2>
            <form class="login-container" action="ServletLogin" method="post">
                <p><input type="text" name="login" placeholder="Login"></p>
                <p><input type="password" name="senha" placeholder="Senha"></p>
                <p><input type="submit" value="Login"></p>
            </form>
        </div>
    </body>
</html>
