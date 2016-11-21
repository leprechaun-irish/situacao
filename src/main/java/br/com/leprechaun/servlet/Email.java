package br.com.leprechaun.servlet;

import br.com.leprechaun.controller.ControlEmail;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Email", urlPatterns = {"/Email"})
public class Email extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String idade = request.getParameter("idade");
        

        System.out.println(nome + email + idade);

        Random ran = new Random();
        int codigo = ran.nextInt(9999);
        
        String mensagem = "Sr. " + nome + "\nSeu código promocional é: " + codigo + "\nApresente esse código a um de nossos representantes e ganhe 10% de desconto na compra de qualquer intem da nossa loja.\nAtt. Leprechaun.";
        ControlEmail ctrlEmail = new ControlEmail();
        ctrlEmail.sendMail("leprechaunsuporte@gmail.com", email, "Desconto Leprechaun", mensagem);
        
        response.sendRedirect("index.jsp");
    }
}
