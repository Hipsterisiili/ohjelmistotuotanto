package juuri.ui;

import java.util.Random;
import juuri.sovelluslogiikka.Varasto;
import juuri.sovelluslogiikka.Tuote;
import juuri.sovelluslogiikka.Tilaus;

public class Tilausgeneraattori {

    private Varasto a;
    private Random rand;

    /**
     * Konstruktori luo tilausgeneraattorin, määrittää sille kuuluvan
     * varaston ja luo uden Random-muuttujan.
     *
     * @param varasto tilausgeneraattorille annettava varasto
     */
    public Tilausgeneraattori(Varasto varasto) {
        this.a = varasto;
        this.rand = new Random();
    }
    
    /**
     * Metodi päivittää varaston tilaustilanteen tason ja vaiheen
     * mukaiseksi, kun ajetaan varastopeliä.
     * Tasolla n kutsutaan metodia tason(int), mutta jos pelaaja on jo
     * tasolla 4 tai enemmän, kutsutaan aina metodia taso4(int)
     * @see    juuri.ui.Tilausgeneraattori#taso1(int)
     * @see    juuri.ui.Tilausgeneraattori#taso2(int)
     * @see    juuri.ui.Tilausgeneraattori#taso3(int)
     * @see    juuri.ui.Tilausgeneraattori#taso4(int)
     *
     * @param taso taso, jolla pelaaja on tällä hetkellä
     * @param vaihe missä vaiheessa em. tasoa ollaan
     */
    public void aja(int taso, int vaihe) {
        if (taso == 1) {
            taso1(vaihe);
        } else if (taso == 2) {
            taso2(vaihe);
        } else if (taso == 2) {
            taso3(vaihe);
        } else {
            taso4(vaihe);
        }
    }
    
    /**
     * Metodi tarkastelee ensin kuuluuko sen luoda tällä tasolla
     * ja uusi tilaus. Jos kuuluu, se luo uuden tilauksen kutsuen 
     * Tilauksen konstruktoria Tilaus(Varasto, String, int).
     * Jos vaihe on 0, luodaan ns. finalBoss-tilaus
     * 
     * @see    juuri.sovelluslogiikka.Tilaus#Tilaus(Varasto, String, int)
     * @see    juuri.ui.Tilausgeneraattori#finalBoss()
     * 
     * @return palauttaa luodun tilauksen.
     */
    public Tilaus taso1(int i) {
        int num = rand.nextInt(9);
        Tilaus tilaus = null;
        if (i % 2 == 1) {
            String s = "10/ananas/3\n"
                    + "11/banaani/3\n"
                    + "12/curry/3\n"
                    + "13/ananas/4\n"
                    + "14/banaani/4\n"
                    + "15/curry/4\n"
                    + "16/ananas/5\n"
                    + "17/banaani/5\n"
                    + "18/curry/5\n"
                    + "19/ananas/7";
            tilaus = new Tilaus(a, s, num);
        }
        return tilaus;
    }

    /**
     * Metodi tarkastelee ensin kuuluuko sen luoda tällä tasolla
     * ja uusi tilaus. Jos kuuluu, se luo uuden tilauksen kutsuen 
     * Tilauksen konstruktoria Tilaus(Varasto, String, int).
     * Jos vaihe on 0, luodaan ns. finalBoss-tilaus
     * 
     * @see    juuri.sovelluslogiikka.Tilaus#Tilaus(Varasto, String, int)
     * @see    juuri.ui.Tilausgeneraattori#finalBoss()
     * 
     * @return palauttaa luodun tilauksen.
     */
    public Tilaus taso2(int i) {
        int num = rand.nextInt(9);
        Tilaus tilaus = null;
        if (i % 2 == 0) {
            String s = "10/ananas/11/banaani/8\n"
                    + "11/banaani/3/curry/16\n"
                    + "12/curry/11/dijon/8\n"
                    + "13/dijon/17/etikka/2\n"
                    + "14/etikka/3/banaani/16\n"
                    + "15/dijon/7/ananas/12\n"
                    + "16/curry/11/dijon/8\n"
                    + "17/banaani/13/dijon/6\n"
                    + "18/ananas/17/curry/2\n"
                    + "19/etikka/5/banaani/14";
            tilaus = new Tilaus(a, s, num);
        }
        return tilaus;
    }

