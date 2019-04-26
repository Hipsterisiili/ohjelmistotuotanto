package juuri.main;

import juuri.ui.Tekstiui;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import juuri.sovelluslogiikka.Tilaus;
import juuri.sovelluslogiikka.Tuote;
import juuri.sovelluslogiikka.Varasto;
import juuri.ui.Tilausgeneraattori;

public class Varastopeli {

    public static void main(String[] args) {
        
        Varasto a = new Varasto();
        Tuote x = new Tuote(a, "makkara");
        Tuote y = new Tuote(a, "kakkara");
        Tuote z = new Tuote(a, "jakkara");
        Tilaus tilaus = new Tilaus(a);
        
        Tilaus pepe = new Tilaus(a);
        System.out.println(pepe.getArvo());
        pepe.lisaaTuote("makkara", 2);
        pepe.lisaaTuote("kakkara", 21);
        System.out.println(pepe.getArvo());

        Scanner lukija = new Scanner(System.in);

        Tekstiui kayttis = new Tekstiui(lukija);

        kayttis.kaynnista();
    }
}
    