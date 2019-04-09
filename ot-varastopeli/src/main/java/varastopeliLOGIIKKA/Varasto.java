package varastopeliLOGIIKKA;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Varasto {

    private ArrayList<Tuote> tuotteet;
    private ArrayList<Integer> maarat;
    private ArrayList<Tilaus> tilaukset;
    private int maksimikoko;

    public Varasto() {
        //System.out.println("Luodaan uusi varasto");
        this.tuotteet = new ArrayList<>();
        this.maarat = new ArrayList<>();
        this.tilaukset = new ArrayList();
        this.maksimikoko = 100;
    }
    
    public Varasto(String teksti){
        this.tuotteet = new ArrayList<>();
        this.maarat = new ArrayList<>();
        this.tilaukset = new ArrayList();
        this.maksimikoko = 100;
        
        Scanner lukija = new Scanner(System.in);
        try (Scanner tiedostonLukija = new Scanner(new File(teksti))) {
            while (tiedostonLukija.hasNextLine()) {
                String rivi = tiedostonLukija.nextLine();
                
                String[] taul = rivi.split("/");
                Tuote t = new Tuote(this, taul[1]);
                lisaaTuote(t , Integer.valueOf(taul[2]));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //ONGELMA: toimittaa kahta toiminnallisuutta kerralla:
    //Uuden tuotteen luominen ja tämän tuotteen määrän kasvattamista
    public void lisaaTuote(Tuote tuote, int maara) {

        //System.out.println("Lisätään varastoon tuote " + tuote.getNimi() 
        //        + " (id: " + tuote.getId() + ") " + maara +" kappaletta" );
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

    public int otaTuoteVakisin(Tuote tuote, int maara) {
        if(maara < 0){
            System.out.println("Ei voida poistaa negatiivista määrää tuotetta");
            return -1;
        }
        for (int i = 0; i < tuotteet.size(); i++) {
            if (i != tuote.getId()) {
                continue;
            } else { 
                if (maara <= maarat.get(i)) {
                    maarat.set(i, maarat.get(i) - maara);
                    return maara;
                } else {
                    int pala = maarat.get(i);
                    System.out.println("Tuotetta ei ollut riittävästi. "
                            + "Otettiin " + maarat.get(i));
                    maarat.set(i, 0);
                    return pala;
                }
            }
        }
        System.out.println("Tuotetta ei ollut varastossa.");
        return -1;
    }

    public int otaTuote(Tuote tuote, int maara) {
        
        if(maara < 0){
            System.out.println("Ei voida poistaa negatiivista määrää tuotetta");
            return -1;
        }
        for (int i = 0; i < tuotteet.size(); i++) {
            if (i != tuote.getId()) {
                continue;
            } else {
                if (maara <= maarat.get(i)) {
                    maarat.set(i, maarat.get(i) - maara);
                    return maara;
                } else {
                    System.out.println("Tuotetta ei ollut riittävästi");
                    return -1;
                }
            }
        }
        System.out.println("Tuotetta ei ollut varastossa.");
        return -1;
    }
    
    public void lisaaTilaus(Tilaus a){
        this.tilaukset.add(a);
    }

    public ArrayList<Tuote> getTuotteet() {
        return tuotteet;
    }

    public void setTuotteet(ArrayList<Tuote> tuotteet) {
        this.tuotteet = tuotteet;
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

    //Palauttaa tuotteet järjestyksessä muodossa id/nimi/maara
    //Tehdään myöhemmin sellaiseksi, että järjestää tuotteet automaattisesti id:n mukaan.
    @Override
    public String toString() {
        //System.out.println("Tulostetaan varaston tuotteet");
        String palautus = "id/nimi/maara\n";
        String temp = "";
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
