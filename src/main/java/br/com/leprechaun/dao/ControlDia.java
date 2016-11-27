package br.com.leprechaun.dao;

import br.com.leprechaun.connection.ConnectionFactory;
import br.com.leprechaun.model.ModelDia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlDia {
    
    Connection conn;
    
    public ControlDia() {
        this.conn = new ConnectionFactory().getConnection();
    }
    
    public void cadastraDia(ModelDia dia) throws SQLException{
        String sql = "INSERT INTO DIA(DIA_ID) VALUES(?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, dia.getIdDia());
        stmt.execute();
    }
    
    public List<ModelDia> getDia() throws SQLException{
        List<ModelDia> listDia = new ArrayList<>();
        String sql = "SELECT * FROM DIA";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            ModelDia dia = new ModelDia();
            dia.setIdDia(rs.getInt("DIA_ID"));
            listDia.add(dia);
        }
        return listDia;
    }
    
    public void removeDia(ModelDia modelDia){
        try {
            String sql ="DELETE FROM SETOR_DIA WHERE SD_DIA=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, modelDia.getIdDia());
            stmt.execute();
            stmt.close();
            sql = "DELETE FROM DIA WHERE DIA_ID=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, modelDia.getIdDia());
            stmt.execute();
            stmt.close();
            
            sql= "";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, modelDia.getIdDia());
            stmt.execute();
            stmt.close();
            
            System.out.println("Chegou");
        } catch (SQLException ex) {
            System.out.println("Erro bem loko"+ex);
        }
    }
}
