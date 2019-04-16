package ui;

import java.util.ArrayList;
import java.util.Scanner;
import sovelluslogiikka.Tuote;
import sovelluslogiikka.Varasto;
import sovelluslogiikka.Tilaus;

public class Kayttoliittyma {

    private Scanner lukija;
    private Scanner lukija2;
    private Varasto a;
    private Tilausgeneraattori tg;

    public Kayttoliittyma(Scanner lukija) {

        this.lukija = new Scanner(System.in);
        this.lukija2 = new Scanner(System.in);

        while (true) {
            System.out.println("Luodaanko tyhjä (1) vai standardivarasto (2)?");
            System.out.println("Vastaa 1 tai 2");
            String sana = lukija.nextLine();
            if (sana.equals("1")) {
                a = new Varasto();
                tg = new Tilausgeneraattori(a);

                break;
            }
            if (sana.equals("2")) {
                a = new Varasto("standardi.txt");
                tg = new Tilausgeneraattori(a);
                break;
            }
        }
    }

    public void kaynnista() {
        if (a.getTuotteet().size() == 0) {
            vapaa();
        } else {
            while (true) {
                System.out.println("Aloitetaanko peli (1) vai vapaa työskenltely? (2)?");
                System.out.println("Vastaa 1 tai 2");
                String sana = lukija.nextLine();
                if (sana.equals("1")) {
                    peli();
                    break;
                }
                if (sana.equals("2")) {
                    vapaa();
                    break;
                }
            }
        }
    }

    public void peli() {

        String kom;
        int taso = 1;
        int vaihe = 1;

        while (true) {
            System.out.println("taso: " + taso + " vaihe: " + vaihe);
            tulosta();
            System.out.println(a.tilaukset());
            tulostaOhjeet();

            System.out.print(">");

            kom = lukija.nextLine();
            if (kom.equals("lisaa")) {
                System.out.print("Minkä nimistä tuotetta lisätään varastoon? >");
                String nimi = lukija.nextLine();
                lisaa(nimi);

            } else if (kom.equals("toteuta")) {
                System.out.println("Mikä tilauksista toteutetaan?");
                int luku = lukija2.nextInt();
                toteuta(luku);

            } else if (kom.equals("lopeta")) {
                System.out.println("SHUTTING DOWN");
                return;

            } else {
                System.out.println("Tunnistamaton komento");
            }

            vaihe++;
            if (vaihe > 10) {
                taso++;
                vaihe = 0;
            }
            
            int toteuttamatta = 0;
            for(Tilaus pepe : a.getTilaukset()){
                if (!pepe.isToteutettu()){
                    toteuttamatta++;
                }
            }
            if(toteuttamatta > 5){
                System.out.println("HÄVISIT PELIN");
            }
            
            tg.aja(taso, vaihe);
        }
    }

    public void lisaa(String nimi) {
        Tuote temp;
        for (int i = 0; i < a.getTuotteet().size(); i++) {
            if (a.getTuotteet().get(i).getNimi().equals(nimi)) {

                temp = a.getTuotteet().get(i);
                a.lisaaTuote(temp, 20);
                return;
            }
        }
        System.out.println("Tuotetta nimeltä " + nimi + " ei ole varastossa");
    }

    public void toteuta(int luku) {
        if (!a.getTilaukset().get(luku).isToteutettu()) {
            if (!a.toteutaTilaus(a.getTilaukset().get(luku))) {
                System.out.println("Tilausta ei voitu toteuttaa sellaisenaan, "
                        + "sillä joitakin tuotteita puuttuu varastosta. "
                        + "Haluatko toteuttaa tilauksen väkisin? (y/n)");
                String sana;
                while (true) {
                    sana = lukija.nextLine();
                    if (sana.equals("y")) {
                        a.toteutaTilausVakisin(a.getTilaukset().get(luku));
                        break;
                    } else if (sana.equals("n")) {
                        System.out.println("Tilausta ei toteutettu");
                        break;
                    }
                }
            }
        }
    }

    public void tulosta() {
        System.out.println(a.toString());
    }

    public void tulostaOhjeet() {
        System.out.println("lisaa, toteuta, lopeta");
    }

    public void vapaa() {

        String kom;

        while (true) {
            tulostaOhjeet2();
            System.out.print(">");

            kom = lukija.nextLine();

            if (kom.equals("uusi")) {
                System.out.print("Minkä niminen tuote luodaan? >");
                String nimi = lukija.nextLine();
                uusi2(nimi);

            } else if (kom.equals("tulosta")) {
                tulosta();

            } else if (kom.equals("lisaa")) {
                System.out.print("Minkä nimistä tuotetta lisätään varastoon? >");
                String nimi = lukija.nextLine();
                System.out.print("Montako kappaletta tuotetta " + nimi + " lisätään? >");
                int maara = lukija2.nextInt();
                lisaa2(nimi, maara);

            } else if (kom.equals("ota")) {
                System.out.print("Minkä nimistä tuotetta poistetaan? >");
                String nimi = lukija.nextLine();
                System.out.print("Montako kappaletta tuotetta " + nimi + " poistetaan? >");
                int maara = lukija2.nextInt();
                ota2(nimi, maara);

            } else if (kom.equals("otav")) {
                System.out.print("Minkä nimistä tuotetta poistetaan? >");
                String nimi = lukija.nextLine();
                System.out.print("Montako kappaletta tuotetta " + nimi + " poistetaan? >");
                int maara = lukija2.nextInt();
                otaVakisin2(nimi, maara);

            } else if (kom.equals("lopeta")) {
                System.out.println("SHUTTING DOWN");
                return;

            } else {
                System.out.println("Tunnistamaton komento");
            }
        }
    }

    public void uusi2(String nimi) {
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

    public void lisaa2(String nimi, int maara) {
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

    public void ota2(String nimi, int maara) {
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

    public void otaVakisin2(String nimi, int maara) {
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

    public void tulosta2() {
        System.out.println(a.toString());
    }

    public void tulostaOhjeet2() {
        /*System.out.println("Komennot:");
        for (String pepe : this.komennot) {
            System.out.println(pepe);
        }
        System.out.println("");*/
        System.out.println("uusi, lisaa, ota, otav, tulosta, lopeta");
    }
}
