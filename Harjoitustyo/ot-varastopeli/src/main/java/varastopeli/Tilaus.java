package varastopeli;

import java.util.ArrayList;


public class Tilaus {
    
    private int[] maarat;
    private Varasto varasto;
    
    public Tilaus(Varasto a){
        this.maarat = new int[a.getMaksimikoko()];
        this.varasto = a;
    }
    
    //tee myöhemmin: jos tilaus liian suuri, palauttaa vain false
    public void LisaaTuote(Tuote tuote, int maara){
        
        System.out.println("Lisätään tilaukseen tuote " + tuote.getNimi() 
                + " (id: " + tuote.getId() + ") " + maara +" kappaletta" );
        
        if(this.varasto.getTuotteet().contains(tuote)){
            int tuotteenIndeksi = this.varasto.getTuotteet().indexOf(tuote);
            int toinen = this.varasto.getTuotteet().indexOf(tuotteenIndeksi);
            this.maarat[tuotteenIndeksi]+= maara;
            
            if(maarat[tuotteenIndeksi] > 20){
                System.out.println("Tuotetta voi olla tilauksessa korkeintaan 20 kappaletta (nyt " 
                        + maarat[tuotteenIndeksi] + ")");
                System.out.println("Tuotetta tilauksessa nyt 20 kappaletta");
                this.maarat[tuotteenIndeksi] = 20;
            }
            
        } else {
            System.out.println("Tuotetta ei ole varastossa");
            System.out.println("Tuotetta ei lisätty tilaukseen");
        }
    }
    
    public void poistaTuote(Tuote tuote, int maara){
        
        System.out.println("Poistetaan tilauksesta tuote " + tuote.getNimi() 
                + " (id: " + tuote.getId() + ") poistetaan " + maara +" kappaletta" );
        
        int poistettavanId = this.varasto.getTuotteet().indexOf(tuote);
        
        maarat[poistettavanId]-= maara;
        if(maarat[poistettavanId] < 0){
            System.out.println("Yritettiin poistaa tuotteita enemmän kuin on mahdollista");
            System.out.println("Poistettiin kaikki " + (maara  + maarat[poistettavanId]) + " jäljelläolevaa");
            maarat[poistettavanId] = 0;
        }
        
    }
    
    @Override
    public String toString(){
        //myöhemmin: tilaukselle lisätään yksilöivä numero, joka tulostetaan
        System.out.println("Tulostetaan tilauksen tuotteet");
        
        String palautus = "id/nimi/maara \n";
        Tuote pepe;
        int pepenMaara;
        
        for(int i = 0; i < this.maarat.length ; i++){
            
            if(this.maarat[i] <= 0){
                continue;
            } else {
                pepe = this.varasto.getTuotteet().get(i);   
                palautus+= pepe.getId() + "/" + pepe.getNimi() +"/"
                        +maarat[i] +"\n";
            }
            
        }
        
        return palautus;
    }
}
