package org.lessons.java.shop;

import java.math.BigDecimal;

public class Smartphone extends Prodotto {
    private String IMEI;
    private int memoria;

    public Smartphone(String nome, String marca, BigDecimal prezzo, BigDecimal iva, String IMEI, int memoria) {
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

    public int getMemoiria() {
        return this.memoria;
    }

    public void setMemoria(int memoria) {
        if (memoria >= 0) {
            this.memoria = memoria;
        }
    }
    @Override
    public String toString() {
        return super.toString() + String.format(" Lo smartphone ha una memoria di %o gb. %n", this.memoria);
    }
}
