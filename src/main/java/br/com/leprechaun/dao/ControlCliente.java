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
    
    public void cadastraCliente(ModelCliente cliente) throws SQLException{
        String sql = "INSERT INTO CLIENTE(CLI_NOME, CLI_EMAIL) VALUES(?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getEmail());
        stmt.execute();
    }
    
    public List<ModelCliente> getCliente() throws SQLException{
        List<ModelCliente> listCliente = new ArrayList<>();
        String sql = "";
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
}
