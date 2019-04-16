package ui;

import java.util.Random;
import sovelluslogiikka.Varasto;
import sovelluslogiikka.Tuote;
import sovelluslogiikka.Tilaus;

public class Tilausgeneraattori {

    private Varasto a;
    private Random rand;

    public Tilausgeneraattori(Varasto varasto) {
        this.a = varasto;
        this.rand = new Random();
    }

    public Tilaus aja(int taso, int vaihe) {
        int i = rand.nextInt(100);
        if (i > 50) {
            Tilaus t = uusi(i);
            return t;
        } else {
            return null;
        }
    }

    public Tilaus uusi(int i) {
        Tilaus tilaus = new Tilaus(a);
        tilaus.lisaaTuote(a.getTuotteet().get(i / 10).getNimi(), (i / 5));
        System.out.println("UUSI TILAUS LISÄTTY VARASTOLLE");
        return tilaus;
    }
}
