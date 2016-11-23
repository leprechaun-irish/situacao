package br.com.leprechaun.util;

import br.com.leprechaun.dao.ControlSD;
import br.com.leprechaun.model.ModelSetor;
import java.sql.SQLException;

public class TesteList {

    public static void main(String[] args) throws SQLException {

        ControlSD sd = new ControlSD();
        
        int dia = 1;
        
        for(ModelSetor setor : sd.consulta(dia)){
            System.out.println(setor.getIdSetor()+" / "+setor.getDescricao());
        }
    }

}
