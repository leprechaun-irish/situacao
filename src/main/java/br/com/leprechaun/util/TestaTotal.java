
package br.com.leprechaun.util;

import br.com.leprechaun.dao.ControlIngresso;

public class TestaTotal {
    
    public static void main(String[] args) {
        ControlIngresso controlIngresso = new ControlIngresso();
        System.out.println("Total arrecadado: "+controlIngresso.totalArrecadado());
    }
    
}
