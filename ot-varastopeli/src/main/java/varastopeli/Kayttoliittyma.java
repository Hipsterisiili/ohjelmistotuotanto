package varastopeli;

import java.util.ArrayList;
import java.util.Scanner;

public class Kayttoliittyma {

    private Scanner lukija;
    private Scanner lukija2;
    private ArrayList<String> komennot;
    private Varasto a;

    public Kayttoliittyma(Scanner lukija) {
        this.lukija = new Scanner(System.in);
        this.lukija2 = new Scanner(System.in);
        System.out.println("Uusi käyttöliittymä luotu!");

        komennot = new ArrayList<>();

        komennot.add("tulosta = tulosta varasto");
        komennot.add("uusituote = luo uusi tuote");
        komennot.add("lisaatuote = lisää jotakin tuotetta varastoon");
        komennot.add("otatuote = ota tuotetta varastosta");
        komennot.add("lopeta = lopeta ohjelma");
    }

    public void kaynnista() {

        a = new Varasto();
        String kom;

        while (true) {
            tulostaOhjeet();
            
            kom = lukija.nextLine();
            
            if (kom.equals("uusi")) {
                System.out.print("Minkä niminen tuote luodaan? >");
                String nimi = lukija.nextLine();
                uusiTuote(nimi);
                
            } else if (kom.equals("tulosta")) {
                tulosta();
                
            } else if (kom.equals("lisaa")) {
                System.out.print("Minkä nimistä tuotetta lisätään varastoon? >");
                String nimi = lukija.nextLine();
                System.out.print("Montako kappaletta tuotetta " + nimi + " lisätään? >");
                int maara = lukija2.nextInt();
                lisaaTuote(nimi, maara);
                
            } else if(kom.equals("ota")){
                System.out.print("Minkä nimistä tuotetta poistetaan? >");
                String nimi = lukija.nextLine();
                System.out.print("Montako kappaletta tuotetta " + nimi + " poistetaan? >");
                //TÄHÄN METODI, JOKA KERTOO MONTAKO KAPPALETTA TUOTETTA ON VARASTOSSA!
                int maara = lukija2.nextInt();
                otaTuote(nimi, maara);
                
            } else if(kom.equals("otaVakisin")){
                System.out.print("Minkä nimistä tuotetta poistetaan? >");
                String nimi = lukija.nextLine();
                System.out.print("Montako kappaletta tuotetta " + nimi + " poistetaan? >");
                //TÄHÄN METODI, JOKA KERTOO MONTAKO KAPPALETTA TUOTETTA ON VARASTOSSA!
                int maara = lukija2.nextInt();
                otaTuoteVakisin(nimi, maara);
                
            } else if (kom.equals("lopeta")){
                System.out.println("SHUTTING DOWN");
                return;
                
            } else {
                System.out.println("Tunnistamaton komento");
            }
        }
    }

    public void uusiTuote(String nimi) {
        boolean lopetetaanko = false;
        for (Tuote pepe : a.getTuotteet()) {
            if (pepe.getNimi().equals(nimi)) {
                System.out.println("Tuote " + nimi + " on jo varastossa. Ei lisätty.");
                lopetetaanko = true;
            }
            if (lopetetaanko) {
                return;
            }
        }
        Tuote uusiTuote = new Tuote(a, nimi);
        a.lisaaTuote(uusiTuote, 0);
    }

    public void lisaaTuote(String nimi, int maara) {
        Tuote temp;
        for (int i = 0; i < a.getTuotteet().size(); i++) {
            if (a.getTuotteet().get(i).getNimi().equals(nimi)) {

                temp = a.getTuotteet().get(i);
                a.lisaaTuote(temp, maara);
                return;
            }
        }
        System.out.println("Tuotetta nimeltä " + nimi + " ei ole varastossa");
    }
    
    public void otaTuote(String nimi, int maara) {
        Tuote temp;
        for (int i = 0; i < a.getTuotteet().size(); i++) {
            if (a.getTuotteet().get(i).getNimi().equals(nimi)) {

                temp = a.getTuotteet().get(i);
                a.otaTuote(temp, maara);
                return;
            }
        }
        System.out.println("Tuotetta nimeltä " + nimi + " ei ole varastossa");
    }
    
    public void otaTuoteVakisin(String nimi, int maara) {
        Tuote temp;
        for (int i = 0; i < a.getTuotteet().size(); i++) {
            if (a.getTuotteet().get(i).getNimi().equals(nimi)) {

                temp = a.getTuotteet().get(i);
                
                a.otaTuoteVakisin(temp, maara);
                return;
            }
        }
        System.out.println("Tuotetta nimeltä " + nimi + " ei ole varastossa");
    }

    public void tulosta() {
        System.out.println(a.toString());
    }

    public void tulostaOhjeet() {
        /*System.out.println("Komennot:");
        for (String pepe : this.komennot) {
            System.out.println(pepe);
        }
        System.out.println("");*/
        System.out.println("uusi, lisaa, ota, tulosta, lopeta");
    }
}
