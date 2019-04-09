package varastopeliui;

import java.util.ArrayList;
import java.util.Scanner;
import varastopelilog.Tuote;
import varastopelilog.Varasto;
import varastopelilog.Tilaus;

public class Kayttoliittyma {

    private Scanner lukija;
    private Scanner lukija2;
    private Varasto a;

    public Kayttoliittyma(Scanner lukija) {
        this.lukija = new Scanner(System.in);
        this.lukija2 = new Scanner(System.in);
        System.out.println("Uusi käyttöliittymä luotu!");

        while(true){
            System.out.println("Luodaanko tyhjä (1) vai standardivarasto (2)?");
            System.out.println("Vastaa 1 tai 2");
            String sana = lukija.nextLine();
            if(sana.equals("1")){
                a = new Varasto();
                break;
            }
            if(sana.equals("2")){
                a = new Varasto("standardi.txt");
                break;
            }
        }
    }

    public void kaynnista() {
        
        String kom;

        while (true) {
            tulostaOhjeet();
            
            kom = lukija.nextLine();
            
            if (kom.equals("uusi")) {
                System.out.print("Minkä niminen tuote luodaan? >");
                String nimi = lukija.nextLine();
                uusi(nimi);
                
            } else if (kom.equals("tulosta")) {
                tulosta();
                
            } else if (kom.equals("lisaa")) {
                System.out.print("Minkä nimistä tuotetta lisätään varastoon? >");
                String nimi = lukija.nextLine();
                System.out.print("Montako kappaletta tuotetta " + nimi + " lisätään? >");
                int maara = lukija2.nextInt();
                lisaa(nimi, maara);
                
            } else if(kom.equals("ota")){
                System.out.print("Minkä nimistä tuotetta poistetaan? >");
                String nimi = lukija.nextLine();
                System.out.print("Montako kappaletta tuotetta " + nimi + " poistetaan? >");
                int maara = lukija2.nextInt();
                ota(nimi, maara);
                
            } else if(kom.equals("otav")){
                System.out.print("Minkä nimistä tuotetta poistetaan? >");
                String nimi = lukija.nextLine();
                System.out.print("Montako kappaletta tuotetta " + nimi + " poistetaan? >");
                int maara = lukija2.nextInt();
                otaVakisin(nimi, maara);
                
            } else if (kom.equals("lopeta")){
                System.out.println("SHUTTING DOWN");
                return;
                
            } else {
                System.out.println("Tunnistamaton komento");
            }
        }
    }

    public void uusi(String nimi) {
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

    public void lisaa(String nimi, int maara) {
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
    
    public void ota(String nimi, int maara) {
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
    
    public void otaVakisin(String nimi, int maara) {
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
        System.out.println("uusi, lisaa, ota, otav, tulosta, lopeta");
    }
}