    /**
     * Metodi tarkastelee ensin kuuluuko sen luoda tällä tasolla
     * ja uusi tilaus. Jos kuuluu, se luo uuden tilauksen kutsuen 
     * Tilauksen konstruktoria Tilaus(Varasto, String, int).
     * Jos vaihe on 0, luodaan ns. finalBoss-tilaus
     * 
     * @see    juuri.sovelluslogiikka.Tilaus#Tilaus(Varasto, String, int)
     * @see    juuri.ui.Tilausgeneraattori#finalBoss()
     * 
     * @return palauttaa luodun tilauksen.
     */
    public Tilaus taso3(int i) {
        int num = rand.nextInt(9);
        Tilaus tilaus = null;
        if (i % 3 == 0 || i == 1) {
            String s = "10/ananas/11/banaani/8/greippi/10\n"
                    + "11/banaani/3/curry/16/dijon/10\n"
                    + "12/curry/11/dijon/8/ananas/10\n"
                    + "13/dijon/17/etikka/2/greippi/10\n"
                    + "14/etikka/3/falafel/16/ananas/5\n"
                    + "15/etikka/7/falafel/12/greippi/5\n"
                    + "16/banaani/11/curry/8/dijon/5\n"
                    + "17/ananas/13/curry/6/dijon/18\n"
                    + "18/curry/17/falafel/2/greippi/18\n"
                    + "19/ananas/5/falafel/14/greippi/2";
            tilaus = new Tilaus(a, s, num);
        }
        if (i == 0) {
            return finalBoss();
        }
        return tilaus;
    }

    /**
     * Metodi tarkastelee ensin kuuluuko sen luoda tällä tasolla
     * ja uusi tilaus. Jos kuuluu, se luo uuden tilauksen kutsuen 
     * Tilauksen konstruktoria Tilaus(Varasto, String, int).
     * Jos vaihe on 0, luodaan ns. finalBoss-tilaus
     * @see    juuri.sovelluslogiikka.Tilaus#Tilaus(Varasto, String, int)
     * @see    juuri.ui.Tilausgeneraattori#finalBoss()
     * 
     * @param vaihe missä vaiheessa tasoa ollaan
     * 
     * @return palauttaa luodun tilauksen.
     */
    public Tilaus taso4(int i) {
        int num = rand.nextInt(9);
        Tilaus tilaus = null;
        if (i == 0) {
            return finalBoss();
        }
        if (i == 2 || i == 5 || i == 7 || i == 9) {
            String s = "10/ananas/11/juusto/8/kurkku/10\n"
                    + "11/greippi/3/inkivaari/16/juusto/10\n"
                    + "12/curry/11/dijon/8/hedelma/10\n"
                    + "13/etikka/17/inkivaari/2/kurkku/10\n"
                    + "14/banaani/3/falafel/16/greippi/5\n"
                    + "15/etikka/7/falafel/12/kurkku/5\n"
                    + "16/banaani/11/curry/8/dijon/5\n"
                    + "17/ananas/13/inkivaari/6/hedelma/18\n"
                    + "18/curry/17/falafel/2/greippi/18\n"
                    + "19/ananas/5/curry/14/hedelma/2";
            tilaus = new Tilaus(a, s, num);
        }
        return tilaus;
    }

    /**
     * Metodi luo uuden vaikean tilauksen, jossa on yksi jokaista
     * tuotetta ja sitten palauttaa sen. Tilaus luodsaan kutsuen 
     * Tilauksen parametria Tilaus(Varasto, String, int)
     * @see    juuri.sovelluslogiikka.Tilaus#Tilaus(Varasto, String, int)
     * 
     * @return palauttaa luodun tilauksen.
     */
    public Tilaus finalBoss() {
        String s = "10/ananas/1/banaani/1/curry/1/dijon/1/etikka/1/falafel/1/greippi/1/hedelma/1/inkivaari/1/juusto/1/kurkku/1";
        Tilaus tilaus = new Tilaus(a, s, 0);
        return tilaus;
    }
}
