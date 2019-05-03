package juuri.ui;

public class Pelaaja implements Comparable<Pelaaja> {

    private int pisteet;
    private String nimi;

    /**
     * Konstruktori luo uuden pelaaja-olion, jonka saamaa huipputulosta voidaan
     * tarkastella HighScoreTallentimella
     *
     * @param pisteet Pelajan pisteet
     * @param nimi Pelajan nimi
     */
    public Pelaaja(int pisteet, String nimi) {
        this.pisteet = pisteet;
        this.nimi = nimi;
    }

    public int getPisteet() {
        return pisteet;
    }

    public String getNimi() {
        return nimi;
    }

    /**
     * Metodi, jonka rajapinta comparable vaatii. Mahdollistaa pelaajien
     * järjestämisen pisteiden perusteella.
     *
     * @return -1, jos this.pisteet on suurempi kuin pel.getPisteet() 1, jos this.pisteet on pienempi kuin pel.getPisteet(), 0 jos molemmat ovat yhtä suuret.
     */
    public int compareTo(Pelaaja pel) {
        if (this.pisteet == pel.getPisteet()) {
            return 0;
        } else if (this.pisteet < pel.getPisteet()) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Metodi palauttaa pelaajan tiedot merkkijonona
     *
     * @return pelaajan tiedot merkkijonona muodossa "pisteet - nimi"
     */
    public String tulosta() {
        return this.pisteet + " - " + this.nimi;
    }
}
