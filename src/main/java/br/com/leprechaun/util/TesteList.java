package br.com.leprechaun.util;

import br.com.leprechaun.dao.ControlCadeira;
import br.com.leprechaun.model.ModelCadeira;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteList {

    public static void main(String[] args) throws SQLException {

        ControlCadeira ctrlCadeira = new ControlCadeira();

        List<ModelCadeira> listMcOcupadas = new ArrayList<>();
        listMcOcupadas = ctrlCadeira.buscaCadeiraOcupada(2, 4, 16);

        for (ModelCadeira mc : listMcOcupadas) {
            System.out.println("OCUPADAS: " + mc.getIdCadeira());
        }

        List<ModelCadeira> listMcAll = new ArrayList<>();
        
        for (ModelCadeira mc : listMcAll) {
            System.out.println("VAZIAS: " + mc.getIdCadeira());
        }        
        
        System.out.println("LIVRE: " + ctrlCadeira.buscaCadeiraVazia());
    }
}