package br.com.leprechaun.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        Connection conn;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String user = "root";
            String pass = "123456";
            String host = "localhost";
            String port = "3306";
            String db = "estadio";
            String url = "jdbc:mysql://"+host+":"+port+"/"+db;
            conn = DriverManager.getConnection(url, user, pass);
            return conn;
        } catch (ClassNotFoundException ex) {
            System.err.println("Erro no driver!\n"+ex);
            return null;
        } catch (SQLException ex) {
            System.err.println("Erro no banco de dados!\n"+ex);
            return null;
        }
    }
}
