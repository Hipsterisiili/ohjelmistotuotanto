package juuri.main;

import java.io.IOException;
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
import juuri.sovelluslogiikka.HighScoreTallennin;
import juuri.sovelluslogiikka.Tilaus;
import juuri.sovelluslogiikka.Tilausgeneraattori;
import juuri.sovelluslogiikka.Tuote;
import juuri.sovelluslogiikka.Varasto;

public class Varastopeli {

    public static void main(String[] args) throws IOException {
        
        Varasto a = new Varasto();
        Tuote x = new Tuote(a, "makkara");
        a.lisaaTuote(x, 10);
        Varasto b = new Varasto();
        Tuote uuu = new Tuote(b, "uliuli");
        System.out.println(a.otaTuote(uuu, 1));
        System.out.println(a.otaTuoteVakisin(uuu, 1));
        
        Scanner lukija = new Scanner(System.in);

        Tekstiui kayttis = new Tekstiui(lukija);

        kayttis.kaynnista();
    }
}
    