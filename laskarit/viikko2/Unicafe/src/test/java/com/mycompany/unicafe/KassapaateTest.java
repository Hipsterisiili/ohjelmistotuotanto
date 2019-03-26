/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rasmus
 */
public class KassapaateTest {

    Kassapaate kp;
    Maksukortti mk;

    @Before
    public void setUp() {
        kp = new Kassapaate();
        mk = new Maksukortti(1000);
    }

    @Test
    public void kassaPaateOlemassa() {
        assertTrue(kp != null);
    }

    @Test
    public void kassapaatteellaOikeaSaldo() {
        assertEquals(kp.kassassaRahaa(), 100000);
    }

    @Test
    public void myydytLounaatOikein() {

        String pepe = "" + kp.maukkaitaLounaitaMyyty()
                + "/" + kp.edullisiaLounaitaMyyty();
        assertEquals(pepe, "0/0");
    }

    @Test
    public void maukkaastiSyominenOttaaRahat() {

        kp.syoMaukkaasti(1000);
        assertEquals(kp.kassassaRahaa(), 100400);
    }

    @Test
    public void maukkaastiSyominenKasvattaa() {

        kp.syoMaukkaasti(1000);
        kp.syoEdullisesti(1000);
        kp.syoEdullisesti(1000);
        kp.syoMaukkaasti(1000);
        kp.syoMaukkaasti(1000);
        assertEquals(kp.maukkaitaLounaitaMyyty(), 3);
    }

    @Test
    public void koyhaSyoMaukkaasti1() {

        kp.syoMaukkaasti(300);
        assertEquals(kp.kassassaRahaa(), 100000);
    }

    @Test
    public void koyhaSyoMaukkaasti2() {

        kp.syoMaukkaasti(300);
        assertEquals(kp.maukkaitaLounaitaMyyty(), 0);
    }

    @Test
    public void koyhaSyoEdullisesti1() {

        kp.syoEdullisesti(200);
        assertEquals(kp.kassassaRahaa(), 100000);
    }

    @Test
    public void koyhaSyoEdullisesti2() {

        kp.syoMaukkaasti(200);
        assertEquals(kp.edullisiaLounaitaMyyty(), 0);
    }
    
    @Test
    public void saastavainenSyoMaukkaasti1() {

        kp.syoMaukkaasti(400);
        assertEquals(kp.maukkaitaLounaitaMyyty(), 1);
    }

    @Test
    public void saastavainenSyoMaukkaasti2() {

        kp.syoMaukkaasti(400);
        assertEquals(kp.kassassaRahaa(), 100400);
    }
    
    @Test
    public void saastavainenSyoEdullisesti1() {

        kp.syoEdullisesti(240);
        assertEquals(kp.edullisiaLounaitaMyyty(), 1);
    }

    @Test
    public void saastavainenSyoEdullisesti2() {

        kp.syoEdullisesti(240);
        assertEquals(kp.kassassaRahaa(), 100240);
    }

    @Test
    public void edullisestiSyominenKasvattaa() {

        kp.syoEdullisesti(1000);
        kp.syoEdullisesti(1000);
        kp.syoEdullisesti(1000);
        kp.syoMaukkaasti(1000);
        kp.syoMaukkaasti(1000);
        assertEquals(kp.edullisiaLounaitaMyyty(), 3);
    }

    @Test
    public void edullisestiSyominenJosKoyha() {

        kp.syoEdullisesti(mk);
        kp.syoEdullisesti(mk);
        kp.syoEdullisesti(mk);
        kp.syoEdullisesti(mk);
        kp.syoEdullisesti(mk);
        mk.lataaRahaa(400);
        kp.syoEdullisesti(mk);
        kp.syoEdullisesti(mk);

        assertEquals(kp.edullisiaLounaitaMyyty(), 5);
    }

    @Test
    public void maukkaastiSyominenJosKoyha() {
        kp.syoMaukkaasti(mk);
        kp.syoMaukkaasti(mk);
        kp.syoMaukkaasti(mk);
        mk.lataaRahaa(200);
        kp.syoMaukkaasti(mk);
        kp.syoMaukkaasti(mk);
        assertEquals(kp.maukkaitaLounaitaMyyty(), 3);
    }

