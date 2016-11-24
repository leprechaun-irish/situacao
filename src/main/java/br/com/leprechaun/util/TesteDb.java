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

//----------------Atribuindo valores--------------------------------------------
        modelCliente.setIdCliente(ctrlCliente.recuperaIdCliente());
        modelCliente.setNome("Bolsonaro");
        modelCliente.setEmail("bolsonaro@bolsonaro.com");
        ctrlCliente.cadastraCliente(modelCliente);
        
        modelDia.setIdDia(1);
        
        modelSetor.setIdSetor(1);
        
        modelFileira.setIdFileira(1);
        
        modelLugar.setIdLugar(ctrlLugar.recuperaIdLugar());
        modelLugar.setCadeira(1);
        modelLugar.setDia(modelDia);
        modelLugar.setSetor(modelSetor);
        modelLugar.setFileira(modelFileira);
        ctrlLugar.cadastraLugar(modelLugar);
        
        modelIngresso.setLugar(modelLugar);
        modelIngresso.setCliente(modelCliente);
        ctrlIngresso.cadastraIngresso(modelIngresso);
    }
}
