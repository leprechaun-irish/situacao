package br.com.leprechaun.servlet;

import br.com.leprechaun.dao.*;
import br.com.leprechaun.model.*;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
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
            String diaString = request.getParameter("dia");
            String setor = request.getParameter("setor");
            int fileira = Integer.parseInt(request.getParameter("fileira"));
            int cadeira = Integer.parseInt(request.getParameter("cadeira"));
            String acao = request.getParameter("acao");
            int dia = Integer.parseInt(diaString);
            
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
            ModelSD sd = new ModelSD();
            
//----------------Atribuindo valores--------------------------------------------
            modelCliente.setNome(nome);
            modelCliente.setEmail(email);
            modelDia.setIdDia(dia);
            modelSetor.setDescricao(setor);
            modelFileira.setIdFileira(fileira);
            modelLugar.setCadeira(cadeira);
            modelLugar.setDia(modelDia);
            modelLugar.setFileira(modelFileira);
            modelIngresso.setCliente(modelCliente);
            modelIngresso.setLugar(modelLugar);
            
//----------------Instanciando Control------------------------------------------
            ControlCliente  ctrlCliente = new ControlCliente();
            ControlDia      ctrlDia = new ControlDia();
            ControlSetor    ctrlSetor = new ControlSetor();
            ControlFileira  ctrlFileira = new ControlFileira();
            ControlIngresso ctrlIngresso = new ControlIngresso();
            ControlLugar    ctrlLugar = new ControlLugar();
            
//----------------Atribuindo Valor---------------------------------------------------------
            ctrlCliente.cadastraCliente(modelCliente);
            ctrlDia.cadastraDia(modelDia);
            ctrlSetor.cadastraSetor(modelSetor);
            ctrlFileira.cadastraFileira(modelFileira);
            ctrlIngresso.cadastraIngresso(modelIngresso);
            ctrlLugar.cadastraLugar(modelLugar);

        } catch (SQLException ex) {
            System.err.println("Erro no servlet/banco de dados!\n" + ex);
        }
    }
}
