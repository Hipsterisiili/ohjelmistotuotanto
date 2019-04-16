package main;

import ui.Kayttoliittyma;
import java.util.Scanner;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sovelluslogiikka.Tilaus;
import sovelluslogiikka.Tuote;
import sovelluslogiikka.Varasto;
import ui.testijuttu;

public class Varastopeli {

    public static void main(String[] args) {
        
        Scanner lukija = new Scanner(System.in);
        
        
        
        Varasto a = new Varasto("standardi.txt");
        System.out.println(a);
        
        Tilaus t = new Tilaus(a, "standardi.txt");
        
        System.out.println(t);
        
        
        /*Varasto a = new Varasto("standardi.txt");
        Kayttoliittyma kayttis = new Kayttoliittyma(lukija);
        kayttis.kaynnista();
        */
    }

}
