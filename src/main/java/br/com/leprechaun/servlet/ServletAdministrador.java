package br.com.leprechaun.servlet;

import br.com.leprechaun.dao.ControlDia;
import br.com.leprechaun.dao.ControlFileira;
import br.com.leprechaun.dao.ControlSetor;
import br.com.leprechaun.model.ModelDia;
import br.com.leprechaun.model.ModelFileira;
import br.com.leprechaun.model.ModelSetor;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletAdministrador", urlPatterns = {"/ServletAdministrador"})
public class ServletAdministrador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String acao = request.getParameter("acao");

        try {
            if ("CadastraSetor".equalsIgnoreCase(acao)) {
                String descricaoSetor = request.getParameter("descricaoSetor");
                ControlSetor controlSetor = new ControlSetor();
                ModelSetor setor = new ModelSetor();
                setor.setDescricao(descricaoSetor);
                controlSetor.cadastraSetor(setor);

                RequestDispatcher rd = request.getRequestDispatcher("/Administrador.jsp");
                rd.forward(request, response);

            }
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

    }
}
