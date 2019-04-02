package varastopeli;

public class Varastopeli {

    public static void main(String[] args) {

        Varasto a = new Varasto();
        Tuote x = new Tuote(a, "makkara");
        Tuote y = new Tuote(a, "kakkara");
        Tuote z = new Tuote(a, "jakkara");
        Tuote xx = new Tuote(a, "päivänkakkara");
        Tuote yy = new Tuote(a, "hattara");

        a.lisaaTuote(x, 3);
        a.lisaaTuote(xx, -2);
        a.lisaaTuote(y, 1);
        a.lisaaTuote(yy, -1);
        a.lisaaTuote(z, 0);
        a.lisaaTuote(yy, -999);
        
        System.out.println(a);

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
