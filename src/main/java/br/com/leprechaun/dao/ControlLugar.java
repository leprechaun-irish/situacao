package br.com.leprechaun.dao;

import br.com.leprechaun.connection.ConnectionFactory;
import br.com.leprechaun.model.ModelCadeira;
import br.com.leprechaun.model.ModelDia;
import br.com.leprechaun.model.ModelFileira;
import br.com.leprechaun.model.ModelLugar;
import br.com.leprechaun.model.ModelSetor;
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

    public void cadastraLugar(ModelLugar lugar) {
        try {
            String sql = "INSERT INTO LUGAR(LUG_CADEIRA, LUG_FILEIRA, LUG_DIA, LUG_SETOR) VALUES(?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, lugar.getCadeira().getIdCadeira());
            stmt.setInt(2, lugar.getFileira().getIdFileira());
            stmt.setInt(3, lugar.getDia().getIdDia());
            stmt.setInt(4, lugar.getSetor().getIdSetor());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar lugar \n" + ex);
        }
    }

    public List<ModelLugar> getLugar() throws SQLException {
        List<ModelLugar> listLugar = new ArrayList<>();
        String sql = "SELECT * FROM LUGAR";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ModelLugar lugar = new ModelLugar();
            ModelFileira fileira = new ModelFileira();
            ModelDia dia = new ModelDia();
            ModelCadeira cadeira = new ModelCadeira();
            ModelSetor setor = new ModelSetor();

            lugar.setIdLugar(rs.getInt("LUG_ID"));
            cadeira.setIdCadeira(rs.getInt("LUG_CADEIRA"));
            fileira.setIdFileira(rs.getInt("LUG_FILEIRA"));
            setor.setIdSetor(rs.getInt("LUG_SETOR"));
            dia.setIdDia(rs.getInt("LUG_DIA"));
            lugar.setCadeira(cadeira);
            lugar.setFileira(fileira);
            lugar.setSetor(setor);
            lugar.setDia(dia);
            listLugar.add(lugar);
        }
        return listLugar;
    }

    public int recuperaIdLugar() {
        try {
            String sql = "SELECT LUG_ID FROM LUGAR ORDER BY LUG_ID DESC LIMIT 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            int idLugar = 0;
            while (rs.next()) {
                idLugar = rs.getInt("LUG_ID");
            }
            return idLugar;
        } catch (SQLException ex) {
            System.err.println("Erro ao recuperar id do lugar!\n" + ex);
            return 1;
        }
    }

    public List<ModelLugar> listLugarVazio(){
        List<ModelLugar> lugarVazio = new ArrayList<>();
        
        return listLugarVazio();
    }
}
