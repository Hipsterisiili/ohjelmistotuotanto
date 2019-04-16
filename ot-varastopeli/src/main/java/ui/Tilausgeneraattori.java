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

    public void aja(int taso, int vaihe) {

        if (taso == 1) {
            taso1(vaihe);
        } else {
            taso2(vaihe);
        }

    }

    public Tilaus taso1(int i) {
        int num = rand.nextInt(10) - 1;
        Tilaus tilaus = null;
        if (i < 6) {
            tilaus = new Tilaus(a, "tilaus1.txt", num);
        }
        return tilaus;
    }

    public Tilaus taso2(int i) {
        int num = rand.nextInt(10) - 1;
        Tilaus tilaus = null;
        if (i < 4) {
            tilaus = new Tilaus(a, "tilaus2.txt", num);
        }
        return tilaus;
    }
}
