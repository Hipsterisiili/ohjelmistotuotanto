package Varastopeli;

import juuri.sovelluslogiikka.Tilaus;
import juuri.sovelluslogiikka.Varasto;
import juuri.sovelluslogiikka.Tuote;

import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TuoteTest {
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
    public void uusiTuote() {
        assertTrue(x.getNimi().equals("makkara"));
        assertTrue(x.getId() == 0);
    }
    @Test
    public void tuoteLoytyyVarastosta() {
        assertTrue(a.getTuotteet().contains(x));
    }
    
}
