/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juuri.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import juuri.sovelluslogiikka.Varasto;
import juuri.sovelluslogiikka.Tilaus;
import juuri.sovelluslogiikka.Tuote;

public class Graafinenui extends Application {

    private Varasto a;
    private int taso;
    private int vaihe;
    private int pisteet;
    private int skipatut;
    private Tilausgeneraattori tg;
    private BorderPane asettelu;
    private VBox nimet;
    private VBox tilausnapit;
    private HBox tilaukset;
    private VBox maarat;
    private HBox vasen;
    private Scene nakyma;
    private Label tilanne;
    private Label til;
    private int tilauksia;

    @Override
    public void start(Stage ikkuna) {
        ikkuna.setTitle("Visuaalinen käyttölittymä");
        
        alusta();
        paivitaTilanne();
        
        asettelu.setLeft(vasen);
        asettelu.setRight(tilanne);
        asettelu.setCenter(tilaukset);
        nakyma = new Scene(asettelu, 750, 520);
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public void alusta() {
        a = varastonLuonti();
        tg = new Tilausgeneraattori(a);
        taso = 1;
        vaihe = 0;
        pisteet = 0;
        skipatut = 0;
        tilanne = new Label("tervetuloa");
        tilauksia = 0;

        asettelu = new BorderPane();
        vasen = new HBox();
        tilaukset = new HBox();
        nimet = luoNimet();
        tilausnapit = luoTilausnapit();
        maarat = new VBox();
    }
    
    public void paivitaTilanne() {
        vaihe++;
        if (vaihe > 10) {
            taso++;
            vaihe = 1;
        }
        tg.aja(taso, vaihe);

        String temp = "\n\ntaso:" + taso + "\n\nvaihe: " + vaihe
                + "\n\npisteet: " + pisteet + "\n\noljenkorsia käytetty: " + skipatut + "/5";
        tilanne.setText(temp);
        
        vasen.getChildren().clear();
        maarat.getChildren().clear();
        
        luoMaarat();
        
        vasen.getChildren().addAll(nimet, maarat, tilausnapit);

        tilausKuva();
    }

    public void tilausKuva() {
        tilaukset.getChildren().clear();
        int tilauksiaSisalla = 0;
        for (Tilaus t : a.getTilaukset()) {
            if (!t.isToteutettu()) {
                tilauksiaSisalla++;
                tilaukset.getChildren().add(tilausBoksiksi(t));
            }
            if (tilauksiaSisalla >= 6) {
                System.out.println("GAMEOVER");
                alusta();
            }
        }
    }

    public VBox luoNimet() {
        nimet = new VBox();
        nimet.setSpacing(20);
        nimet.getChildren().add(new Label("Nimi:"));
        nimet.getChildren().add(new Label("ananas"));
        nimet.getChildren().add(new Label("banaani"));
        nimet.getChildren().add(new Label("curry"));
        nimet.getChildren().add(new Label("dijon"));
        nimet.getChildren().add(new Label("etikka"));
        nimet.getChildren().add(new Label("falafel"));
        nimet.getChildren().add(new Label("greippi"));
        nimet.getChildren().add(new Label("hedelma"));
        nimet.getChildren().add(new Label("inkivaari"));
        nimet.getChildren().add(new Label("juusto"));
        nimet.getChildren().add(new Label("kurkku"));
        return nimet;
    }

    public VBox luoMaarat() {
        maarat = new VBox();
        maarat.setSpacing(20);
        maarat.getChildren().add(new Label("Määrä:"));
        maarat.getChildren().add(new Label("" + a.getMaarat().get(0) + "   "));
        maarat.getChildren().add(new Label("" + a.getMaarat().get(1) + "   "));
        maarat.getChildren().add(new Label("" + a.getMaarat().get(2) + "   "));
        maarat.getChildren().add(new Label("" + a.getMaarat().get(3) + "   "));
        maarat.getChildren().add(new Label("" + a.getMaarat().get(4) + "   "));
        maarat.getChildren().add(new Label("" + a.getMaarat().get(5) + "   "));
        maarat.getChildren().add(new Label("" + a.getMaarat().get(6) + "   "));
        maarat.getChildren().add(new Label("" + a.getMaarat().get(7) + "   "));
        maarat.getChildren().add(new Label("" + a.getMaarat().get(8) + "   "));
        maarat.getChildren().add(new Label("" + a.getMaarat().get(9) + "   "));
        maarat.getChildren().add(new Label("" + a.getMaarat().get(10) + "   "));
        return maarat;
    }
    
    

    public VBox luoTilausnapit() {
        tilausnapit = new VBox();
        tilausnapit.setSpacing(10);
        Label tyhja = new Label("   ");
        Button ananas = new Button("tilaa");
        ananas.setOnAction((event) -> {
            a.lisaaTuote(a.getTuotteet().get(0), 20);
            paivitaTilanne();
        });
        Button banaani = new Button("tilaa");
        banaani.setOnAction((event) -> {
            a.lisaaTuote(a.getTuotteet().get(1), 20);
            paivitaTilanne();
        });
        Button curry = new Button("tilaa");
        curry.setOnAction((event) -> {
            a.lisaaTuote(a.getTuotteet().get(2), 20);
            paivitaTilanne();
        });
        Button dijon = new Button("tilaa");
        dijon.setOnAction((event) -> {
            a.lisaaTuote(a.getTuotteet().get(3), 20);
            paivitaTilanne();
        });
        Button etikka = new Button("tilaa");
        etikka.setOnAction((event) -> {
            a.lisaaTuote(a.getTuotteet().get(4), 20);
            paivitaTilanne();
        });
        Button falafel = new Button("tilaa");
        falafel.setOnAction((event) -> {
            a.lisaaTuote(a.getTuotteet().get(5), 20);
            paivitaTilanne();
        });
        Button greippi = new Button("tilaa");
        greippi.setOnAction((event) -> {
            a.lisaaTuote(a.getTuotteet().get(6), 20);
            paivitaTilanne();
        });
        Button hedelma = new Button("tilaa");
        hedelma.setOnAction((event) -> {
            a.lisaaTuote(a.getTuotteet().get(7), 20);
            paivitaTilanne();
        });
        Button inkivaari = new Button("tilaa");
        inkivaari.setOnAction((event) -> {
            a.lisaaTuote(a.getTuotteet().get(8), 20);
            paivitaTilanne();
        });
        Button juusto = new Button("tilaa");
        juusto.setOnAction((event) -> {
            a.lisaaTuote(a.getTuotteet().get(9), 20);
            paivitaTilanne();
        });
        Button kurkku = new Button("tilaa");
        kurkku.setOnAction((event) -> {
            a.lisaaTuote(a.getTuotteet().get(10), 20);
            paivitaTilanne();
        });
        tilausnapit.getChildren().addAll(tyhja, ananas, banaani, curry, dijon,
                etikka, falafel, greippi, hedelma, inkivaari, juusto, kurkku);
        return tilausnapit;
    }

    

    public Varasto varastonLuonti() {
        Varasto a = new Varasto("0/ananas/15\n"
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
        return a;
    }

    public VBox tilausBoksiksi(Tilaus t) {
        VBox boksi = new VBox();
        boksi.setSpacing(20);
        String teksti = t.toString();
        String[] taul1 = teksti.split("\n");
        int[] taul2 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        String[] taul3 = new String[3];
        for (int i = 1; i < taul1.length; i++) {
            taul3 = taul1[i].split("/");
            int hhh = Integer.parseInt(taul3[0]);
            taul2[hhh] = Integer.parseInt(taul3[2]);
        }

        boksi.getChildren().add(new Label(" Tilaus " + a.getTilaukset().indexOf(t)));
        for (int i = 0; i < taul2.length; i++) {
            if (taul2[i] == 0) {
                String mmmm = "        -";
                boksi.getChildren().add(new Label(mmmm));
            } else {
                String mmmm = "        " + taul2[i];
                boksi.getChildren().add(new Label(mmmm));
            }
        }
        if (t.toteutuskelpoisuus()) {
            boksi.getChildren().add(new Label("Valmis"));
        } else {
            boksi.getChildren().add(new Label("Vajaa"));
        }

        Button toteuta = new Button("toteuta");
        toteuta.setOnAction((event) -> {
            if (a.toteutaTilaus(t)) {
                pisteet += t.getArvo();
                paivitaTilanne();
            } else {
                if (skipatut < 6) {
                    a.toteutaTilausVakisin(t);
                    pisteet += (t.getArvo() / 2);
                    skipatut++;
                    paivitaTilanne();
                }
            }

        });
        boksi.getChildren().add(toteuta);
        return boksi;
    }
}
