package br.com.leprechaun.dao;

import br.com.leprechaun.connection.ConnectionFactory;
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
        String sql = "INSERT INTO SETOR(SET_DESCRICAO) VALUES(?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, setor.getDescricao());
        stmt.execute();
    }
    
    public List<ModelSetor> getSetor() throws SQLException{
        List<ModelSetor> listSetor = new ArrayList<>();
        String sql = "SELECT * FROM SETOR";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            ModelSetor setor = new ModelSetor();
            setor.setIdSetor(rs.getInt("SET_ID"));
            setor.setDescricao(rs.getString("SET_DESCRICAO"));
            listSetor.add(setor);
        }
        return listSetor;
    }
    
    public int recuperaIdSetor(){
        try {
            String sql = "SELECT SET_ID FROM SETOR ORDER BY SET_ID DESC LIMIT 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            int idSetor=0;
            while(rs.next()){
                idSetor = rs.getInt("SET_ID");
            }
            return idSetor;
        } catch (SQLException ex) {
            System.err.println("Erro ao recuperar id do setor!\n"+ex);
            return 1;
        }
    }
}
