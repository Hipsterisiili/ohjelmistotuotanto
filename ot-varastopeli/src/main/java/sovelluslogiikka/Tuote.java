package sovelluslogiikka;

public class Tuote {
    
    private int id;
    private String nimi;
    private Varasto varasto;
    
    //Myöhemmin: tuote saa aina pienimmän vapaan id:n
    //Huom. kun tuotetyyppi on lisätty varastoon, sitä ei voida enää poistaa sieltä
    //...Varastossa on edelleen maininta maidosta, vaikka maito olisi loppu
    public Tuote(Varasto varasto, String nimi) {
        if (varasto.getTuotteet().size() > varasto.getMaksimikoko()) {
            System.out.println("Varasto on täynnä");
            return;
        }
        this.varasto = varasto;
        this.id = varasto.getTuotteet().size();
        this.nimi = nimi;
        varasto.lisaaTuote(this, 0);
    }

    public int getId() {
        return id;
    }

    public String getNimi() {
        return nimi;
    }
}
