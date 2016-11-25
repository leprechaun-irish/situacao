package br.com.leprechaun.util;

import br.com.leprechaun.dao.ControlLugar;
import br.com.leprechaun.dao.ControlSD;
import br.com.leprechaun.model.ModelLugar;
import br.com.leprechaun.model.ModelSetor;
import java.sql.SQLException;

public class TesteList {

    public static void main(String[] args) throws SQLException {

        ControlSD sd = new ControlSD();
        ControlLugar cl = new ControlLugar();
        int dia = 1;
        
        for(ModelLugar lugar : cl.getLugar()){
            System.out.println(lugar.getSetor().getDescricao());
        }
    }

}
