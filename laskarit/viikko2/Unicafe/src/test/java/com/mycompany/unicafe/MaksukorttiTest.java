package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinSaldoOnOikea() {
        assertEquals(kortti.saldo(), 10);      
    }
    
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(111);
        assertEquals(kortti.saldo(), 121);      
    }
    
    @Test
    public void saldoVaheneeOikein() {
        kortti.otaRahaa(4);
        assertEquals(kortti.saldo(), 6);      
    }
    
    @Test
    public void saldoEiVäheneJosKoyha() {
        kortti.otaRahaa(100);
        assertEquals(kortti.saldo(), 10);      
    }
    
    @Test
    public void palauttaaTrueKunPitaakin() {
        assertEquals(kortti.otaRahaa(2), true);      
    }
    
    @Test
    public void palauttaaFalseKunPitaakin() {
        assertEquals(kortti.otaRahaa(20), false);      
    }
}
