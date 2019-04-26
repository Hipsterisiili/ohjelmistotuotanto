package juuri.sovelluslogiikka;

import java.io.File;
import juuri.sovelluslogiikka.Tuote;
import juuri.sovelluslogiikka.Varasto;
import java.util.ArrayList;
import java.util.Scanner;

public class Tilaus {

    private int[] maarat;

    private Varasto varasto;
    private boolean toteutettu;
    private int tilausnumero;
    private int arvo;

    /**
     * Konstruktori, joka luo tyhjän tilauksen, jossa on paikkoja tuotteille
     * yhtä monta kuin varastossa on tuotteita.
     *
     * @param a Varasto, johon tilaus tulee liittymään
     */
    public Tilaus(Varasto a) {
        this.varasto = a;
        this.toteutettu = false;
        this.arvo = 0;
        this.maarat = new int[a.getTuotteet().size()];
        for (int i = 0; i < a.getTuotteet().size(); i++) {
            this.maarat[i] = 0;
        }
        a.lisaaTilaus(this);
        this.tilausnumero = a.getTilaukset().size() - 1;

    }

    /**
     * Konstruktori, joka luo tilauksen, johon tulee parametrien mukainen
     * sisältö.
     *
     * @param a Varasto, joka liittyy tilaukseen.
     * @param teksti Tilauksen mahdolliset sisällöt csv:nä (erottelumerkki \n)
     * @param satunnaisluku kuinka mones tilaus csv:stä toteutetaan?
     */
    public Tilaus(Varasto a, String teksti, int satunnaisluku) {
        this.varasto = a;
        this.toteutettu = false;
        this.arvo = 0;
        this.maarat = new int[a.getTuotteet().size()];
        for (int i = 0; i < a.getTuotteet().size(); i++) {
            this.maarat[i] = 0;
        }
        a.lisaaTilaus(this);
        haeSisalto(teksti, satunnaisluku);
        this.tilausnumero = a.getTilaukset().size() - 1;
    }

    /**
     * Metodi erottelee yhden tilauksen csv:stä ja valmistuttaa sen
     *
     * @param teksti tilaus csv:nä (erottelumerkki /)
     * @param satunnaisluku kuinka mones tilaus csv:stä toteutetaan?
     */
    public void haeSisalto(String teksti, int satunnaisluku) {
        String[] taul = teksti.split("\n");
        valmista(taul[satunnaisluku]);
    }

    /**
     * Metodi valmistaa tilauksen eli lisää siihen tuotteet.
     *
     * @param rivi tilauksen tuotteet csv:nä (erottelumerkki /)
     */
    public void valmista(String rivi) {
        String[] taul = rivi.split("/");
        int a = 1;
        int b = 2;
        int c = 2;
        while (taul.length >= c) {
            lisaaTuote(taul[a], Integer.valueOf(taul[b]));
            a += 2;
            b += 2;
            c += 2;
        }

    }

    /**
     * Metodi lisää tilaukseen tuotetta, jos sellaista on varastossa. Määrä ei
     * kasva yli 20.
     *
     * @param nimi Tämän nimistä tuotetta lisätään.
     * @param maara Näin monta kappaletta lisätään.
     */
    public void lisaaTuote(String nimi, int maara) {
        if (maara < 0) {
            System.out.println("Ei voida tilata alle 1 tuotetta");
            return;
        }
        for (int i = 0; i < varasto.getTuotteet().size(); i++) {
            if (varasto.getTuotteet().get(i).getNimi().equals(nimi)) {
                this.maarat[i] += maara;
                this.arvo += maara;
                if (this.maarat[i] > 20) {
                    System.out.println("Yritetty lisätä yli 20kpl tuotetta");
                    System.out.println("Nyt tilauksessa 20kpl " + nimi);
                    this.arvo += 20 - this.maarat[i];
                    this.maarat[i] = 20;
                }
                break;
            }
        }

    }

    /**
     * Metodi poistaa tilauksesta kaikki tietyt tuotteet.
     *
     * @param nimi Tämän nimiset tuotteet poistetaan tilauksesta.
     */
    public void poistaTuote(String nimi) {

        for (int i = 0; i < varasto.getTuotteet().size(); i++) {
            // jos varastossa on tuon niminen tuote
            if (varasto.getTuotteet().get(i).getNimi().equals(nimi)) {
                this.arvo -= this.maarat[i];
                this.maarat[i] = 0;
                return;
            }
        }
        System.out.println("Tuotetta nimeltä " + nimi + " ei ollut varastossa");

    }

    /**
     * Tilauksen tulostus tuotteittaan alleikkaisessa muodossa id/nimi/määrä.
     */
    @Override
    public String toString() {
        String palautus = "id/nimi/maara \n";
        Tuote pepe;
        for (int i = 0; i < this.maarat.length; i++) {
            if (maarat[i] > 0) {
                pepe = this.varasto.getTuotteet().get(i);
                palautus += pepe.getId() + "/" + pepe.getNimi() + "/"
                        + maarat[i] + "\n";
            }
        }
        return palautus;
    }

    public int[] getMaarat() {
        return maarat;
    }

    public int getArvo() {
        return this.arvo;
    }

    public boolean isToteutettu() {
        return toteutettu;
    }
    /**
     * Tilauksen muuttuja toteutettu muutetaan olemaan "true"
     */
    public void toteutettu() {
        this.toteutettu = true;
    }

    public int getNro() {
        return this.tilausnumero;
    }

    /**
     * Metodi kertoo onko tilaus kokonaan toteutettavissa varaston nykytilassa
     * eli toisinsanoen onko jokaista tuotetta riittävästi
     *
     * @return voiko tilauksen toteuttaa
     */
    public boolean toteutuskelpoisuus() {
        boolean ret = true;

        for (int i = 0; i < this.getMaarat().length; i++) {
            if (varasto.getMaarat().get(i) < this.maarat[i]) {
                return false;
            }
        }
        return true;
    }
}
