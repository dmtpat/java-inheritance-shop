package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;


public class Carrello {

    private Prodotto[] lista;
    static boolean hasFidelity;

    public Carrello() {
        this.lista = new Prodotto[0];
        this.hasFidelity = false;
    }

    public void addList(Prodotto prodotto) {
        Prodotto[] _lista = new Prodotto[this.lista.length + 1];
        for (int i = 0; i < this.lista.length; i++) {
            _lista[i] = this.lista[i];
        }
        _lista[_lista.length - 1] = prodotto;
        this.lista = _lista;
    }

    public String toString() {
        String _output = "";
        for (int i = 0; i < lista.length; i++) {
            _output += lista[i].toString();
        }
        return _output;
    }

    private void setHasFidelity(boolean hasFidelity) {
        this.hasFidelity = hasFidelity;
    }

    public boolean checkFidelity(String fidelityNumber, String[] fidelityCards) {
        boolean isPresent = false;
        int i = 0;
        while (i < fidelityCards.length || !isPresent) {
            if (fidelityCards[i].equals(fidelityNumber)) {
                isPresent = true;
            } else {
                i++;
            }
        }
        this.setHasFidelity(isPresent);
        return isPresent;
    }
    
    public BigDecimal getTotal() {
        BigDecimal _total = new BigDecimal(0).setScale(2, RoundingMode.DOWN);
        for (int i = 0; i < lista.length; i++) {
            _total = _total.add(lista[i].getTotalPrezzo());
        }
        return _total;
    }

    public static void main(String[] args) {
        String[] fidelityCards = { "1234", "4567", "7890" };

        Carrello cart1 = new Carrello();
        String tipoProdotto;
        String nomeProdotto;

        Scanner input = new Scanner(System.in);
        System.out.println("Riempiamo il Carrello!");
        System.out.print("Sei in possesso di una carta fedeltà? s/n ");
        if (input.nextLine().toLowerCase().equals("s")) {
            
            System.out.print("Inserisci il codice della tua carta: ");
            // String fidelityNumber = input.nextLine().toUpperCase();
            if (!cart1.checkFidelity(input.nextLine().toUpperCase(), fidelityCards)) {
                System.out.println("La carta fedeltà inserita non è valida.");
            }

        }
        boolean wantInsert = true;
        do {
    

            System.out.print("Che tipo di prodotto vuole inserire: cuffie, smartphone o televisore? ");
            tipoProdotto = input.nextLine().toLowerCase();
            System.out.print("Inserisci il nome del prodotto: ");
            nomeProdotto = input.nextLine().toLowerCase();

            if (tipoProdotto.equals("cuffie")) {
                System.out.print("Inserisci la marca:");
                String _marca = input.nextLine();
                System.out.print("Inserisci il prezzo:");
                BigDecimal _prezzo = new BigDecimal(input.nextLine()).setScale(2, RoundingMode.DOWN);
                System.out.print("Inserisci l'iva in formato decimale:");
                BigDecimal _iva = new BigDecimal(input.nextLine()).setScale(2, RoundingMode.DOWN);
                System.out.print("Inserisci il colore:");
                String _colore = input.nextLine();
                System.out.print("Sono wireless? s/n ");
                boolean _isWireless = false;
                if (input.nextLine().toLowerCase().equals( "s" )){
                    _isWireless = true;
                }
                Cuffie prodotto1 = new Cuffie(nomeProdotto, _marca, _prezzo, _iva, _colore, _isWireless);
                cart1.addList(prodotto1);
                
            } else if (tipoProdotto.equals( "smartphone")) {
                System.out.print("Inserisci la marca:");
                String _marca = input.nextLine();
                System.out.print("Inserisci il prezzo:");
                BigDecimal _prezzo = new BigDecimal(input.nextLine()).setScale(2, RoundingMode.DOWN);
                System.out.print("Inserisci l'iva in formato decimale:");
                BigDecimal _iva = new BigDecimal(input.nextLine()).setScale(2, RoundingMode.DOWN);
                System.out.print("Inserisci il codice IMEI:");
                String _IMEI = input.nextLine().toUpperCase();
                System.out.print("Inserisci la quantità di memoria:");
                int _memoria = input.nextInt();

                Smartphone prodotto1 = new Smartphone(nomeProdotto, _marca, _prezzo, _iva, _IMEI, _memoria);
                cart1.addList(prodotto1);

            } else if (tipoProdotto.equals("televisore")) {
                System.out.print("Inserisci la marca:");
                String _marca = input.nextLine();
                System.out.print("Inserisci il prezzo:");
                BigDecimal _prezzo = new BigDecimal(input.nextLine()).setScale(2, RoundingMode.DOWN);
                System.out.print("Inserisci l'iva in formato decimale:");
                BigDecimal _iva = new BigDecimal(input.nextLine()).setScale(2, RoundingMode.DOWN);
                System.out.print("Inserisci la dimensione :");
                String _dimensione = input.nextLine();
                System.out.print("È Smart? s/n ");
                boolean _isSmart = false;
                if (input.nextLine().toLowerCase().equals( "s")) {
                    _isSmart = true;
                }
                Televisori prodotto1 = new Televisori(nomeProdotto, _marca, _prezzo, _iva, _dimensione, _isSmart);
                cart1.addList(prodotto1);
            } else {
                System.out.print("Il prodotto "+ tipoProdotto + " non è presente");
            }
            System.out.print("Vuoi inserire un nuovo articolo? s/n ");
            if (input.nextLine().toLowerCase().equals("n")) {
                wantInsert = false;
            }
            
        } while (wantInsert);

        input.close();
        System.out.println("Ecco il contenuto del tuo carrello:");
        System.out.print(cart1);
        System.out.print("Il totale del carrello è di euro " + cart1.getTotal());
    }
}
