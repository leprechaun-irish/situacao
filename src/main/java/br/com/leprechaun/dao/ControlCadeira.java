package br.com.leprechaun.dao;

import br.com.leprechaun.connection.ConnectionFactory;
import br.com.leprechaun.model.ModelCadeira;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControlCadeira {
    
    Connection conn;

    public ControlCadeira() {
    this.conn = new ConnectionFactory().getConnection();
    }
    
    public void cadastraCadeira(ModelCadeira cadeira){
        try {
            String sql = "INSERT INTO CADEIRA(CAD_ID) VALUES(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cadeira.getIdCadeira());
            stmt.execute();
        } catch (SQLException ex) {
            System.err.println("Erro ao cadastrar cadeira!\n"+ex);
        }
    }
    
    public List<ModelCadeira> getCadeira(){
        try {
            List<ModelCadeira> listCadeira = new ArrayList<>();
            String sql = "SELECT * FROM CADEIRA";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                ModelCadeira cadeira = new ModelCadeira();
                cadeira.setIdCadeira(rs.getInt("CAD_ID"));
                listCadeira.add(cadeira);
            }
            return listCadeira;
        } catch (SQLException ex) {
            System.err.println("Erro ao listar cadeira!\n"+ex);
            return null;
        }
    }
    
}
