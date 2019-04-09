package varastopeli;

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
    public void TilaukseenLisaaminenToimiiKunTuoteOlemassa() {
        tilaus.LisaaTuote("makkara", 2);
        
        assertTrue(tilaus != null);
    }
    
    
}
