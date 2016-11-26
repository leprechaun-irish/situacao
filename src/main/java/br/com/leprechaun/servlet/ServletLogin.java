package br.com.leprechaun.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        if (!login.trim().equals("admin") || !senha.trim().equals("123")) {
            response.sendError(0);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("administrador", login);
            RequestDispatcher rd = req.getRequestDispatcher("/Administrador.jsp");
            rd.forward(req, response);
        }

    }

}
