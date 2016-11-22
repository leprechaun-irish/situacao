package br.com.leprechaun.util;

import br.com.leprechaun.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileiraDiaDB {

    public static void main(String[] args) throws SQLException {
        Connection conn = new ConnectionFactory().getConnection();
        for (int x = 2; x > 0; x--) {
            String sql = "INSERT INTO DIA(DIA_ID) VALUES(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, x);
            stmt.execute();
        }
        for (int x = 25; x > 0; x--) {
            String sql = "INSERT INTO FILEIRA(FIL_ID) VALUES(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, x);
            stmt.execute();
        }
        
        String sql = "INSERT INTO SETOR(SET_DESCRICAO, SET_DIA, SET_PRECO) VALUES(?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "Amarelo");
        stmt.setInt(2, 1);
        stmt.setDouble(3, 25);
        stmt.execute();
        
        stmt.setString(1, "Azul");
        stmt.setInt(2, 1);
        stmt.setDouble(3, 25);
        stmt.execute();
        
        stmt.setString(1, "Verde");
        stmt.setInt(2, 1);
        stmt.setDouble(3, 50);
        stmt.execute();
        
        stmt.setString(1, "Branco");
        stmt.setInt(2, 1);
        stmt.setDouble(3, 50);
        stmt.execute();

    }
}
