package br.com.leprechaun.dao;

import br.com.leprechaun.connection.ConnectionFactory;
import br.com.leprechaun.model.ModelCadeira;
import br.com.leprechaun.model.ModelCliente;
import br.com.leprechaun.model.ModelDia;
import br.com.leprechaun.model.ModelFileira;
import br.com.leprechaun.model.ModelIngresso;
import br.com.leprechaun.model.ModelLugar;
import br.com.leprechaun.model.ModelSD;
import br.com.leprechaun.model.ModelSetor;
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
        String sql = "INSERT INTO INGRESSO(ING_CLIENTE, ING_LUGAR, ING_PRECO) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ingresso.getCliente().getIdCliente());
            stmt.setInt(2, ingresso.getLugar().getIdLugar());
            stmt.setDouble(3, ingresso.getPreco());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar ingresso \n" + e);
        }
    }

    public List<ModelIngresso> getIngresso() throws SQLException {
        List<ModelIngresso> listIngresso = new ArrayList<>();
        String sql = "SELECT \n"
                + "	INGRESSO.ING_ID,\n"
                + "	 CLIENTE.CLI_NOME,\n"
                + "	  LUGAR.LUG_DIA,\n"
                + "	   SETOR.SET_DESCRICAO,\n"
                + "		 LUGAR.LUG_FILEIRA,\n"
                + "		  LUGAR.LUG_CADEIRA,\n"
                + "		  	INGRESSO.ING_PRECO,\n"
                + "		    INGRESSO.ING_DATA\n"
                + "FROM\n"
                + " 	INGRESSO\n"
                + "INNER JOIN CLIENTE ON INGRESSO.ING_CLIENTE=CLIENTE.CLI_ID\n"
                + "INNER JOIN LUGAR ON INGRESSO.ING_LUGAR=LUGAR.LUG_ID\n"
                + "INNER JOIN SETOR ON LUGAR.LUG_SETOR=SETOR.SET_ID";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ModelIngresso ingresso = new ModelIngresso();
            ModelCliente cliente = new ModelCliente();
            ModelLugar lugar = new ModelLugar();
            ControlSD ctrlSD = new ControlSD();
            ModelDia dia = new ModelDia();
            ModelSetor setor = new ModelSetor();
            ModelFileira fileira = new ModelFileira();
            ModelCadeira cadeira = new ModelCadeira();

            ingresso.setIdIngresso(rs.getInt("ING_ID"));
            cliente.setNome(rs.getString("CLI_NOME"));
            dia.setIdDia(rs.getInt("LUG_DIA"));
            setor.setDescricao(rs.getString("SET_DESCRICAO"));
            fileira.setIdFileira(rs.getInt("LUG_FILEIRA"));
            cadeira.setIdCadeira(rs.getInt("LUG_CADEIRA"));

            lugar.setDia(dia);
            lugar.setSetor(setor);
            lugar.setFileira(fileira);
            lugar.setCadeira(cadeira);

            ingresso.setCliente(cliente);
            ingresso.setLugar(lugar);
            ingresso.setPreco(rs.getDouble("ING_PRECO"));
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
