package br.com.leprechaun.util;

import br.com.leprechaun.dao.*;
import br.com.leprechaun.model.*;

public class TesteDb {

    public static void main(String[] args) {
//----------------Instanciando Control------------------------------------------
        ControlCliente ctrlCliente = new ControlCliente();
        ControlLugar ctrlLugar = new ControlLugar();
        ControlIngresso ctrlIngresso = new ControlIngresso();

//----------------Instanciando Model--------------------------------------------
        ModelCliente modelCliente = new ModelCliente();
        ModelDia modelDia = new ModelDia();
        ModelSetor modelSetor = new ModelSetor();
        ModelFileira modelFileira = new ModelFileira();
        ModelIngresso modelIngresso = new ModelIngresso();
        ModelLugar modelLugar = new ModelLugar();
        ModelCadeira modelCadeira = new ModelCadeira();
        
//----------------Atribuindo valores--------------------------------------------
        modelCliente.setNome("Lucas");
        modelCliente.setEmail("lucascaetanosantos@hotmail.com");
        ctrlCliente.cadastraCliente(modelCliente);
        modelCliente.setIdCliente(ctrlCliente.recuperaIdCliente());
        
        modelDia.setIdDia(1);
        modelSetor.setIdSetor(1);
        modelFileira.setIdFileira(1);
        modelCadeira.setIdCadeira(1);
        modelLugar.setCadeira(modelCadeira);

        modelLugar.setDia(modelDia);
        modelLugar.setFileira(modelFileira);
        modelLugar.setSetor(modelSetor);
        ctrlLugar.cadastraLugar(modelLugar);
        modelLugar.setIdLugar(ctrlLugar.recuperaIdLugar());
        
        modelIngresso.setCliente(modelCliente);
        modelIngresso.setLugar(modelLugar);
        ctrlIngresso.cadastraIngresso(modelIngresso);
    }
}
