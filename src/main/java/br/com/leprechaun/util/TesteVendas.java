
package br.com.leprechaun.util;

import br.com.leprechaun.dao.ControlIngresso;
import java.sql.SQLException;

public class TesteVendas {

    public static void main(String[] args) {
        ControlIngresso ci = new ControlIngresso();
        try {
            System.out.println(ci.totalDiaArrecadado(1));
        } catch (SQLException ex) {
            System.out.println("Erro mais loko que o batman" + ex);
        }
    }

}
