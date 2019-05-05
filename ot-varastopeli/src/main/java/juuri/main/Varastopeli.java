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
        
        HighScoreTallennin hst = new HighScoreTallennin();
        System.out.println(hst.tallennaTulos("jaakko", 10));
        
        Scanner lukija = new Scanner(System.in);

        Tekstiui kayttis = new Tekstiui(lukija);

        kayttis.kaynnista();
    }
}
    