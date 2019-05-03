package juuri.ui;

import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;
import juuri.sovelluslogiikka.Tuote;
import juuri.sovelluslogiikka.Varasto;
import juuri.sovelluslogiikka.Tilaus;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import juuri.main.Varastopeli;
import juuri.ui.Graafinenui;

public class Tekstiui {

    private Scanner lukija;
    private Scanner lukija2;
    private Varasto a;
    private Tilausgeneraattori tg;
    private int pisteet;
    private int skipatut;

    public Tekstiui(Scanner lukija) {

        this.lukija = new Scanner(System.in);
        this.lukija2 = new Scanner(System.in);
        this.pisteet = 0;
        this.skipatut = 0;

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
                a = new Varasto("0/ananas/15\n"
                        + "1/banaani/15\n"
                        + "2/curry/15\n"
                        + "3/dijon/10\n"
                        + "4/etikka/10\n"
                        + "5/falafel/10\n"
                        + "6/greippi/10\n"
                        + "7/hedelma/5\n"
                        + "8/inkivaari/5\n"
                        + "9/juusto/5\n"
                        + "10/kurkku/5");
                tg = new Tilausgeneraattori(a);
                break;
            }
        }
    }

    public void kaynnista() {
        if (a.getTuotteet().isEmpty()) {
            vapaa();
        } else {
            while (true) {
                System.out.println("Aloitetaanko peli (1) vai vapaa työskentely? (2)?");
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

        System.out.println("Tekstinä (1) vai graafisena (2) ?");
        if (lukija.nextLine().equals("2")) {
            launch(Graafinenui.class);
            return;
        }

        String kom;
        int taso = 1;
        int vaihe = 1;
        tg.aja(1, 1);

        System.out.println("Miltä tasolta aloitetaan?");
        String lahto;
        while (true) {
            lahto = lukija.nextLine();
            if (isNumeric(lahto)) {
                break;
            } else {
                System.out.println("Anna numero");
            }
        }
        taso = Integer.valueOf(lahto);

        while (true) {
            System.out.println("\ntaso: " + taso + " vaihe: " + vaihe);
            System.out.println("Pisteet: " + pisteet);
            System.out.println("Vajaita tilauksia toteutettu: " + skipatut + "/5\n");
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
                String luku;
                while (true) {
                    luku = lukija.nextLine();
                    if (isNumeric(luku)) {
                        break;
                    } else {
                        System.out.println("Anna numero");
                    }
                }
                toteuta(Integer.valueOf(luku));

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
            for (Tilaus pepe : a.getTilaukset()) {
                if (!pepe.isToteutettu()) {
                    toteuttamatta++;
                }
            }
            if (toteuttamatta > 5) {
                System.out.println("HÄVISIT PELIN");
                System.out.println("Pääsit tasolle " + taso + " vaiheeseen " + vaihe);
                System.out.println("Pisteesi: " + pisteet);
                break;
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
        if (a.getTilaukset().size() < luku + 1) {
            return;
        }
        if (!a.getTilaukset().get(luku).isToteutettu()) {
            this.pisteet += a.getTilaukset().get(luku).getArvo();
            if (!a.toteutaTilaus(a.getTilaukset().get(luku))) {
                if (skipatut > 5) {
                    System.out.println("Olet jo toteuttanut 5 vajaata tilausta");
                    return;
                }
                System.out.println("Tilausta ei voitu toteuttaa sellaisenaan, sillä joitakin tuotteita puuttuu varastosta.\nHaluatko toteuttaa tilauksen väkisin? (y/n)");
                kysymys(luku);
            }
        }
    }

    public void kysymys(int luku) {
        String sana;
        while (true) {
            sana = lukija.nextLine();
            if (sana.equals("y")) {
                a.toteutaTilausVakisin(a.getTilaukset().get(luku));
                this.pisteet -= (a.getTilaukset().get(luku).getArvo() / 2);
                skipatut++;
                break;
            } else if (sana.equals("n")) {
                this.pisteet -= a.getTilaukset().get(luku).getArvo();
                break;
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

        //kom on viimeisin annettu tekstimuotoinen komento
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
                String luku;
                while (true) {
                    luku = lukija.nextLine();
                    if (isNumeric(luku)) {
                        break;
                    } else {
                        System.out.println("Anna numero");
                    }
                }
                int maara = Integer.valueOf(luku);
                lisaa2(nimi, maara);

            } else if (kom.equals("ota")) {
                System.out.print("Minkä nimistä tuotetta poistetaan? >");
                String nimi = lukija.nextLine();
                System.out.print("Montako kappaletta tuotetta " + nimi + " poistetaan? >");
                String luku;
                while (true) {
                    luku = lukija.nextLine();
                    if (isNumeric(luku)) {
                        break;
                    } else {
                        System.out.println("Anna numero");
                    }
                }
                int maara = Integer.valueOf(luku);
                ota2(nimi, maara);

            } else if (kom.equals("otav")) {
                System.out.print("Minkä nimistä tuotetta poistetaan? >");
                String nimi = lukija.nextLine();
                System.out.print("Montako kappaletta tuotetta " + nimi + " poistetaan? >");
                String luku;
                while (true) {
                    luku = lukija.nextLine();
                    if (isNumeric(luku)) {
                        break;
                    } else {
                        System.out.println("Anna numero");
                    }
                }
                int maara = Integer.valueOf(luku);
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

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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
