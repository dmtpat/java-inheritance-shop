package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Televisori extends Prodotto {

    private String dimensioni;
    private boolean isSmart;

    //* costruttore
    public Televisori(String nome, String marca, BigDecimal prezzo, BigDecimal iva, String dimensioni,
            boolean isSmart) {
        super(nome, marca, prezzo, iva);
        this.dimensioni = dimensioni;
        this.isSmart = isSmart;
    }
    
    //* getter setter ---------------------------------->^.^<--------------------------------------------------------
    public String getDimensioni() {
        return this.dimensioni;
    }

    private void setDimensioni(String dimensioni) {
        if (dimensioni != null) {
            this.dimensioni = dimensioni;
        }
    }

    public boolean getIsSmart() {
        return this.isSmart;
    }

    public void setIsSmart(boolean isSmart) {
        this.isSmart = isSmart;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Il televisore ha una dimensione di %s pollici. La tv è smart: %b. %n",
                this.dimensioni, this.isSmart);
    }
    @Override
    public BigDecimal getTotalPrezzo() {
        if (!this.isSmart && Carrello.hasFidelity) {
            BigDecimal _prezzo = super.getPrezzo().add(super.getPrezzo().multiply(super.getIva())).setScale(2, RoundingMode.DOWN);
            _prezzo = _prezzo.subtract(_prezzo.multiply(new BigDecimal(0.1)));
            return _prezzo;
        } else {
            return super.getTotalPrezzo();
        }
    }

}
