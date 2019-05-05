package juuri.ui;

import java.util.Random;
import juuri.sovelluslogiikka.Varasto;
import juuri.sovelluslogiikka.Tuote;
import juuri.sovelluslogiikka.Tilaus;

public class Tilausgeneraattori {

    private Varasto a;
    private Random rand;

    /**
     * Konstruktori luo tilausgeneraattorin, määrittää sille kuuluvan varaston
     * ja luo uden Random-muuttujan.
     *
     * @param varasto tilausgeneraattorille annettava varasto
     */
    public Tilausgeneraattori(Varasto varasto) {
        this.a = varasto;
        this.rand = new Random();
    }

    /**
     * Metodi päivittää varaston tilaustilanteen tason ja vaiheen mukaiseksi,
     * kun ajetaan varastopeliä. Tasolla n kutsutaan metodia tason(int), mutta
     * jos pelaaja on jo tasolla 4 tai enemmän, kutsutaan aina metodia
     * taso4(int)
     *
     * @see juuri.ui.Tilausgeneraattori#taso1(int)
     * @see juuri.ui.Tilausgeneraattori#taso2(int)
     * @see juuri.ui.Tilausgeneraattori#taso3(int)
     * @see juuri.ui.Tilausgeneraattori#taso4(int)
     *
     * @param taso taso, jolla pelaaja on tällä hetkellä
     * @param vaihe missä vaiheessa em. tasoa ollaan
     */
    public void aja(int taso, int vaihe) {
        if (taso == 1) {
            taso1(vaihe);
        } else if (taso == 2) {
            taso2(vaihe);
        } else if (taso == 3) {
            taso3(vaihe);
        } else if (taso == 4) {
            taso4(vaihe);
        } else {
            taso5(vaihe);
        }
    }

    /**
     * Metodi tarkastelee ensin kuuluuko sen luoda tällä tasolla ja uusi tilaus.
     * Jos kuuluu, se luo uuden tilauksen kutsuen Tilauksen konstruktoria
     * Tilaus(Varasto, String, int).
     *
     * @see juuri.sovelluslogiikka.Tilaus#Tilaus(Varasto, String, int)
     * @see juuri.ui.Tilausgeneraattori#finalBoss()
     *
     * @return palauttaa luodun tilauksen.
     */
    public Tilaus taso1(int i) {
        int num = rand.nextInt(9);
        Tilaus tilaus = null;
        if (i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9) {
            String s = "10/ananas/5\n"
                    + "11/banaani/5\n"
                    + "12/curry/5\n"
                    + "13/ananas/6\n"
                    + "14/banaani/6\n"
                    + "15/curry/6\n"
                    + "16/ananas/7\n"
                    + "17/banaani/7\n"
                    + "18/curry/7\n"
                    + "19/ananas/10";
            tilaus = new Tilaus(a, s, num);
        }
        return tilaus;
    }

    /**
     * Metodi tarkastelee ensin kuuluuko sen luoda tällä tasolla ja uusi tilaus.
     * Jos kuuluu, se luo uuden tilauksen kutsuen Tilauksen konstruktoria
     * Tilaus(Varasto, String, int). Jos vaihe on 1, luodaan ns.
     * finalBoss-tilaus
     *
     * @see juuri.sovelluslogiikka.Tilaus#Tilaus(Varasto, String, int)
     * @see juuri.ui.Tilausgeneraattori#finalBoss()
     *
     * @return palauttaa luodun tilauksen.
     */
    public Tilaus taso2(int i) {
        int num = rand.nextInt(9);
        Tilaus tilaus = null;
        if (i == 1) {
            return finalBoss2();
        }
        if (i % 2 == 1) {
            String s = "10/ananas/11/banaani/8\n11/banaani/3/curry/16\n"
                    + "12/curry/11/dijon/8\n13/dijon/17/etikka/2\n"
                    + "14/etikka/3/banaani/16\n15/dijon/7/ananas/12\n"
                    + "16/curry/11/dijon/8\n17/banaani/13/dijon/6\n"
                    + "18/ananas/17/curry/2\n19/etikka/5/banaani/14"
                    + "20/banaani/11/curry/8\n21/curry/3/dijon/16\n"
                    + "22/dijon/11/etikka/8\n23/etikka/17/ananas/2\n"
                    + "24/ananas/3/curry/16\n25/etikka/7/banaani/12\n";
            tilaus = new Tilaus(a, s, num);
        }
        return tilaus;
    }

