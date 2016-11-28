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

    public void cadastraIngresso(ModelIngresso ingresso) {
        String sql = "INSERT INTO INGRESSO(ING_CLIENTE, ING_LUGAR) VALUES(?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ingresso.getCliente().getIdCliente());
            stmt.setInt(2, ingresso.getLugar().getIdLugar());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar ingresso \n" + e);
        }
    }

    public List<ModelIngresso> getIngresso() throws SQLException {
        List<ModelIngresso> listIngresso = new ArrayList<>();
        String sql = "SELECT * FROM INGRESSO";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
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

    public double totalArrecadado() {
        double total = 0.00;
        String sql = ""
                + "SELECT * FROM INGRESSO\n"
                + "INNER JOIN LUGAR ON ING_LUGAR = LUG_ID\n"
                + "INNER JOIN SETOR_DIA ON LUG_SETOR = SD_SETOR AND LUG_DIA = SD_DIA;";
        try {
            PreparedStatement stmt1 = conn.prepareStatement(sql);
            ResultSet rs = stmt1.executeQuery();
            while (rs.next()) {
                total += rs.getDouble("SD_PRECO");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao somar total arrecadado: " + ex);
        }
        return total;
    }

    public String totalDiaArrecadado(int dia) throws SQLException {
        int totalDia = 0;
        double valorTotalDia = 0.0;
        String sql = ""
                + "SELECT * FROM INGRESSO\n"
                + "INNER JOIN LUGAR ON ing_LUGAR = LUG_ID\n"
                + "INNER JOIN SETOR_DIA ON LUG_SETOR = SD_SETOR AND LUG_DIA = SD_DIA\n"
                + "WHERE LUG_DIA = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, dia);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                totalDia++;
                valorTotalDia += rs.getDouble("SD_PRECO");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao somar total arrecadado: " + ex);
        }
        
        return "Total: "+totalDia+"\nValor Total: "+valorTotalDia;
    }
    
    public void setorMaisLotado(int dia){
        String sql = "";
    }
    
}
