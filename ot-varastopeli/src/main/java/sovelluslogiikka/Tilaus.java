package sovelluslogiikka;

import java.io.File;
import sovelluslogiikka.Tuote;
import sovelluslogiikka.Varasto;
import java.util.ArrayList;
import java.util.Scanner;

public class Tilaus {

    private int[] maarat;

    private Varasto varasto;
    private boolean toteutettu;
    private int tilausnumero;

    public Tilaus(Varasto a) {
        this.varasto = a;
        this.toteutettu = false;
        this.maarat = new int[a.getTuotteet().size()];
        for (int i = 0; i < a.getTuotteet().size(); i++) {
            this.maarat[i] = 0;
        }
        a.lisaaTilaus(this);
        this.tilausnumero = a.getTilaukset().size()-1;
        
    }
    
    public Tilaus(Varasto a, String teksti) {
        this.varasto = a;
        this.toteutettu = false;
        this.maarat = new int[a.getTuotteet().size()];
        for (int i = 0; i < a.getTuotteet().size(); i++) {
            this.maarat[i] = 0;
        }
        a.lisaaTilaus(this);
        haeSisalto(teksti);
    }

    public void haeSisalto(String teksti){
        Scanner lukija = new Scanner(System.in);
        try (Scanner tiedostonLukija = new Scanner(new File(teksti))) {
            while (tiedostonLukija.hasNextLine()) {
                String rivi = tiedostonLukija.nextLine();
                String[] taul = rivi.split("/");
                lisaaTuote(taul[1],Integer.valueOf(taul[2]));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void lisaaTuote(String nimi, int maara) {
        if (maara < 0) {
            System.out.println("Ei voida tilata alle 1 tuotetta");
            return;
        }
        for (int i = 0; i < varasto.getTuotteet().size(); i++) {
            // jos varastossa on tuon niminen tuote
            if (varasto.getTuotteet().get(i).getNimi().equals(nimi)) {
                this.maarat[i] += maara;
                if (this.maarat[i] > 20) {
                    System.out.println("Yritetty lisätä yli 20kpl tuotetta");
                    System.out.println("Nyt tilauksessa 20kpl " + nimi);
                    this.maarat[i] = 20;
                }
                break;
            }
        }

    }

    public void poistaTuote(String nimi) {

        for (int i = 0; i < varasto.getTuotteet().size(); i++) {
            // jos varastossa on tuon niminen tuote
            if (varasto.getTuotteet().get(i).getNimi().equals(nimi)) {
                this.maarat[i] = 0;
                return;
            }
        }
        System.out.println("Tuotetta nimeltä " + nimi + " ei ollut varastossa");

    }

    @Override
    public String toString() {
        //myöhemmin: tilaukselle lisätään yksilöivä numero, joka tulostetaan
        System.out.println("Tulostetaan tilauksen numero "+ this.tilausnumero +" tuotteet");

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

    public boolean isToteutettu() {
        return toteutettu;
    }
    
    public void toteutettu() {
        this.toteutettu = true;
    }
    
    public int getNro() {
        return this.tilausnumero;
    }
}
