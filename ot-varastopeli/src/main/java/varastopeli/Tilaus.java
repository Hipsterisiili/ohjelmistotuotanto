package varastopeli;

import java.util.ArrayList;


public class Tilaus {
    
    private int[] maarat;

    
    private Varasto varasto;
    private boolean toteutettu;
    
    public Tilaus(Varasto a){
        this.varasto = a;
        this.toteutettu = false;
        this.maarat = new int[a.getTuotteet().size()];
        for(int i = 0; i < a.getTuotteet().size() ; i++){
            this.maarat[i] = 0;
        }
    }
    
    //tee myöhemmin: jos tilaus liian suuri, palauttaa vain false
    public void LisaaTuote(String nimi, int maara){
        
        for(int i = 0 ; i < varasto.getTuotteet().size() ; i++){
            // jos varastossa on tuon niminen tuote
            if(varasto.getTuotteet().get(i).getNimi().equals(nimi)){
                this.maarat[i] = this.maarat[i] + maara;
                if(this.maarat[i] > 20){
                    this.maarat[i] = 20;
                }
                break;
            }
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
    
    public int[] getMaarat() {
        return maarat;
    }

    public boolean isToteutettu() {
        return toteutettu;
    }
}
