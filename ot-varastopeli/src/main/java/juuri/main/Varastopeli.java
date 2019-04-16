package juuri.main;

import juuri.ui.Kayttoliittyma;
import java.util.Scanner;
import juuri.sovelluslogiikka.Tilaus;
import juuri.sovelluslogiikka.Tuote;
import juuri.sovelluslogiikka.Varasto;
import juuri.ui.Tilausgeneraattori;
import juuri.ui.testijuttu;

public class Varastopeli {

    public static void main(String[] args) {
        
        Scanner lukija = new Scanner(System.in);
        
        Varasto a = new Varasto("standardi.txt");
        
        System.out.println(a.tilaukset());
        
        Kayttoliittyma kayttis = new Kayttoliittyma(lukija);
        
        kayttis.kaynnista();
        
    }

}
