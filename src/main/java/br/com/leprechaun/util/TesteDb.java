package br.com.leprechaun.util;

import br.com.leprechaun.dao.*;
import br.com.leprechaun.model.*;
import java.sql.SQLException;

public class TesteDb {

    public static void main(String[] args) {
        try {
            ModelCliente modelCliente = new ModelCliente();
            ModelDia modelDia = new ModelDia();
            ModelSetor modelSetor = new ModelSetor();
            ModelFileira modelFileira = new ModelFileira();
            ModelIngresso modelIngresso = new ModelIngresso();
            ModelLugar modelLugar = new ModelLugar();

//----------------Atribuindo valores--------------------------------------------
            modelCliente.setNome("Lucas");
            modelCliente.setEmail("lucascaetanosantos@hotmail.com");
            modelDia.setIdDia(1);
            modelSetor.setIdSetor(1);
            modelFileira.setIdFileira(18);
            modelLugar.setCadeira(18);
            modelLugar.setIdLugar(1);

            modelLugar.setDia(modelDia);
            modelLugar.setFileira(modelFileira);
            modelLugar.setSetor(modelSetor);
            modelIngresso.setCliente(modelCliente);
            modelIngresso.setLugar(modelLugar);

//----------------Instanciando Control------------------------------------------
            ControlCliente ctrlCliente = new ControlCliente();
            ControlIngresso ctrlIngresso = new ControlIngresso();

//----------------Atribuindo Valor---------------------------------------------------------
            ctrlCliente.cadastraCliente(modelCliente);
            ctrlIngresso.cadastraIngresso(modelIngresso);
        } catch (SQLException ex) {
            System.err.println("Deu um erro bem loko\n"+ex);
        }
    }
}
