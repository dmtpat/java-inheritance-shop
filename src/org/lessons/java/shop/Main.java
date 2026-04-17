package org.lessons.java.shop;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Cuffie rosaBlue = new Cuffie("rosaBlue", "logitech", new BigDecimal(39.90),new BigDecimal( 0.22), "rosaBlue", true);
        Televisori ugo = new Televisori("Ugo", "samsung", new BigDecimal(450), new BigDecimal(0.22), "56", true);
        Smartphone pina = new Smartphone("Pina", "apple", new BigDecimal(900.01), new BigDecimal(0.22),
                "in2345697as125", 128);

                 System.out.println(rosaBlue);
                 System.out.println(ugo);
                 System.out.println(pina);
                 Carrello cart1 = new Carrello();
                 cart1.addList(pina);
                 cart1.addList(ugo);
                 cart1.addList(rosaBlue);
                 System.out.println(cart1);
                // System.out.println(rosaBlue.getNome());
                // System.out.println(rosaBlue.getTotalPrezzo());
                // System.out.println(rosaBlue.getColore());
                // System.out.println(rosaBlue.getIsWireless());
                // System.out.println(rosaBlue.getMarca());
               
                // System.out.println(ugo.getNome());
                // System.out.println(ugo.getTotalPrezzo());
                // System.out.println(ugo.getDimensioni());
                // System.out.println(ugo.getIsSmart());
                // System.out.println(ugo.getMarca());

                //  System.out.println(pina.getNome());
                //  System.out.println(pina.getTotalPrezzo());
                //  System.out.println(pina.getMemoiria());
                //  System.out.println(pina.getIMEI());
                //  System.out.println(pina.getMarca());
    }
}
