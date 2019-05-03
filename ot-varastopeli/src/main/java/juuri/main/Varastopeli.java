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
import juuri.sovelluslogiikka.Tilaus;
import juuri.sovelluslogiikka.Tuote;
import juuri.sovelluslogiikka.Varasto;
import juuri.ui.HighScoreTallennin;
import juuri.ui.Pelaaja;
import juuri.ui.Tilausgeneraattori;

public class Varastopeli {

    public static void main(String[] args) throws IOException {
        
        Scanner lukija = new Scanner(System.in);

        Tekstiui kayttis = new Tekstiui(lukija);

        kayttis.kaynnista();
    }
}
    