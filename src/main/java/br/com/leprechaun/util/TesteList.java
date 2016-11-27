package br.com.leprechaun.util;

import br.com.leprechaun.dao.ControlCadeira;
import br.com.leprechaun.model.ModelCadeira;
import java.sql.SQLException;

public class TesteList {

    public static void main(String[] args) throws SQLException {

        ControlCadeira ctrlCadeira = new ControlCadeira();
        
        for(ModelCadeira cad : ctrlCadeira.buscaCadeiraVazia(1, 1, 1)){
            System.out.println("Cadeira: "+cad.getIdCadeira());
        }
    }

}
