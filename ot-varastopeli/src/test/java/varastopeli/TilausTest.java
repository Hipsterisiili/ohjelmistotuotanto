package varastopeli;

import varastopelilog.Tilaus;
import varastopelilog.Varasto;
import varastopelilog.Tuote;
import java.util.ArrayList;
import org.junit.After;

import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;

public class TilausTest {

    Varasto a;
    Tuote x;
    Tuote y;
    Tuote z;
    Tilaus tilaus;

    @Before
    public void SetUp() {
        a = new Varasto();
        x = new Tuote(a, "makkara");
        y = new Tuote(a, "kakkara");
        z = new Tuote(a, "jakkara");
        tilaus = new Tilaus(a);
    }

    @Test
    public void TilausOlemassa() {
        assertTrue(tilaus != null);
    }

    @Test
    public void TilaukseenLisaaminenToimiiVaikkaTuoteEiOlemassa() {
        tilaus.lisaaTuote("makkara", 1);
        tilaus.lisaaTuote("jakkara", 0);
        tilaus.lisaaTuote("kakkara", 10);
        assertTrue(tilaus.toString().equals(
                "id/nimi/maara \n"
                + "0/makkara/1\n"
                + "1/kakkara/10\n"));
    }

    @Test
    public void TilaukseenLisaaminenToimiiKunVirheellinenMaara() {
        tilaus.lisaaTuote("makkara", 1);
        tilaus.lisaaTuote("kakkara", 10);
        tilaus.lisaaTuote("makkara", 20);
        tilaus.lisaaTuote("kakkara", -1);
        tilaus.lisaaTuote("enoleoikea", 1);
        assertTrue(tilaus.toString().equals(
                "id/nimi/maara \n"
                + "0/makkara/20\n"
                + "1/kakkara/10\n"));
    }

    @Test
    public void TilauksestaPoistaminenNormaalioloissa() {
        tilaus.lisaaTuote("makkara", 1);
        tilaus.lisaaTuote("kakkara", 10);
        tilaus.poistaTuote("kakkara");
        assertTrue(tilaus.toString().equals(
                "id/nimi/maara \n"
                + "0/makkara/1\n"));
    }

    @Test
    public void TilauksestaPoistaminenKunTuotettaEiTilauksessa() {
        tilaus.lisaaTuote("makkara", 1);
        tilaus.lisaaTuote("kakkara", 10);
        tilaus.poistaTuote("jakkara");
        assertTrue(tilaus.toString().equals(
                "id/nimi/maara \n"
                + "0/makkara/1\n"
                + "1/kakkara/10\n"));
    }

}
