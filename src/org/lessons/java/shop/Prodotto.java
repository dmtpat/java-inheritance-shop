package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Prodotto {

    private int Codice;
    private String nome;
    private String marca;
    private BigDecimal prezzo;
    private BigDecimal iva;

    //* costruttore
    protected Prodotto(String nome, String marca, BigDecimal prezzo, BigDecimal iva) {
        Random _codice = new Random();
        this.Codice = _codice.nextInt(9999);
        this.nome = nome;
        this.marca = marca;
        this.prezzo = prezzo;
        this.iva = iva;
    }

    //* getter setter
    public String getCodice() {
        return String.format("%i", this.Codice);
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return this.nome;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setPrezzo(BigDecimal prezzo) {
        if (prezzo.compareTo(new BigDecimal(0)) >= 0) {
            this.prezzo = prezzo.setScale(2, RoundingMode.DOWN);
        }
    }

    public BigDecimal getPrezzo(){
        return this.prezzo;
    }

    public void setIva(BigDecimal iva) {
        if (iva.compareTo(new BigDecimal(0.04)) == 0 || iva.compareTo(new BigDecimal(0.1)) == 0
                || iva.compareTo(new BigDecimal(0.22)) == 0) {
            this.iva = iva.setScale(2, RoundingMode.DOWN);
        }
    }
    public BigDecimal getIva(){
        return this.iva;
    }

    public BigDecimal getTotalPrezzo() {
        return this.prezzo.add(this.prezzo.multiply(this.iva)).setScale(2, RoundingMode.DOWN);
    }

    public String toString() {
        return String.format("Il prodotto %s ha un prezzo totale di euro %s", this.nome,
                this.getTotalPrezzo().toString());
    }
}
