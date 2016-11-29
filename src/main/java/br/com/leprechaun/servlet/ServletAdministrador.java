package br.com.leprechaun.servlet;

import br.com.leprechaun.dao.ControlDia;
import br.com.leprechaun.dao.ControlFileira;
import br.com.leprechaun.dao.ControlIngresso;
import br.com.leprechaun.dao.ControlSD;
import br.com.leprechaun.dao.ControlSetor;
import br.com.leprechaun.model.ModelDia;
import br.com.leprechaun.model.ModelFileira;
import br.com.leprechaun.model.ModelSD;
import br.com.leprechaun.model.ModelSetor;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletAdministrador", urlPatterns = {"/ServletAdministrador"})
public class ServletAdministrador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String acao = request.getParameter("acao");

        try {
//------------------------------------------------------------------------------
            if ("CadastraSetor".equalsIgnoreCase(acao)) {
                String descricaoSetor = request.getParameter("descricaoSetor");
                String dia = request.getParameter("diaSetor");
                String preco = request.getParameter("precoSetor");
                System.out.println("Dia: "+Integer.parseInt(dia));
                System.out.println("Descrição setor: "+descricaoSetor);
                System.out.println("Preço: "+Double.parseDouble(preco));
//------------------------------------------------------------------------------
                ModelSetor modelSetor = new ModelSetor();
                ModelSD modelSD = new ModelSD();
                ModelDia modelDia = new ModelDia();
                ControlSetor controlSetor = new ControlSetor();
                ControlSD controlSD = new ControlSD();
//------------------------------------------------------------------------------
                modelSetor.setDescricao(descricaoSetor);
                controlSetor.cadastraSetor(modelSetor);
                modelSetor.setIdSetor(controlSetor.recuperaIdSetor());
                
                modelDia.setIdDia(Integer.parseInt(dia));
                modelSD.setDia(modelDia);
                modelSD.setPreco(Double.parseDouble(preco));
                modelSD.setSetor(modelSetor);
                controlSD.cadastraSD(modelSD);
//------------------------------------------------------------------------------
                RequestDispatcher rd = request.getRequestDispatcher("/Administrador.jsp");
                rd.forward(request, response);
            }
//------------------------------------------------------------------------------

            if ("CadastraDia".equalsIgnoreCase(acao)) {
                int dia = Integer.parseInt(request.getParameter("novoDia"));
                ControlDia controlDia = new ControlDia();
                ModelDia novoDia = new ModelDia();
                novoDia.setIdDia(dia);
                controlDia.cadastraDia(novoDia);

                RequestDispatcher rd = request.getRequestDispatcher("/Administrador.jsp");
                rd.forward(request, response);
            }
            if ("CadastraFileira".equalsIgnoreCase(acao)) {
                int fileira = Integer.parseInt(request.getParameter("novaFileira"));
                ControlFileira controlFileira = new ControlFileira();
                ModelFileira novaFileira = new ModelFileira();
                novaFileira.setIdFileira(fileira);
                controlFileira.cadastraFileira(novaFileira);
                
                RequestDispatcher rd = request.getRequestDispatcher("/Administrador.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException ex) {
            System.out.println("Erro administrador ao cadastrar setor: " + ex);
        }
        
        if("removeSetor".equals(acao)){
            try {
                int itemSD =Integer.parseInt(request.getParameter("itemSD"));
                int itemSetor =Integer.parseInt(request.getParameter("itemSetor"));
                ModelSetor modelSetor = new ModelSetor();
                ModelSD modelSD = new ModelSD();
                ControlSD controlSD = new ControlSD();
                modelSD.setIdSD(itemSD);
                modelSetor.setIdSetor(itemSetor);
                controlSD.removeSD(modelSD, modelSetor);
                RequestDispatcher rd = request.getRequestDispatcher("/Administrador.jsp");
                rd.forward(request, response);
            } catch (SQLException ex) {
                System.err.println("Erro ao excluir setor!\n"+ex);
            }
        }
        
        if("removeDia".equals(acao)){
            int itemDia = Integer.parseInt(request.getParameter("itemDia"));
            ModelDia modelDia = new ModelDia();
            ControlDia controlDia = new ControlDia();
            modelDia.setIdDia(itemDia);
            controlDia.removeDia(modelDia);
            RequestDispatcher rd = request.getRequestDispatcher("/Administrador.jsp");
            rd.forward(request, response);
        }
        
        if("removeIngresso".equals(acao)){
            try {
                ControlIngresso ctrlIngresso = new ControlIngresso();
                int idIngresso = Integer.parseInt(request.getParameter("idFileira"));
                ctrlIngresso.removeIngresso(idIngresso);
            } catch (SQLException ex) {
                System.out.println("Erro ao remover ingresso!\n"+ex);
            }
        }
    }
}
