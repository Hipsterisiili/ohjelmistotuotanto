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
    
    @Test
    public void toStringToimii1() {
        kortti.otaRahaa(5);
        kortti.lataaRahaa(120);
        assertEquals(kortti.toString(), "saldo: 1.25");      
    }
    
    @Test
    public void toStringToimii2() {
        kortti.otaRahaa(120);
        kortti.lataaRahaa(40);
        assertEquals(kortti.toString(), "saldo: 0.50");      
    }
    
    @Test
    public void kortitKommunikoivat() {
        Maksukortti a = new Maksukortti(100);
        a.otaRahaa(40);
        kortti.lataaRahaa(a.saldo());
        assertEquals(kortti.toString(), "saldo: 0.70");      
    }
    
    @Test
    public void isoSekamelska() {
        Maksukortti a = new Maksukortti(100);
        a.lataaRahaa(20);
        System.out.println(a.toString());
        a.otaRahaa(119);
        System.out.println(a.toString());
        a.otaRahaa(99999);
        System.out.println(a.toString());
        a.lataaRahaa(a.saldo());
        System.out.println(a.toString());
        a.lataaRahaa(a.saldo());
        System.out.println(a.toString());
        a.otaRahaa(a.saldo() / 2);
        assertEquals(a.toString(), "saldo: 0.02");      
    }
    
}
