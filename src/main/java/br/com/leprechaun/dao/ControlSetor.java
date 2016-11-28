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
    PreparedStatement stmt;
    ResultSet rs;

    public ControlSetor() {
        this.conn = new ConnectionFactory().getConnection();
    }

    public void cadastraSetor(ModelSetor setor) throws SQLException {
        String sql = "INSERT INTO SETOR(SET_DESCRICAO) VALUES(?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, setor.getDescricao());
        stmt.execute();
    }

    public List<ModelSetor> getSetor() throws SQLException {
        List<ModelSetor> listSetor = new ArrayList<>();
        String sql = "SELECT * FROM SETOR";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while (rs.next()) {
            ModelSetor setor = new ModelSetor();
            setor.setIdSetor(rs.getInt("SET_ID"));
            setor.setDescricao(rs.getString("SET_DESCRICAO"));
            listSetor.add(setor);
        }
        return listSetor;
    }

    public int recuperaIdSetor() {
        try {
            String sql = "SELECT SET_ID FROM SETOR ORDER BY SET_ID DESC LIMIT 1";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            int idSetor = 0;
            while (rs.next()) {
                idSetor = rs.getInt("SET_ID");
            }
            return idSetor;
        } catch (SQLException ex) {
            System.err.println("Erro ao recuperar id do setor!\n" + ex);
            return 1;
        }
    }

    public String setorMaisLotado() throws SQLException {
        int idMaior;
        int x = 0;
        int y = 0;
        String sql
                = "USE ESTADIO;\n"
                + "SELECT LUG_SETOR, count(*)\n"
                + "FROM INGRESSO\n"
                + "INNER JOIN LUGAR ON ING_LUGAR = LUG_ID\n"
                + "INNER JOIN SETOR_DIA ON LUG_SETOR = SD_SETOR AND LUG_DIA = SD_DIA\n"
                + "INNER JOIN SETOR ON SD_SETOR = SET_DESCRICAO\n"
                + "GROUP BY LUG_SETOR\n"
                + "HAVING COUNT(*) > 1;";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while (rs.next()) {
            for (ModelSetor modelSetor : getSetor()) {
                if (rs.getInt("LUG_SETOR") == modelSetor.getIdSetor() && rs.getInt("LUG_DIA") == 2) {
                    x++;
                }
            }
        }

    }
}
