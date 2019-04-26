package juuri.sovelluslogiikka;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Varasto {

    private ArrayList<Tuote> tuotteet;
    private ArrayList<Integer> maarat;
    private ArrayList<Tilaus> tilaukset;
    private int maksimikoko;

    /**
     * Konstruktori, joka luo uuden tyhjän varaston
     * Varastolle luodaan lista tuotteita ja yhtä suuri lista tuotteiden
     * määriä kuvaavia integerejä. Lisäksi luodaan tyhjä lista tilauksia.
     * Varaston maksimikooksi määritetään 100, joten siihen ei voida
     * lisätä tuotteita, kun siinä on jo 100 tuotetta.
     */
    public Varasto() {
        this.tuotteet = new ArrayList<>();
        this.maarat = new ArrayList<>();
        this.tilaukset = new ArrayList();
        this.maksimikoko = 100;
    }

    /**
     * Konstruktori, joka luo uuden esitäytetyn varaston
     * Varastolle luodaan lista tuotteita ja yhtä suuri lista tuotteiden
     * määriä kuvaavia integerejä. Lisäksi luodaan tyhjä lista tilauksia.
     * Varaston maksimikooksi määritetään 100, joten siihen ei voida
     * lisätä tuotteita, kun siinä on jo 100 tuotetta.
     * Varastoon tulee monta eri tuotetta ja kullekin määritetään montako
     * sitä on.
     * Kutsuu metodia haeSisalto
     * @see    juuri.sovelluslogiikka.Varasto#haeSisalto(String)
     *
     * @param teksti Sisältää varastoon tulevat tuotteet csv-muorossa (erottelumerkki /)
     */
    public Varasto(String teksti) {
        this.tuotteet = new ArrayList<>();
        this.maarat = new ArrayList<>();
        this.tilaukset = new ArrayList();
        this.maksimikoko = 100;

        haeSisalto(teksti);
    }
    /**
     * Metodi erottelee yksittäiset tuotteet parametrinä annettavasta
     * csv-muotoisesta tekstistä ja lisää ne varastoon.
     * Kutsuu metodia lisaaTuote jokaisen uuden tuotteen kohdalla
     * @see    juuri.sovelluslogiikka.Varasto#lisaaTuote(Tuote, String)
     *
     * @param teksti Sisältää varastoon tulevat tuotteet csv-muorossa (erottelumerkki /)
     */
    public void haeSisalto(String teksti) {
        String taul[] = teksti.split("\n");
        String talu[];
        for (String pepe : taul) {
            talu = pepe.split("/");
            Tuote t = new Tuote(this, talu[1]);
            lisaaTuote(t, Integer.valueOf(talu[2]));
        }
    }
    
    /**
     * Metodi lisää tuotetta varastoon. Jos tuotetta ei ole vielä varastossa,
     * metodi luo sellaisen ja lisää sitä sitten halutun määrän varastoon.
     * Tuotteen määrä ei voi kasvaa yli 20:n, jos yritetään kasvattaa liikaa,
     * lisätään vain kunnes tuotetta on varastossa 20 kappaletta.
     *
     * @param tuote lisättävä tuote
     * @param maara montako tuotetta lisätään
     */
    public void lisaaTuote(Tuote tuote, int maara) {
        if (maara < 0) {
            System.out.println("Ei voida lisätä negatiivista määrää tuotetta");
            return;
        }
        if (this.tuotteet.contains(tuote)) {
            int temp = this.tuotteet.indexOf(tuote);
            int nyky = this.maarat.get(temp);
            maarat.set(temp, nyky + maara);
            if (maarat.get(temp) > 20) {
                maarat.set(temp, 20);
            }
        } else {
            tuotteet.add(tuote);
            maarat.add(maara);
            if (maarat.get(this.tuotteet.indexOf(tuote)) > 20) {
                System.out.println("Yritetty lisätä liikaa tuotetta");
                maarat.set(this.tuotteet.indexOf(tuote), 20);
            }
        }
    }
    /**
     * Metodi poistaa jotakin tuotetta halutun verran varastosta.
     * Jos tuotetta ei ole tarpeeksi, poistetaan kaikki jäljellä
     * olevat tuotteet.
     *
     * @param tuote poistettava tuote
     * @param maara montako tuotetta poistetaan
     * 
     * @return otettujen tuotteiden määrä
     */
    public int otaTuoteVakisin(Tuote tuote, int maara) {
        if (maara < 0) {
            System.out.println("Ei voida poistaa negatiivista määrää tuotetta");
            return 0;
        }
        for (int i = 0; i < tuotteet.size(); i++) {
            if (i == tuote.getId()) {
                if (maara <= maarat.get(i)) {
                    maarat.set(i, maarat.get(i) - maara);
                    return maara;
                } else {
                    int pala = maarat.get(i);
                    System.out.println("Tuotetta ei ollut riittävästi. " + "Otettiin " + maarat.get(i));
                    maarat.set(i, 0);
                    return pala;
                }
            }
        }
        System.out.println("Tuotetta ei ollut varastossa.");
        return 0;
    }

    /**
     * Metodi poistaa jotakin tuotetta halutun verran varastosta.
     * Jos tuotetta ei ole tarpeeksi, ei poisteta mitään.
     *
     * @param tuote poistettava tuote
     * @param maara montako tuotetta poistetaan
     * 
     * @return otettujen tuotteiden määrä
     */
    public int otaTuote(Tuote tuote, int maara) {
        if (maara < 0) {
            System.out.println("Ei voida poistaa negatiivista määrää tuotetta");
            return 0;
        }
        for (int i = 0; i < tuotteet.size(); i++) {
            if (i == tuote.getId()) {
                if (maara <= maarat.get(i)) {
                    maarat.set(i, maarat.get(i) - maara);
                    return maara;
                }
                System.out.println("Tuotetta ei ollut riittävästi");
                return 0;

            }
        }
        System.out.println("Tuotetta ei ollut varastossa.");
        return 0;
    }
    
    /**
     * Metodi poistaa jotakin tuotetta halutun verran varastosta.
     * Jos tuotetta ei ole tarpeeksi, poistetaan kaikki jäljellä
     * olevat tuotteet.
     *
     * @param i poistettavan tuotteen id
     * @param maara montako tuotetta poistetaan
     * 
     * @return otettujen tuotteiden määrä
     */
    public int otaTuoteNumerolla(int i, int maara) {
        if (this.tuotteet.size() < i || maara < 1) {
            return 0;
        }
        int pepe = this.maarat.get(i) - maara;
        if (pepe < 0) {
            System.out.println("Otettu liikaa");
            return 0;
        } else {
            this.maarat.set(i, pepe);
        }
        return maara;
    }

    /**
     * Metodi poistaa jotakin tuotetta halutun verran varastosta.
     * Jos tuotetta ei ole tarpeeksi, poistetaan kaikki jäljellä
     * olevat tuotteet.
     *
     * @param i poistettavan tuotteen id
     * @param maara montako tuotetta poistetaan
     * 
     * @return otettujen tuotteiden määrä
     */
    public int otaTuoteNumerollaVakisin(int i, int maara) {
        if (this.tuotteet.size() < i || maara < 1) {
            return 0;
        }
        int pepe = this.maarat.get(i) - maara;
        if (pepe < 0) {
            System.out.println("Otettu liikaa");
            this.maarat.set(i, 0);
            return maara + pepe;
        } else {
            this.maarat.set(i, pepe);
        }
        return maara;
    }

    /**
     * Metodi lisää varastolle tilauksen
     *
     * @param t lisättävä tilaus
     */
    public void lisaaTilaus(Tilaus t) {
        this.tilaukset.add(t);
    }

    /**
     * Metodi yrittää toteuttaa halutun tilauksen eli ottaa varastosta
     * tilauksen pyytämät tuotteet
     * Jos jotakin tuotetta on liian vähän, tilausta ei toteuteta.
     * Jos tilaus on toteutettavissa, kutsuu metodia otaTuoteNumerolla
     * @see    juuri.sovelluslogiikka.Varasto#otaTuoteNumerolla(int, int)
     *
     * @param t toteutettava tilaus
     * 
     * @return onnistuiko tilauksen toteuttaminen
     */
    public boolean toteutaTilaus(Tilaus t) {
        for (int i = 0; i < t.getMaarat().length; i++) {
            if (t.getMaarat()[i] > this.maarat.get(i)) {
                System.out.println("Ei voida toteuttaa tilausta. Jotakin tuotetta puuttuu");
                return false;
            }
        }
        for (int i = 0; i < t.getMaarat().length; i++) {
            otaTuoteNumerolla(i, t.getMaarat()[i]);
        }
        t.toteutettu();
        return true;
    }

    /**
     * Metodi toteuttaa väkisin halutun tilauksen eli ottaa varastosta
     * tilauksen pyytämät tuotteet
     * Jos jotakin tuotetta on liian vähän, tilausta ei toteuteta.
     * Kutsuu jokaisen tuotteen kohdalla metodia otaTuoteNumerollavakisin
     * @see    juuri.sovelluslogiikka.Varasto#otaTuoteNumerollaVakisin(int, int)
     *
     * @param t toteutettava tilaus
     * 
     * @return onnistuiko tilauksen toteuttaminen
     */
    public boolean toteutaTilausVakisin(Tilaus t) {
        for (int i = 0; i < t.getMaarat().length; i++) {
            otaTuoteNumerollaVakisin(i, t.getMaarat()[i]);
        }
        t.toteutettu();
        return true;
    }

    public ArrayList<Tuote> getTuotteet() {
        return tuotteet;
    }

    public ArrayList<Integer> getMaarat() {
        return maarat;
    }

    public ArrayList<Tilaus> getTilaukset() {
        return tilaukset;
    }

    public int getMaksimikoko() {
        return maksimikoko;
    }

    /**
     * Metodi muodostaa merkkijonon, joka sisältää varaston 
     * toteuttamattomat tilaukset allekain muodossa id/nimi/määrä
     * 
     * @return muodostettu merkkijono
     */
    public String tilaukset() {
        String pala = "";
        int vuoro = 0;
        for (Tilaus pepe : this.tilaukset) {
            if (!pepe.isToteutettu()) {
                pala = pala + "tilaus nro " + pepe.getNro() + "\n";
                pala = pala + pepe + "\n";
            }
        }
        return pala;
    }

    
    /**
     * Metodi muorostaa merkkijonon, joka sisältää varaston sisältämät 
     * tuotteet järjestyksessä muodossa id/nimi/maara
     * 
     * @return muodostettu merkkijono
     */
    @Override
    public String toString() {
        //System.out.println("Tulostetaan varaston tuotteet");
        String palautus = "id/nimi/maara\n";
        String temp;
        int num = 0;

        for (Tuote pepe : tuotteet) {
            if (pepe == null) {
                System.out.println("tuote ei ole olemassa");
            }
            temp = pepe.getId() + "/" + pepe.getNimi();
            palautus += temp + "/";
            num = tuotteet.indexOf(pepe);
            palautus += maarat.get(num) + "\n";
        }

        return palautus;
    }

}
