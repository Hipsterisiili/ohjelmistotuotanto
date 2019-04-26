package juuri.sovelluslogiikka;

public class Tuote {
    
    private int id;
    private String nimi;
    private Varasto varasto;
    
    /**
     * Konstruktori, joka luo uuden tuotteen ja lisää sen johonkin varastoon
     * Jos varastossa on tuotteita sen maksimikoon verran, ei lisätä tätä tuotetta
     * varastoon, eikä anneta sille arvoja.
     *
     * @param varasto Varasto, johon tuote sijoitetaan
     * @param nimi Uuden tuotteen nimi
     */
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