    /**
     * Metodi tarkastelee ensin kuuluuko sen luoda tällä tasolla ja uusi tilaus.
     * Jos kuuluu, se luo uuden tilauksen kutsuen Tilauksen konstruktoria
     * Tilaus(Varasto, String, int). Jos vaihe on 1, luodaan ns.
     * finalBoss-tilaus
     *
     * @see juuri.sovelluslogiikka.Tilaus#Tilaus(Varasto, String, int)
     * @see juuri.ui.Tilausgeneraattori#finalBoss()
     *
     * @return palauttaa luodun tilauksen.
     */
    public Tilaus taso3(int i) {
        int num = rand.nextInt(9);
        Tilaus tilaus = null;
        if (i == 1) {
            return finalBoss3();
        }
        if (i % 2 == 1) {
            String s = "10/ananas/5/banaani/8/greippi/8\n11/banaani/3/curry/12/dijon/8\n"
                    + "12/curry/11/dijon/8/ananas/8\n13/dijon/7/etikka/9/greippi/8\n"
                    + "14/etikka/9/falafel/6/ananas/3\n15/etikka/7/falafel/6/greippi/3\n"
                    + "16/banaani/3/curry/5/dijon/5\n17/ananas/3/curry/7/dijon/5\n"
                    + "18/curry/5/falafel/7/greippi/5\n19/ananas/8/falafel/4/greippi/5"
                    + "14/dijon/9/greippi/6/banaani/3\n15/dijon/7/greippi/6/hedelma/3\n"
                    + "16/ananas/3/dijon/5/etikka/5\n17/kurkku/3/dijon/7/etikka/5\n"
                    + "18/banaani/5/greippi/7/kurkku/5\n19/banaani/8/falafel/4/kurkku/5";;
            tilaus = new Tilaus(a, s, num);
        }
        return tilaus;
    }

    /**
     * Metodi tarkastelee ensin kuuluuko sen luoda tällä tasolla ja uusi tilaus.
     * Jos kuuluu, se luo uuden tilauksen kutsuen Tilauksen konstruktoria
     * Tilaus(Varasto, String, int). Jos vaihe on 1, luodaan ns.
     * finalBoss-tilaus
     *
     * @see juuri.sovelluslogiikka.Tilaus#Tilaus(Varasto, String, int)
     * @see juuri.ui.Tilausgeneraattori#finalBoss()
     *
     * @param vaihe missä vaiheessa tasoa ollaan
     *
     * @return palauttaa luodun tilauksen.
     */
    public Tilaus taso4(int i) {
        int num = rand.nextInt(9);
        Tilaus tilaus = null;
        if (i == 1) {
            return finalBoss4();
        }
        if (i % 2 == 1) {
            String s = "10/ananas/11/juusto/8/kurkku/10\n11/greippi/3/inkivaari/16/juusto/10\n"
                    + "12/curry/11/dijon/8/hedelma/10\n13/etikka/17/inkivaari/2/kurkku/10\n"
                    + "14/banaani/3/falafel/16/greippi/5\n15/etikka/7/falafel/12/kurkku/5\n"
                    + "16/banaani/11/curry/8/dijon/5\n17/ananas/13/inkivaari/6/hedelma/18\n"
                    + "18/curry/17/falafel/2/greippi/18\n19/ananas/11/curry/14/hedelma/2"
                    + "20/banaani/11/kurkku/8/ananas/10\n21/hedelma/3/juusto/16/kurkku/10\n"
                    + "22/dijom/11/etikka/8/inkivaari/10\n23/falafel/17/juusto/2/ananas/10\n"
                    + "24/curry/3/greippi/16/hedelma/5\n25/falafel/7/greippi/12/ananas/5\n";
            tilaus = new Tilaus(a, s, num);
        }
        return tilaus;
    }

