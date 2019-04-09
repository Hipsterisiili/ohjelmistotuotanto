package varastopeli;

import varastopeliUI.Kayttoliittyma;
import java.util.Scanner;
import varastopeliLOGIIKKA.Tilaus;
import varastopeliLOGIIKKA.Tuote;
import varastopeliLOGIIKKA.Varasto;

public class Varastopeli {

    public static void main(String[] args) {
        
        Scanner lukija = new Scanner(System.in);
        
        Varasto a = new Varasto();
        
        Tuote x = new Tuote(a, "makkara");
        Tuote y = new Tuote(a, "kakkara");
        Tuote z = new Tuote(a, "jakkara");
        Tilaus tilaus = new Tilaus(a);
        
        
        
        tilaus.lisaaTuote("makkara", 1);
        tilaus.lisaaTuote("kakkara", 10);
        tilaus.poistaTuote("kakkara");
        
        System.out.println(tilaus);
        
        Kayttoliittyma kayttis = new Kayttoliittyma(lukija);
        
        kayttis.kaynnista();
        
        
        

        /*
        
        Varasto varasto = new Varasto();
        Tilaus tilaus = new Tilaus(varasto);
        Tuote mehu = new Tuote(00, "mehu");
        Tuote olut = new Tuote(01, "olut");
        Tuote jauho = new Tuote(02, "jauho");
        Tuote riisi = new Tuote(03, "riisi");
        
        varasto.lisaaTuote(mehu, 1);
        varasto.lisaaTuote(olut, 2);
        varasto.lisaaTuote(jauho, 3);
        varasto.lisaaTuote(riisi, 1);
        
        System.out.println(varasto);
        
        tilaus.LisaaTuote(olut, 2);
        
        System.out.println(tilaus);
        
        tilaus.LisaaTuote(olut, 2);
        tilaus.LisaaTuote(mehu, 2);
        tilaus.LisaaTuote(riisi, 5);
        
        tilaus.poistaTuote(riisi, 2);
        tilaus.poistaTuote(mehu, 2);
        
        System.out.println(tilaus);
        
        tilaus.poistaTuote(olut, 100);
        
        System.out.println(tilaus);*/
    }

}
