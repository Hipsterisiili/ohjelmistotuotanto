
package varastopeli;

import java.util.ArrayList;

public class Varasto {
    
    private ArrayList<Tuote> tuotteet;
    private ArrayList<Integer> maarat;
    private ArrayList<Tilaus> tilaukset;
    private int maksimikoko;

    
    
    public Varasto(){
        System.out.println("Luodaan uusi varasto");
        this.tuotteet = new ArrayList<>();
        this.maarat = new ArrayList<>();
        this.tilaukset = new ArrayList();
        this.maksimikoko = 1000;
        
        for(int i = 0 ; i < 10 ; i++){
            
        }
    }
    
    public void lisaaTuote(Tuote tuote, int maara) {
        
        System.out.println("Lisätään varastoon tuote " + tuote.getNimi() 
                + " (id: " + tuote.getId() + ") " + maara +" kappaletta" );
        
        if(this.tuotteet.contains(tuote)){
            int temp = this.tuotteet.indexOf(tuote);
            int nyky = this.maarat.get(temp);
            maarat.set(temp, nyky+maara);
            
            if(maarat.get(temp) > 20){
                maarat.set(temp, 20);
            }
        } else {
            tuotteet.add(tuote);
            maarat.add(maara);
        }
    }
    
    public ArrayList<Tuote> getTuotteet() {
        return tuotteet;
    }

    public void setTuotteet(ArrayList<Tuote> tuotteet) {
        this.tuotteet = tuotteet;
    }

    public ArrayList<Integer> getMaarat() {
        return maarat;
    }

    public ArrayList<Tilaus> getTilaukset() {
        return tilaukset;
    }

    public int getMaksimikoko() {
        return maksimikoko;
    }
    
    //Palauttaa tuotteet järjestyksessä muodossa id/nimi/maara
    //Tehdään myöhemmin sellaiseksi, että järjestää tuotteet automaattisesti id:n mukaan.
    @Override
    public String toString(){
        
        System.out.println("Tulostetaan varaston tuotteet");
        
        String palautus = "id/nimi/maara \n";
        String temp = "";
        int num = 0;
        
        for(Tuote pepe : tuotteet){
            if(pepe == null){
                System.out.println("tuote ei ole olemassa");
            }
            temp = pepe.getId() + "/" + pepe.getNimi();
            palautus += temp + "/";
            num = tuotteet.indexOf(pepe);
            palautus += maarat.get(num) +"\n";
        }
        
        return palautus;
    }

    
    
    
}
