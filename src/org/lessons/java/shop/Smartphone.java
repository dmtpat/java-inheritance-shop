package org.lessons.java.shop;

import java.math.BigDecimal;

public class Smartphone extends Prodotto {
    private String IMEI;
    private float memoria;

    public Smartphone(String nome, String marca, BigDecimal prezzo, BigDecimal iva, String IMEI, float memoria) {
        super(nome, marca, prezzo, iva);
        this.IMEI = IMEI.toUpperCase();
        this.memoria = memoria;
    }

    public String getIMEI() {
        return this.IMEI;
    }

    private void setIMEI(String IMEI) {
        this.IMEI = IMEI.toUpperCase();
    }

    public float getMemoiria() {
        return this.memoria;
    }

    public void setMemoria(float memoria) {
        if (memoria >= 0) {
            this.memoria = memoria;
        }
    }
}
