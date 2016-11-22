package br.com.leprechaun.dao;

import br.com.leprechaun.connection.ConnectionFactory;
import br.com.leprechaun.model.ModelCliente;
import br.com.leprechaun.model.ModelIngresso;
import br.com.leprechaun.model.ModelLugar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControlIngresso {

    Connection conn;

    public ControlIngresso() {
        this.conn = new ConnectionFactory().getConnection();
    }

    public void cadastraIngresso(ModelCliente cliente, ModelLugar lugar) throws SQLException {
        String sql = "INSERT INTO INGRESSO(ING_CLIENTE, ING_LUGAR) VALUES(?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, cliente.getIdCliente());
        stmt.setInt(2, lugar.getIdLugar());
        stmt.execute();
    }

    public List<ModelIngresso> getIngresso() throws SQLException {
        List<ModelIngresso> listIngresso = new ArrayList<>();
        String sql = "SELECT * FROM INGRESSO";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            ModelIngresso ingresso = new ModelIngresso();
            ModelCliente cliente = new ModelCliente();
            ModelLugar lugar = new ModelLugar();
            ingresso.setIdIngresso(rs.getInt("ING_ID"));
            cliente.setIdCliente(rs.getInt("ING_CLIENTE"));
            lugar.setIdLugar(rs.getInt("ING_LUGAR"));
            ingresso.setData(rs.getTimestamp("ING_DATA"));
            listIngresso.add(ingresso);
        }
        return listIngresso;
    }
}
