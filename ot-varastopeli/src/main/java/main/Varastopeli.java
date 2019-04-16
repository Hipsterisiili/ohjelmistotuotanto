package main;

import ui.Kayttoliittyma;
import java.util.Scanner;
import sovelluslogiikka.Tilaus;
import sovelluslogiikka.Tuote;
import sovelluslogiikka.Varasto;
import ui.Tilausgeneraattori;
import ui.testijuttu;

public class Varastopeli {

    public static void main(String[] args) {
        
        Scanner lukija = new Scanner(System.in);
        
        Varasto a = new Varasto("standardi.txt");
        Tilaus t = new Tilaus(a, "tilaus.txt");
        System.out.println(t);
        
        
        Kayttoliittyma kayttis = new Kayttoliittyma(lukija);
        
        kayttis.kaynnista();
        
    }

}
