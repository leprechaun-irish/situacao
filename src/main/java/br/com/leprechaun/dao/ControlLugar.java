package br.com.leprechaun.dao;

import br.com.leprechaun.connection.ConnectionFactory;
import br.com.leprechaun.model.ModelDia;
import br.com.leprechaun.model.ModelFileira;
import br.com.leprechaun.model.ModelLugar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControlLugar {
    
    Connection conn;
    
    public ControlLugar() {
    this.conn = new ConnectionFactory().getConnection();
    }
    
    public void cadastraLugar(ModelLugar lugar) throws SQLException{
        String sql = "INSERT INTO LUGAR(LUG_CADEIRA, LUG_FILEIRA, LUG_DIA,LUG_SETOR) VALUES(?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, lugar.getCadeira());
        stmt.setInt(2, lugar.getFileira().getIdFileira());
        stmt.setInt(3, lugar.getDia().getIdDia());
        stmt.setInt(4, lugar.getSetor().getIdSetor());
        stmt.execute();
    }
    
    public List<ModelLugar> getLugar() throws SQLException{
        List<ModelLugar> listLugar = new ArrayList<>();
        String sql = "SELECT * FROM LUGAR";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            ModelLugar lugar = new ModelLugar();
            ModelFileira fileira = new ModelFileira();
            ModelDia dia = new ModelDia();
            lugar.setIdLugar(rs.getInt("LUG_ID"));
            lugar.setCadeira(rs.getInt("LUG_CADEIRA"));
            fileira.setIdFileira(rs.getInt("LUG_FILEIRA"));
            dia.setIdDia(rs.getInt("LUG_DIA"));
            listLugar.add(lugar);
        }
        return listLugar;
    }
}
