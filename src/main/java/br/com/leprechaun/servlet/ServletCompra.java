package br.com.leprechaun.servlet;

import br.com.leprechaun.dao.ControlCliente;
import br.com.leprechaun.model.ModelCliente;
import br.com.leprechaun.model.ModelDia;
import br.com.leprechaun.model.ModelSetor;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletCompra", urlPatterns = {"/ServletCompra"})
public class ServletCompra extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            int dia = Integer.parseInt(request.getParameter("dia"));
            String setor = request.getParameter("setor");
            int fileira = Integer.parseInt(request.getParameter("fileira"));
            int cadeira = Integer.parseInt(request.getParameter("cadeira"));
            
            ModelCliente modelCliente = new ModelCliente();
            ModelDia modelDia = new ModelDia();
            ModelSetor modelSetor = new ModelSetor();
            //TERMINAR AQUI
            
            modelCliente.setNome(nome);
            modelCliente.setEmail(email);
            ControlCliente ctrlCliente = new ControlCliente();
            ctrlCliente.cadastraCliente(modelCliente);
            
            
        } catch (SQLException ex) {
            System.err.println("Erro no servlet/banco de dados!\n"+ex);
        }
    }
}
