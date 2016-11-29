package br.com.leprechaun.dao;

import br.com.leprechaun.connection.ConnectionFactory;
import br.com.leprechaun.model.ModelDia;
import br.com.leprechaun.model.ModelSD;
import br.com.leprechaun.model.ModelSetor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlSD {

    Connection conn;

    public ControlSD() {
        this.conn = new ConnectionFactory().getConnection();
    }

    public void cadastraSD(ModelSD sd) throws SQLException {
        String sql = "INSERT INTO SETOR_DIA(SD_SETOR, SD_DIA, SD_PRECO) VALUES(?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, sd.getSetor().getIdSetor());
        stmt.setInt(2, sd.getDia().getIdDia());
        stmt.setDouble(3, sd.getPreco());
        stmt.execute();
    }

    public List<ModelSD> getList() throws SQLException {
        List<ModelSD> listSD = new ArrayList<>();
        String sql = "SELECT SETOR_DIA.*, SETOR.SET_DESCRICAO FROM SETOR_DIA INNER JOIN SETOR ON SETOR.SET_ID=SETOR_DIA.SD_SETOR";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ModelSD sd = new ModelSD();
            ModelDia dia = new ModelDia();
            ModelSetor setor = new ModelSetor();
            sd.setIdSD(rs.getInt("SD_ID"));
            dia.setIdDia(rs.getInt("SD_DIA"));
            setor.setIdSetor(rs.getInt("SD_SETOR"));
            setor.setDescricao(rs.getString("SET_DESCRICAO"));
            sd.setDia(dia);
            sd.setSetor(setor);
            sd.setPreco(rs.getDouble("SD_PRECO"));
            listSD.add(sd);
        }
        return listSD;
    }

    public List<ModelSetor> consultaDiaSetor(int dia) throws SQLException {
        List<ModelSetor> listSetorDia = new ArrayList<>();
        String sql = "SELECT SETOR.SET_ID ,SETOR.SET_DESCRICAO FROM SETOR_DIA INNER JOIN SETOR ON SETOR_DIA.SD_SETOR=SETOR.SET_ID WHERE SD_DIA=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, dia);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ModelSetor modelSetor = new ModelSetor();
            modelSetor.setIdSetor(rs.getInt("SET_ID"));
            modelSetor.setDescricao(rs.getString("SET_DESCRICAO"));
            listSetorDia.add(modelSetor);
        }
        return listSetorDia;
    }

    public void removeSD(ModelSD modelSD, ModelSetor modelSetor) throws SQLException {
        String sql = "DELETE SETOR_DIA,SETOR FROM SETOR_DIA,SETOR WHERE SD_ID=? AND SETOR.SET_ID=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, modelSD.getIdSD());
        stmt.setInt(2, modelSetor.getIdSetor());
        stmt.execute();
        stmt.close();
        sql = "";
    }

    public double buscaPreco(int dia, int setor){
        try {
            String sql = "SELECT SETOR_DIA.SD_PRECO FROM SETOR_DIA INNER JOIN DIA ON SETOR_DIA.SD_DIA=? INNER JOIN SETOR ON SETOR_DIA.SD_SETOR=? LIMIT 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, dia);
            stmt.setInt(2, setor);
            ResultSet rs = stmt.executeQuery();
            double preco=0;
            while(rs.next()){
                preco = rs.getDouble("SD_PRECO");
            }
            return preco;
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar preço!\n"+ex);
            return 0;
        }
    }
}
