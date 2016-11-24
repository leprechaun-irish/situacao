package br.com.leprechaun.servlet;

import br.com.leprechaun.dao.*;
import br.com.leprechaun.model.*;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletCompra", urlPatterns = {"/ServletCompra"})
public class ServletCompra extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");

            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            int dia = Integer.parseInt(request.getParameter("dia"));
            int setor = Integer.parseInt(request.getParameter("setor"));
            int fileira = Integer.parseInt(request.getParameter("fileira"));
            int cadeira = Integer.parseInt(request.getParameter("cadeira"));
            String acao = request.getParameter("acao");
            
            /*if (acao.equals("selecionaDia")) {
            ControlSD ctrlSD = new ControlSD();
            
            ctrlSD.consulta(dia);
            
            request.setAttribute("list", ctrlSD.consulta(dia));
            
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
            
            }*/
//----------------Instanciando Model--------------------------------------------
           
            ModelCliente modelCliente = new ModelCliente();
            ModelDia modelDia = new ModelDia();
            ModelSetor modelSetor = new ModelSetor();
            ModelFileira modelFileira = new ModelFileira();
            ModelIngresso modelIngresso = new ModelIngresso();
            ModelLugar modelLugar = new ModelLugar();

//----------------Atribuindo valores--------------------------------------------
            modelCliente.setNome(nome);
            modelCliente.setEmail(email);
            modelDia.setIdDia(dia);
            modelSetor.setIdSetor(setor);
            modelFileira.setIdFileira(fileira);
            modelLugar.setCadeira(cadeira);

            modelLugar.setDia(modelDia);
            modelLugar.setFileira(modelFileira);
            modelIngresso.setCliente(modelCliente);
            modelIngresso.setLugar(modelLugar);

//----------------Instanciando Control------------------------------------------
            ControlCliente ctrlCliente = new ControlCliente();
            ControlIngresso ctrlIngresso = new ControlIngresso();
            ControlLugar ctrlLugar = new ControlLugar();

//----------------Atribuindo Valor---------------------------------------------------------
            ctrlCliente.cadastraCliente(modelCliente);
            ctrlLugar.cadastraLugar(modelLugar);
            ctrlIngresso.cadastraIngresso(modelIngresso);
            
        } catch (SQLException ex) {
            System.err.println("Erro no servlet/banco de dados!\n" + ex);
        }
    }
}
