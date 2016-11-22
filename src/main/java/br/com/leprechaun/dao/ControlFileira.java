package br.com.leprechaun.dao;

import br.com.leprechaun.connection.ConnectionFactory;
import br.com.leprechaun.model.ModelFileira;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControlFileira {

    Connection conn;
    
    public ControlFileira(){
    this.conn = new ConnectionFactory().getConnection();
    }
    
    public void cadastraFileira(ModelFileira fileira) throws SQLException {
        String sql = "INSERT INTO FILEIRA(FIL_ID) VALUES(?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, fileira.getIdFileira());
        stmt.execute();
    }
    
    public List<ModelFileira> getFileira() throws SQLException{
        List<ModelFileira> listFileira = new ArrayList<>();
        String sql = "SELECT * FROM FILEIRA";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            ModelFileira fileira = new ModelFileira();
            fileira.setIdFileira(rs.getInt("FIL_ID"));
            listFileira.add(fileira);
        }
        return listFileira;
    }
}
