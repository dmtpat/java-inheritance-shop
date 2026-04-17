package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    @Override
    public BigDecimal getTotalPrezzo() {
        if (this.memoria< 32 && Carrello.hasFidelity) {
            BigDecimal _prezzo = super.getPrezzo().add(super.getPrezzo().multiply(super.getIva())).setScale(2, RoundingMode.DOWN);
            _prezzo = _prezzo.subtract(_prezzo.multiply(new BigDecimal(0.05)));
            return _prezzo;
        } else {
            return super.getTotalPrezzo();
        }
    }

}
