package br.com.leprechaun.dao;

import br.com.leprechaun.connection.ConnectionFactory;
import br.com.leprechaun.model.ModelDia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControlDia {

    Connection conn;

    public ControlDia() {
        this.conn = new ConnectionFactory().getConnection();
    }

    public void cadastraDia(ModelDia dia) throws SQLException {
        String sql = "INSERT INTO DIA(DIA_ID) VALUES(?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, dia.getIdDia());
        stmt.execute();
    }

    public List<ModelDia> getDia() throws SQLException {
        List<ModelDia> listDia = new ArrayList<>();
        String sql = "SELECT * FROM DIA";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ModelDia dia = new ModelDia();
            dia.setIdDia(rs.getInt("DIA_ID"));
            listDia.add(dia);
        }
        return listDia;
    }

    public void removeDia(ModelDia modelDia) {
        try {
            String sql = "DELETE FROM SETOR_DIA WHERE SD_DIA=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, modelDia.getIdDia());
            stmt.execute();
            stmt.close();
            sql = "DELETE FROM DIA WHERE DIA_ID=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, modelDia.getIdDia());
            stmt.execute();
            stmt.close();

            sql = "";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, modelDia.getIdDia());
            stmt.execute();
            stmt.close();

            System.out.println("Chegou");
        } catch (SQLException ex) {
            System.out.println("Erro bem loko" + ex);
        }
    }

    public int contaTotalDia(int dia, String resposta) throws SQLException {

        int valorTotal = 0;
        int ingressosTotais = 0;

        String sql = ""
                + "SELECT * FROM INGRESSO\n"
                + "INNER JOIN LUGAR ON ING_LUGAR = LUG_ID\n"
                + "INNER JOIN SETOR_DIA ON LUG_DIA = SD_DIA AND LUG_SETOR = SD_SETOR\n"
                + "WHERE LUG_DIA = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, dia);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ingressosTotais++;
            valorTotal += rs.getDouble("SD_PRECO");
        }

        if (resposta.equalsIgnoreCase("valorTotal")) {
            return ingressosTotais;
        } else {
            return valorTotal;
        }

    }

}
