package varastopeliLOGIIKKA;

import varastopeliLOGIIKKA.Tuote;
import varastopeliLOGIIKKA.Varasto;
import java.util.ArrayList;

public class Tilaus {

    private int[] maarat;

    private Varasto varasto;
    private boolean toteutettu;

    public Tilaus(Varasto a) {
        this.varasto = a;
        this.toteutettu = false;
        this.maarat = new int[a.getTuotteet().size()];
        for (int i = 0; i < a.getTuotteet().size(); i++) {
            this.maarat[i] = 0;
        }
    }

    //tee myöhemmin: jos tilaus liian suuri, palauttaa vain false
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
        System.out.println("Tulostetaan tilauksen tuotteet");

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
}
