
package br.com.leprechaun.util;

import br.com.leprechaun.dao.ControlCadeira;
import br.com.leprechaun.model.ModelCadeira;
import java.sql.SQLException;

public class TesteBuscaCadeira {

    public static void main(String[] args) throws SQLException{
        ControlCadeira controlCadeira = new ControlCadeira();
        for(ModelCadeira cadeira : controlCadeira.buscaCadeiraVazia(1, 1, 1)){
            System.out.println("Dia: "+cadeira.getIdCadeira());
        }
    }
    
}
