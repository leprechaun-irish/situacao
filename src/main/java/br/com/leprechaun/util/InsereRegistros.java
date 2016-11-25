package br.com.leprechaun.util;

import br.com.leprechaun.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsereRegistros {

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
        
        for (int x = 20; x > 0; x--) {
            String sql = "INSERT INTO CADEIRA(CAD_ID) VALUES(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, x);
            stmt.execute();
        }
        
        String sql = "INSERT INTO SETOR(SET_DESCRICAO) VALUES(?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "Amarelo");
        stmt.execute();
        
        stmt.setString(1, "Azul");
        stmt.execute();
        
        stmt.setString(1, "Verde");
        stmt.execute();
        
        stmt.setString(1, "Branco");
        stmt.execute();
        
        sql = "INSERT INTO SETOR_DIA(SD_SETOR, SD_DIA, SD_PRECO) VALUES(?,?,?)";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, 1);
        stmt.setInt(2, 1);
        stmt.setDouble(3, 25);
        stmt.execute();
        
        stmt.setInt(1, 1);
        stmt.setInt(2, 2);
        stmt.setDouble(3, 50);
        stmt.execute();
        
        stmt.setInt(1, 2);
        stmt.setInt(2, 1);
        stmt.setDouble(3, 25);
        stmt.execute();
        
        stmt.setInt(1, 2);
        stmt.setInt(2, 2);
        stmt.setDouble(3, 50);
        stmt.execute();
        
        stmt.setInt(1, 3);
        stmt.setInt(2, 1);
        stmt.setDouble(3, 50);
        stmt.execute();
        
        stmt.setInt(1, 3);
        stmt.setInt(2, 2);
        stmt.setDouble(3, 100);
        stmt.execute();
        
        stmt.setInt(1, 4);
        stmt.setInt(2, 1);
        stmt.setDouble(3, 50);
        stmt.execute();
        
        stmt.setInt(1, 4);
        stmt.setInt(2, 2);
        stmt.setDouble(3, 100);
        stmt.execute();
    }
}
