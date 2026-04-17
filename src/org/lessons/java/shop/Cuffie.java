package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cuffie extends Prodotto {
    private String colore;
    private boolean iswireless;

    //* costruttore------------------------------------------------------------->^.^<-------------------------------------
    public Cuffie(String nome, String marca, BigDecimal prezzo, BigDecimal iva, String colore, boolean iswireless) {
        super(nome, marca, prezzo, iva);
        this.colore = colore;
        this.iswireless = iswireless;
    }

    //* getter&setter------------------------------------------------------------->^.^<-------------------------------------
    public String getColore() {
        return this.colore;
    }
    
    private void setColore(String colore) {
        if (colore != null) {
            this.colore = colore;
        }
    }

    public boolean getIsWireless() {
        return this.iswireless;
     }

     private void setIsWireless(boolean iswireless) {
         this.iswireless = iswireless;
     }
    @Override
    public String toString() {
        return super.toString()
                + String.format(" Le cuffie sono di colore %s. Sono wireless: %b. %n", this.colore, this.iswireless);
    }

    @Override
    public BigDecimal getTotalPrezzo() {
        if (!this.iswireless && Carrello.hasFidelity) {
            BigDecimal _prezzo = super.getPrezzo().add(super.getPrezzo().multiply(super.getIva())).setScale(2, RoundingMode.DOWN);
            _prezzo = _prezzo.subtract(_prezzo.multiply(new BigDecimal(0.07)));
            return _prezzo;
        } else {
            return super.getTotalPrezzo();
        }
    }


}
