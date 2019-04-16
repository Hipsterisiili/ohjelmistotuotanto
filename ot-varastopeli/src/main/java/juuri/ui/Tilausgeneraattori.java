package juuri.ui;

import java.util.Random;
import juuri.sovelluslogiikka.Varasto;
import juuri.sovelluslogiikka.Tuote;
import juuri.sovelluslogiikka.Tilaus;

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
        } else if (taso == 2) {
            taso2(vaihe);
        } else {
            taso3(vaihe);
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
    
    public Tilaus taso3(int i) {
        int num = rand.nextInt(10) - 1;
        Tilaus tilaus = null;
        if (i < 5) {
            tilaus = new Tilaus(a, "tilaus3.txt", num);
        }
        return tilaus;
    }
}
