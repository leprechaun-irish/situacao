package br.com.leprechaun.util;

import br.com.leprechaun.dao.ControlIngresso;
import br.com.leprechaun.model.ModelCliente;
import br.com.leprechaun.model.ModelIngresso;
import br.com.leprechaun.model.ModelLugar;

public class TestaCadIng {
    public static void main(String[] args) {
        ControlIngresso ci = new ControlIngresso();
        ModelIngresso ingresso = new ModelIngresso();
        ModelCliente cliente = new ModelCliente();
        ModelLugar lugar = new ModelLugar();
        cliente.setIdCliente(2);
        lugar.setIdLugar(2);
        ingresso.setCliente(cliente);
        ingresso.setLugar(lugar);
        ci.cadastraIngresso(ingresso);
        System.out.println("BLZA");
    }
}
