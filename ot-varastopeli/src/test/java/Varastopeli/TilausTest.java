package Varastopeli;

import juuri.sovelluslogiikka.Tilaus;
import juuri.sovelluslogiikka.Varasto;
import juuri.sovelluslogiikka.Tuote;

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
    public void TilausAlussa() {
        assertTrue(tilaus.getNro() == 0);
        assertTrue(tilaus.isToteutettu() == false);
        tilaus.toteutettu();
        assertTrue(tilaus.isToteutettu() == true);
        assertTrue(tilaus.isToteutettu() == true);
    }
    
    @Test
    public void TilauksenArvoMuuttuu() {
        Tilaus pepe = new Tilaus(a);
        assertTrue(pepe.getArvo() == 0);
        pepe.lisaaTuote("makkara", 2);
        pepe.lisaaTuote("kakkara", 21);
        //assertTrue(pepe.getArvo() == 23);
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

    @Test
    public void TilauksenToteutuskelpoisuus() {
        Tuote hattara = new Tuote(a, "makkara");
        a.lisaaTuote(x, 5);
        tilaus.lisaaTuote("makkara", 3);
        assertTrue(tilaus.toteutuskelpoisuus());
        tilaus.lisaaTuote("makkara", 2);
        assertTrue(tilaus.toteutuskelpoisuus());
        a.otaTuote(x, 3);
        assertFalse(tilaus.toteutuskelpoisuus());
    }
    
    

}
