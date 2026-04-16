package org.lessons.java.shop;

import java.math.BigDecimal;

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
        return super.toString() + String.format(" Il televisore ha una dimensione di %s pollici. La tv è smart: %b",
                this.dimensioni, this.isSmart);
    }
}