    public Tilaus taso5(int i) {
        int num = rand.nextInt(9);
        Tilaus tilaus = null;
        if (i == 1) {
            return finalBoss5();
        }
        if (i % 2 == 1) {
            String s = "10/ananas/11/juusto/8/kurkku/10\n11/greippi/3/inkivaari/16/juusto/10\n"
                    + "12/curry/11/dijon/8/hedelma/10\n13/etikka/17/inkivaari/2/kurkku/10\n"
                    + "14/banaani/3/falafel/16/greippi/5\n15/etikka/7/falafel/12/kurkku/5\n"
                    + "16/banaani/11/curry/8/dijon/5\n17/ananas/13/inkivaari/6/hedelma/18\n"
                    + "18/curry/17/falafel/2/greippi/18\n19/ananas/11/curry/14/hedelma/2\n"
                    + "20/banaani/11/kurkku/8/ananas/10\n21/hedelma/3/juusto/16/kurkku/10\n"
                    + "22/dijon/11/etikka/8/inkivaati/10\n23/falafel/17/juusto/2/ananas/10\n"
                    + "24/curry/3/greippi/16/hedelma/5\n25/falafel/7/greippi/12/ananas/5\n"
                    + "26/curry/11/dijon/8/etikka/5\n27/banaani/13/juusto/6/inkivaari/18\n"
                    + "28/dijon/17/greippi/2/hedelma/18\n29/banaani/11/dijon/14/inkivaari/2\n";
            tilaus = new Tilaus(a, s, num);
        }
        return tilaus;
    }

    /**
     * Metodi luo uuden vaikean tilauksen joita on kolme erilaista arkkityyppiä
     * sitten palauttaa sen. Tilaus luodsaan kutsuen Tilauksen parametria
     * Tilaus(Varasto, String, int)
     *
     * @see juuri.sovelluslogiikka.Tilaus#Tilaus(Varasto, String, int)
     *
     * @return palauttaa luodun tilauksen.
     */
    public Tilaus finalBoss2() {
        String s;
        s = "10/ananas/5/banaani/5/curry/5/dijon/5/etikka/5/falafel/5/greippi/5/hedelma/5/inkivaari/5/juusto/5/kurkku/5";
        Tilaus tilaus = new Tilaus(a, s, 0);
        return tilaus;
    }

    /**
     * Metodi luo uuden vaikean tilauksenn joita on kolme erilaista arkkityyppiä
     * sitten palauttaa sen. Tilaus luodsaan kutsuen Tilauksen parametria
     * Tilaus(Varasto, String, int)
     *
     * @see juuri.sovelluslogiikka.Tilaus#Tilaus(Varasto, String, int)
     *
     * @return palauttaa luodun tilauksen.
     */
    public Tilaus finalBoss3() {
        String s;
        s = "10/banaani/10/dijon/10/falafel/10/hedelma/10/juusto/10/";
        Tilaus tilaus = new Tilaus(a, s, 0);
        return tilaus;
    }

    /**
     * Metodi luo uuden vaikean tilauksenn joita on kolme erilaista arkkityyppiä
     * sitten palauttaa sen. Tilaus luodsaan kutsuen Tilauksen parametria
     * Tilaus(Varasto, String, int)
     *
     * @see juuri.sovelluslogiikka.Tilaus#Tilaus(Varasto, String, int)
     *
     * @return palauttaa luodun tilauksen.
     */
    public Tilaus finalBoss4() {
        String s;
        s = "10/ananas/10/curry/10/etikka/10/greippi/10/inkivaari/10/kurkku/10";
        Tilaus tilaus = new Tilaus(a, s, 0);
        return tilaus;
    }

    /**
     * Metodi luo uuden vaikean tilauksenn joita on kolme erilaista arkkityyppiä
     * sitten palauttaa sen. Tilaus luodsaan kutsuen Tilauksen parametria
     * Tilaus(Varasto, String, int)
     *
     * @see juuri.sovelluslogiikka.Tilaus#Tilaus(Varasto, String, int)
     *
     * @return palauttaa luodun tilauksen.
     */
    public Tilaus finalBoss5() {
        int num = rand.nextInt(2);
        String s;
        if (num == 0) {
            s = "10/ananas/5/banaani/5/curry/5/dijon/5/etikka/5/falafel/5/greippi/5/hedelma/5/inkivaari/5/juusto/5/kurkku/5";
        } else if (num == 1) {
            s = "10/ananas/10/curry/10/etikka/10/greippi/10/inkivaari/10/kurkku/10";
        } else {
            s = "10/banaani/10/dijon/10/falafel/10/hedelma/10/juusto/10";
        }
        Tilaus tilaus = new Tilaus(a, s, 0);
        return tilaus;
    }
}
