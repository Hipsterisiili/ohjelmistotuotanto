/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Varastopeli;

import juuri.sovelluslogiikka.Tilaus;
import juuri.sovelluslogiikka.Tuote;
import juuri.sovelluslogiikka.Varasto;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import juuri.sovelluslogiikka.Tilaus;
import juuri.sovelluslogiikka.Tilausgeneraattori;
import juuri.sovelluslogiikka.Varasto;
import juuri.sovelluslogiikka.Tuote;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rasmus
 */
public class TilausGeneraattoriTest {

    Varasto a;
    Tuote x;
    Tuote y;
    Tuote z;
    Tilaus tilaus;
    Tilausgeneraattori tg;

    @Before
    public void SetUp() {
        a = new Varasto();
        tg = new Tilausgeneraattori(a);

    }

    @Test
    public void TilausOlemassa() {
        a = new Varasto();
        tg = new Tilausgeneraattori(a);
        assertTrue(tg != null);
    }

    @Test
    public void TGTaso1() {
        a = new Varasto("0/ananas/15\n"
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
        tg = new Tilausgeneraattori(a);
        tg.aja(1, 1);
        assertTrue(a.getTilaukset().size() == 1);
    }

    @Test
    public void TGTaso2() {
        a = new Varasto("0/ananas/15\n"
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
        tg = new Tilausgeneraattori(a);
        tg.aja(2, 1);

        assertTrue(a.getTilaukset().size() == 1);
        assertTrue(a.getTilaukset().get(0).toteutuskelpoisuus());
        assertFalse(a.getTilaukset().get(0).isToteutettu());
        assertTrue(a.getTilaukset().get(0).getMaarat()[10] == 5);
        a.getTilaukset().get(0).toteutettu();
        assertTrue(a.getTilaukset().get(0).isToteutettu());
    }

    @Test
    public void TGTaso3() {
        a = new Varasto("0/ananas/15\n"
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
        tg = new Tilausgeneraattori(a);
        tg.aja(3, 1);

        assertTrue(a.getTilaukset().size() == 1);
        assertFalse(a.getTilaukset().get(0).toteutuskelpoisuus());
        assertFalse(a.getTilaukset().get(0).isToteutettu());
        assertTrue(a.getTilaukset().get(0).getMaarat()[9] == 10);
    }

    @Test
    public void TGTaso4() {
        a = new Varasto("0/ananas/15\n"
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
        tg = new Tilausgeneraattori(a);
        tg.aja(4, 1);

        assertTrue(a.getTilaukset().size() == 1);
        assertFalse(a.getTilaukset().get(0).toteutuskelpoisuus());
        assertFalse(a.getTilaukset().get(0).isToteutettu());
        assertTrue(a.getTilaukset().get(0).getMaarat()[10] == 10);
    }

    @Test
    public void TGTaso5() {
        a = new Varasto("0/ananas/15\n"
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
        tg = new Tilausgeneraattori(a);
        tg.aja(5, 1);

        assertTrue(a.getTilaukset().size() == 1);
        assertTrue(a.getTilaukset().get(0).getMaarat()[10] == 5 && a.getTilaukset().get(0).toteutuskelpoisuus()
                || a.getTilaukset().get(0).getMaarat()[10] == 10 && !a.getTilaukset().get(0).toteutuskelpoisuus()
                || a.getTilaukset().get(0).getMaarat()[9] == 10 && !a.getTilaukset().get(0).toteutuskelpoisuus()
        );
        assertFalse(a.getTilaukset().get(0).isToteutettu());

        assertTrue(a.getTilaukset().get(0).getMaarat()[10] == 10
                || a.getTilaukset().get(0).getMaarat()[10] == 5
                || a.getTilaukset().get(0).getMaarat()[10] == 0);
    }
}
