package varastopeli;

import varastopeliLOGIIKKA.Varasto;
import varastopeliLOGIIKKA.Tuote;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto a;
    Tuote x;
    Tuote y;
    Tuote z;

    @Before
    public void SetUp() {
        Varasto a = new Varasto();
        Tuote x = new Tuote(a, "makkara");
        Tuote y = new Tuote(a, "kakkara");
        Tuote z = new Tuote(a, "jakkara");
    }

    @Test
    public void VarastonMaksimikokoOikein() {
        Varasto a = new Varasto();
        assertTrue(a.getMaksimikoko() == 100);
        assertTrue(a.getMaarat().isEmpty());
        assertTrue(a.getTuotteet().isEmpty());
        assertTrue(a.getTilaukset().isEmpty());
    }

    @Test
    public void VarastonToStringKunTyhja() {
        Varasto a = new Varasto();
        assertTrue(a.toString().equals("id/nimi/maara\n"));
    }

    @Test
    public void VarastonToStringKunKolmeTuotetta() {
        Varasto a = new Varasto();
        Tuote x = new Tuote(a, "makkara");
        Tuote y = new Tuote(a, "kakkara");
        Tuote z = new Tuote(a, "jakkara");
        a.lisaaTuote(x, 3);
        a.lisaaTuote(y, 1);
        a.lisaaTuote(z, 0);
        assertTrue(a.toString().equals("id/nimi/maara\n"
                + "0/makkara/3\n"
                + "1/kakkara/1\n"
                + "2/jakkara/0\n"));
        assertTrue(a.getTuotteet().size() == 3);
    }

    @Test
    public void lisataanTuotettaNegatiivinenMaara() {
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
        assertTrue(a.toString().equals("id/nimi/maara\n"
                + "0/makkara/3\n"
                + "1/kakkara/1\n"
                + "2/jakkara/0\n"
                + "3/päivänkakkara/0\n"
                + "4/hattara/0\n"));
    }

    @Test
    public void JosLisataanVarastoonYli20TuotettaKerralla() {
        Varasto a = new Varasto();
        Tuote x = new Tuote(a, "makkara");
        Tuote y = new Tuote(a, "kakkara");
        Tuote z = new Tuote(a, "jakkara");
        a.lisaaTuote(x, 50);
        a.lisaaTuote(y, 2);
        a.lisaaTuote(z, 50);
        assertTrue(a.toString().equals("id/nimi/maara\n"
                + "0/makkara/20\n"
                + "1/kakkara/2\n"
                + "2/jakkara/20\n"));
    }

    @Test
    public void OtetaanVarastosta1() {
        Varasto a = new Varasto();
        Tuote x = new Tuote(a, "makkara");
        a.lisaaTuote(x, 10);
        assertTrue(a.otaTuote(x, 5) == 5);
        assertTrue(a.getMaarat().get(x.getId()) == 5);
    }

    @Test
    public void OtetaanVarastostaVakisin() {
        Varasto a = new Varasto();
        Tuote x = new Tuote(a, "makkara");
        a.lisaaTuote(x, 10);
        assertTrue(a.otaTuoteVakisin(x, 5) == 5);
        assertTrue(a.getMaarat().get(x.getId()) == 5);
    }

    @Test
    public void OtetaanVarastostaLiikaa() {
        Varasto a = new Varasto();
        Tuote x = new Tuote(a, "makkara");
        a.lisaaTuote(x, 10);
        assertTrue(a.otaTuote(x, 11) == -1);
        assertTrue(a.getMaarat().get(x.getId()) == 10);
    }

    @Test
    public void OtetaanVarastostaVakisinLiikaa() {
        Varasto a = new Varasto();
        Tuote x = new Tuote(a, "makkara");
        a.lisaaTuote(x, 10);
        assertTrue(a.otaTuoteVakisin(x, 11) == 10);
        assertTrue(a.getMaarat().get(x.getId()) == 00);
    }

}
