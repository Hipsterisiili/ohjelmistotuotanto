package ui;

import java.util.Random;
import sovelluslogiikka.Varasto;
import sovelluslogiikka.Tuote;
import sovelluslogiikka.Tilaus;

public class Tilausgeneraattori {
    
    private Varasto a;
    private Random rand;
    
    public Tilausgeneraattori(Varasto varasto){
        this.a = varasto;
        this.rand = new Random();
    }
    
    public Tilaus aja(){
        int i = rand.nextInt(100);
        if(i > 50){
            Tilaus t = new Tilaus(a);
            return t;
        } else {
            return null;
        }
    }
}