    @Test
    public void kortillaEiRahaaPalautuuFalseMaukkaasti() {
        kp.syoMaukkaasti(mk);
        kp.syoMaukkaasti(mk);
        assertEquals(kp.syoMaukkaasti(mk), false);
    }

    @Test
    public void kortillaRahaaPalautuuTrueMaukkaasti() {
        assertEquals(kp.syoMaukkaasti(mk), true);
    }

    @Test
    public void kortillaEiRahaaPalautuuFalseEdullisesti() {
        kp.syoEdullisesti(mk);
        kp.syoEdullisesti(mk);
        kp.syoEdullisesti(mk);
        kp.syoEdullisesti(mk);
        assertEquals(kp.syoMaukkaasti(mk), false);
    }

    @Test
    public void kortillaRahaaPalautuuTrueEdullisesti() {
        String testi = "" + kp.syoEdullisesti(mk) + kp.edullisiaLounaitaMyyty();
        assertEquals("true1", testi);
    }

    @Test
    public void korttiostoEiMuutaKassaSaldoa() {
        kp.syoEdullisesti(mk);
        kp.syoMaukkaasti(mk);
        assertEquals(100000, kp.kassassaRahaa());
    }

    @Test
    public void kortilleLataaminenToimii1() {
        kp.lataaRahaaKortille(mk, 1000);
        assertEquals(101000, kp.kassassaRahaa());
    }

    @Test
    public void kortilleLataaminenToimii2() {
        kp.lataaRahaaKortille(mk, 1000);
        assertEquals(2000, mk.saldo());
    }

    @Test
    public void sekamelska1() {
        kp.syoEdullisesti(500);
        kp.syoMaukkaasti(10000);
        kp.syoEdullisesti(mk);
        kp.syoMaukkaasti(mk);
        kp.lataaRahaaKortille(mk, 2000);
        System.out.println(mk.saldo());
        kp.syoMaukkaasti(9);
        kp.syoEdullisesti(9);
        Maksukortti keke = new Maksukortti(400);
        kp.syoMaukkaasti(keke);
        kp.lataaRahaaKortille(keke, 240);
        kp.syoEdullisesti(keke);
        kp.syoEdullisesti(keke);
        kp.syoMaukkaasti(keke);

        String pala = "" + kp.edullisiaLounaitaMyyty()
                + kp.maukkaitaLounaitaMyyty()
                + kp.kassassaRahaa();

        assertEquals("3/3/102880", "" + kp.edullisiaLounaitaMyyty()
                + "/" + kp.maukkaitaLounaitaMyyty()
                + "/" + kp.kassassaRahaa());

    }
    
    @Test
    public void theFinalOne1() {
        kp.lataaRahaaKortille(mk, -999);
        assertEquals(mk.saldo(), 1000);      
    }
    @Test
    public void theFinalOne2() {
        kp.lataaRahaaKortille(mk, -999);
        assertEquals(kp.kassassaRahaa(), 100000);      
    }

    /*@Test
    public void sekamelska2(){
        kp.syoEdullisesti(500);
        kp.syoMaukkaasti(10000);
        kp.syoEdullisesti(mk);
        kp.syoMaukkaasti(mk);
        kp.lataaRahaaKortille(mk, 2000);
        System.out.println(mk.saldo());
        kp.syoMaukkaasti(9);
        kp.syoEdullisesti(9);
        Maksukortti keke = new Maksukortti(400);
        kp.syoMaukkaasti(keke);
        kp.lataaRahaaKortille(keke, 240);
        kp.syoEdullisesti(keke);
        kp.syoEdullisesti(keke);
        kp.syoMaukkaasti(keke);
        
        String pala = "" + kp.edullisiaLounaitaMyyty()
                +kp.maukkaitaLounaitaMyyty()
                +kp.kassassaRahaa();
        
        assertEquals(pala, "" + kp.edullisiaLounaitaMyyty()
                +kp.maukkaitaLounaitaMyyty()
                +kp.kassassaRahaa());
        
    }*/
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
