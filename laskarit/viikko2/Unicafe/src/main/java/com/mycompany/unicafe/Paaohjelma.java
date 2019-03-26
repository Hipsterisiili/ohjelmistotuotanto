package com.mycompany.unicafe;

public class Paaohjelma {

    public static void main(String[] args) {
        Kassapaate unicafeExactum = new Kassapaate();
        Maksukortti kortti = new Maksukortti(10000);
        
        unicafeExactum.syoEdullisesti(kortti);
        
        System.out.println( unicafeExactum.edullisiaLounaitaMyyty() );
        System.out.println(kortti);
        
        
        System.out.println("UUTTAPASKAA");
        
        Kassapaate kp = new Kassapaate();
        Maksukortti mk = new Maksukortti(1000);
        
        kp.syoEdullisesti(500);
        kp.syoMaukkaasti(10000);
        
        System.out.println(mk.saldo());
        
        kp.syoEdullisesti(mk);
        kp.syoMaukkaasti(mk);
        
        System.out.println(mk.saldo());
        
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
        
        System.out.println(pala);
    }
}
