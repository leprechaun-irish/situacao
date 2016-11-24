package br.com.leprechaun.dao;

import br.com.leprechaun.connection.ConnectionFactory;
import br.com.leprechaun.model.ModelCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControlCliente {

    Connection conn;
    
    public ControlCliente() {
    this.conn = new ConnectionFactory().getConnection();
    }
    
    public void cadastraCliente(ModelCliente cliente){
        try {
            String sql = "INSERT INTO CLIENTE(CLI_ID, CLI_NOME, CLI_EMAIL) VALUES(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cliente.getIdCliente());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEmail());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar cliente." + ex);
        }
    }
    
    public List<ModelCliente> getCliente() throws SQLException{
        List<ModelCliente> listCliente = new ArrayList<>();
        String sql = "SELECT * FROM CLIENTE";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            ModelCliente cliente = new ModelCliente();
            cliente.setIdCliente(rs.getInt("CLI_ID"));
            cliente.setNome(rs.getString("CLI_NOME"));
            cliente.setEmail(rs.getString("CLI_EMAIL"));
            listCliente.add(cliente);
        }
        return listCliente;
    }
    
    public int recuperaIdCliente(){
        try {
            String sql = "SELECT CLI_ID FROM CLIENTE ORDER BY CLI_ID DESC LIMIT 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            int idCliente=0;
            while(rs.next()){
                idCliente = rs.getInt("CLI_ID");
            }
            return idCliente+1;
        } catch (SQLException ex) {
            System.err.println("Erro ao recuperar id do cliente!\n"+ex);
            return 1;
        }
    }
}
