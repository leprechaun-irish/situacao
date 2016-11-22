package br.com.leprechaun.dao;

import br.com.leprechaun.connection.ConnectionFactory;
import br.com.leprechaun.model.ModelDia;
import br.com.leprechaun.model.ModelSetor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControlSetor {
    
    Connection conn;

    public ControlSetor() {
    this.conn = new ConnectionFactory().getConnection();
    }
    
    public void cadastraSetor(ModelSetor setor) throws SQLException{
        String sql = "INSERT INTO SETOR(SET_DESCRICAO, SET_DIA, SET_PRECO) VALUES(?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, setor.getDescricao());
        stmt.setInt(2, setor.getDia().getIdDia());
        stmt.setDouble(3, setor.getPreco());
        stmt.execute();
    }
    
    public List<ModelSetor> getSetor() throws SQLException{
        List<ModelSetor> listSetor = new ArrayList<>();
        String sql = "SELECT * FROM SETOR";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            ModelSetor setor = new ModelSetor();
            ModelDia dia = new ModelDia();
            setor.setIdSetor(rs.getInt("SET_ID"));
            setor.setDescricao(rs.getString("SET_DESCRICAO"));
            dia.setIdDia(rs.getInt("SET_DIA"));
            setor.setPreco(rs.getDouble("SET_PRECO"));
            listSetor.add(setor);
        }
        return listSetor;
    }
}
