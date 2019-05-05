/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Varastopeli;

import juuri.sovelluslogiikka.Pelaaja;
import juuri.sovelluslogiikka.Tilausgeneraattori;
import juuri.sovelluslogiikka.Varasto;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author rasmus
 */
public class PelaajaTest {
    
    
    @Test
    public void TilausOlemassa() {
        Pelaaja pelaaja = new Pelaaja(100, "pekka");
        assertTrue(pelaaja != null);
        assertTrue(pelaaja.getNimi().equals("pekka"));
        assertTrue(pelaaja.getPisteet() == 100);
    }
}
