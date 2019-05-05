package juuri.sovelluslogiikka;

import juuri.ui.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HighScoreTallennin {

    /**
     * Metodi tallentaa projektin juurikansiossa olevaan tiedostoon
     * highscore.txt tiedon viimeisimmän pelikerran pisteistä sekä pelaajan
     * nimen. Jos tiedostoa highscore.txt ei ole olemassa, ohjelmaluo sellaisen.
     *
     * @param nimi pelaajan nimi
     * @param pisteet pelaajan pisteet
     *
     * @return true, jos tallentaminen onnistui.
     */
    public boolean tallennaTulos(String nimi, int pisteet) throws IOException {

        FileWriter kirjoittaja = new FileWriter(new File("highscore.txt"), true);
        //HUOM. NIMI EI SAA SISÄLTÄÄ MERKKIÄ ; KORJAA TÄMÄ
        kirjoittaja.write("\n" + pisteet + ";" + nimi);
        kirjoittaja.flush();
        kirjoittaja.close();

        return true;
    }

    /**
     * Metodi selvittää projektin juurikansiossa olevasta tiedostosta tiedon
     * kolmesta parhaasta varastopelissä saadusta tuloksesta ja palauttaa ne
     * merkkijonoja sisältävänä listana. Jos metodi havaitsee, että tuloksia on
     * tallennettu alle kolme, se tallentaa kolme placeholder -tulosta, jotka
     * ovat 100, 200 ja 300 pistettä. Kaikkiin pistemääriin liittyy pelaajanimi
     * "placeholder"
     *
     * @return lista kolmesta parhaasta tuloksesta merkkijonoina muodossa
     * pisteet;nimi
     */
    public String[] top3() throws IOException {
        String[] taulukko = new String[3];
        ArrayList<Pelaaja> pelaajat = new ArrayList<>();

        try (Scanner tiedostonLukija = new Scanner(new File("highscore.txt"))) {
            while (tiedostonLukija.hasNextLine()) {
                String rivi = tiedostonLukija.nextLine();
                if (rivi.equals("") || rivi.equals("\n")) {
                    continue;
                }
                String[] taul = rivi.split(";");
                pelaajat.add(new Pelaaja(Integer.parseInt(taul[0]), taul[1]));
            }
        } catch (Exception e) {
            //System.out.println("Virhe: " + e.getMessage());
        }
        return taulukonMuodostus(pelaajat, taulukko);
    }

    public String[] taulukonMuodostus(ArrayList<Pelaaja> pelaajat, String[] taulukko) throws IOException {
        int summa = 0;
        for (Pelaaja pepe : pelaajat) {
            if (pepe != null) {
                summa++;
            }
        }
        if (summa < 3) {
            pelaajat.add(new Pelaaja(300, "placeholder"));
            tallennaTulos("placeholder", 100);
            pelaajat.add(new Pelaaja(200, "placeholder"));
            tallennaTulos("placeholder", 200);
            pelaajat.add(new Pelaaja(100, "placeholder"));
            tallennaTulos("placeholder", 300);
        }

        Collections.sort(pelaajat);

        for (int i = 0; i < 3; i++) {
            taulukko[i] = pelaajat.get(i).tulosta();
        }
        return taulukko;
    }
}