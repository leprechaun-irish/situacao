package br.com.leprechaun.servlet;

import br.com.leprechaun.dao.*;
import br.com.leprechaun.model.*;
import java.io.IOException;
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

        response.setContentType("text/html;charset=UTF-8");

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String setor = request.getParameter("setor");
        String fileira = request.getParameter("fileira");
        String cadeira = request.getParameter("cadeira");
        String dia = request.getParameter("dia");
        String acao = request.getParameter("acao");

        if (acao.equals("selecionaDia")) {
            ModelDia modelDia = new ModelDia();
            modelDia.setIdDia(Integer.parseInt(dia));
            System.out.println("Model Dia: " + modelDia.getIdDia());
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
        if (acao.equals("compraIngresso")){
//----------------Instanciando Control------------------------------------------
            ControlCliente ctrlCliente = new ControlCliente();
            ControlLugar ctrlLugar = new ControlLugar();
            ControlIngresso ctrlIngresso = new ControlIngresso();
            
            //----------------Instanciando Model--------------------------------------------
            ModelCliente modelCliente = new ModelCliente();
            ModelDia modelDia = new ModelDia();
            ModelSetor modelSetor = new ModelSetor();
            ModelFileira modelFileira = new ModelFileira();
            ModelIngresso modelIngresso = new ModelIngresso();
            ModelLugar modelLugar = new ModelLugar();
            ModelCadeira modelCadeira = new ModelCadeira();
            
            //----------------Atribuindo valores--------------------------------------------
            modelCliente.setNome(nome);
            modelCliente.setEmail(email);
            ctrlCliente.cadastraCliente(modelCliente);
            modelCliente.setIdCliente(ctrlCliente.recuperaIdCliente());
            
            modelDia.setIdDia(Integer.parseInt(dia));
            modelSetor.setIdSetor(Integer.parseInt(setor));
            modelFileira.setIdFileira(Integer.parseInt(fileira));
            modelCadeira.setIdCadeira(Integer.parseInt(cadeira));
            modelLugar.setCadeira(modelCadeira);
            
            modelLugar.setDia(modelDia);
            modelLugar.setFileira(modelFileira);
            modelLugar.setSetor(modelSetor);
            ctrlLugar.cadastraLugar(modelLugar);
            modelLugar.setIdLugar(ctrlLugar.recuperaIdLugar());
            
            modelIngresso.setCliente(modelCliente);
            modelIngresso.setLugar(modelLugar);
            ctrlIngresso.cadastraIngresso(modelIngresso);
            System.out.println("Model Dia: " + modelDia.getIdDia());
            RequestDispatcher rd = request.getRequestDispatcher("/promocao.jsp");
        }
        
    }
}
