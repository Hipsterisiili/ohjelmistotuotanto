Ohjelman pakkausrakenne:


<img src="https://raw.githubusercontent.com/Hipsterisiili/ohjelmistotuotanto/master/dokumentointi/Untitled%20Diagram(4).png" width="500">

main sisältää ohjelman main-luokan, joka käynnistää käyttöjärjestelmän.
ui sisältää käyttöliittymät (graafisen ja tekstipohjaisen) sekä yksinomaan niiden käyttämän tilausgeneraattorin, joka luo uusia
tilauksia varastoon varastopelissä pelaajan saavuttaman tason ja vaiheen mukaan.
sovelluslogiikka sisältää luokat Tuote, Varasto sekä Tilaus. Ne sisältävät kaikki ohjelman taustalla olevat olennaiset 
tietorakenteet sekä niiden käsittelemiseen liittyvät metodit.

<img src="https://raw.githubusercontent.com/Hipsterisiili/ohjelmistotuotanto/master/dokumentointi/LuokatMetoditToiminnot.png" width="800">

HUOM. Graafinenui.java puuttuu ylläolevista kuvista. Se sisältyy laatikkoon Käyttöliittymä, kuten myös Tekstiui.java sekä
Varastopeli.java.

Graafinenui sisältää yhden HighScoreTallentimen. Se kutsuu HighScoreTallentimen metodeja taulukonMuodostus(ArrayList<Pelaaja>,
String[] taulukko), top3() sekä TaulukonMuodostus(ArrayList<Pelaaja>, String[])
  
Graafinenui sisältää yhden Tilausgeneraattorin, samoin Tekstiui sisältää yhden Tilausgeneraattorin. Ne kutsuvat Tilausgeneraattorin
metodia aja(int, int). Tällöin Tilausgeneraattori luo uude tilauksen (jos parametrit ovat sopivat). Tämä tilaus lisää itsensä 
automaattisesti varastoon.

## Varastopeli.java

Varastopeli.java on ohjelman main-luokka. Sen tehtävä on yksinkertaisesti käynnistää käyttöjärjestelmä.

## Tuote.java

Tuotteet kuvaavat varastossa olevia esineitä. Kullakin tuotteella on yksilöivä tunniste id sekä nimi

## Tilaus.java

Tilaus sisältää tlistan senhetkisistä varaston sisältämistä tuotteista sekä tiedon siitä kuinka monta niistä kutakin tarvitaan.
Tilauksessa voi olla kerralla korkeintaan 20 kappaletta kutakin tuotetta. Kukin tilaus sisältää myös tiedon siitä onko se 
jo toteutettu, vai onko se vain muisto jo totetetusta tilauksesta.

## Varasto.java

Varasto on pelaajan työympäristö. Ohjelmassa on käytössä yksi varasto kerrallaan. Varasto sisältää kutakin siihen lisättyä tuotetta
nollasta kahteenkymmentä kappaletta sekä tilauksia n kappaletta. 

Varastossa voi toteuttaa tilauksia (eli ottaa varastosta tilauksen vaatimat tuotteet). Lisäksi varastoon voi lisätä jotakin tuotetta
(esimerkiksi jos tilaus vaatii 10 banaania, mutta varastossa on vain 7 banaania tällä hetkellä.) Yksi lisääminen täydentää tuotetta
varastoon, kunnes tuotteita on varastossa 20 kappaletta.

Varastoon voi myös lisätä uusia tuotteita tai uusia tilauksia (vapaassa tilassa ei voi, varastopelissä tilausgeneraattori lisää 
tilaukset)

## Tilausgeneraattori.java

Tilausgeneraattoria kutsutaan varastopelissä aina kun jokin toiminto on suoritettu. Se luo noin joka toisessa vaiheessa asiaankuuluvaan
varastoon uuden tilauksen. Tilauksen sisällön se arpoo aina kahdstakymmenestä erilaisesta vaihtoehdosta. Jokaisen tason (paitsi
ensimäisen) ensimmäisessä vaiheessa luodaan eräänlainen "final boss" -tilaus eli vaikeampi peliä rytmittävä tilaus.

## HighScoreTallennin.java

HighScoreTallentimen tehtävä on käsitellä projektin juurikansioon tallennettua highscore.txt -tekstitiedostoa ja siihen tallennettavia
tietoja pelatuista peleistä. (pelaajien pistemäärät ja nimet). Se tallentaa pelaajien tuloksia sekä selvittää tarvittaessa kolme
korkeinta tähänastista tulosta.

## Tekstiui.java

Tämä käyttöliittymä on tekstipohjainen. Jokainen ohjelman suoritus alkaa käynnistämällä TekstiUi ja jos käyttäjä niin haluaa, 
Tekstiui käynnistääkin Graafinenui:n 

Tekstiui toteuttaa käyttäjän tahdon mukaisesti joko varastopeliä tai vapaata tilaa.

Käyttäjä voi ohjata varastoa tekstikomennoilla, kuten lisaa, uusi, tulosta, ota, lopeta... Jos käynnissä on varastopeli, pelin 
hengen mukaisesti kukin käyttäjän tekemä liike aktivoi tilausgeneraattorin ja varastoon saattaa syntyä uusia tilauksia.

## Graafinenui.java

Tämä käyttölittymä on graafinen. Se käynnistetään Tekstiui:sta ja tämän jälkee ohjelman "pyöritysvastuu" siirtyy Graafinenui:lle

Graafinenui:ssa voi toteuttaa ainoastaan varastopeliä, ei lainkaan vapaata tilaa.

Käyttäjä ohjaa varastoa käyttöliittymän "tilaus"- ja "tilauksen toteutus" -nappien avulla. Varastopelin hengen mukaisesti kukin
käyttäjän tekemä liike aktivoi tilausgeneraattorin ja varastoon saattaa syntyä uusia tilauksia.

## Käyttöliittymän haarautuminen


<img src="https://raw.githubusercontent.com/Hipsterisiili/ohjelmistotuotanto/master/dokumentointi/Untitled%20Diagram(5).png" width="800">


## Sekvenssikaavio

Seuraava sekvenssikaavio kuvaa tapahtumaa, jossa:

1: Käyttöliittymä luodaan

2: Käyttöliittymä käynnistetään

3: Valitaan standardivarasto ja aloitetaan varastopeli

4: Täydennetän tuotetta banaani

5: Tilausgeneraattori luo uuden tilauksen

6: Käyttöliittymän while-loop päättyy


<img src="https://github.com/Hipsterisiili/ohjelmistotuotanto/blob/master/dokumentointi/WhatsApp%20Image%202019-04-16%20at%2021.36.34.jpeg" width="800">

## Ohjelman toteutuksen heikkoudet

Ohjelmassa on muutamia liian monimutkaisia luokkia, jotka toteuttavat liikaa toiminnallisuuksia. Erityisesti tekstiui toteuttaa
sekä tekstipohjaisen varastopelin että vapaan tilan ajamista. Samoin luokalla Varasto on mielestäni liikaa metodeja.

Varaston luokka lisaaTuote(Tuote, int) toteuttaa kaksi eri toiminnallisuutta: Uuden tuotteen luomisen sekä vanhan tuotteen 
lisäämisen. Tämä on hieman kömpelö ratkaisu, mutta tarkoituksenmukainen, sillä tällä tavalla vältytään siltä, että käyttäjä
tavoittelisi tuotetta, jota ei vielä ole varastossa.

Ratkaisuni sisällyttää ohjelmaan monta eri tapaa työstää varastoa ei ole välttämättä täysin tarkoituksenmukainen. Tämä on
lähinnä sivuvaikutus siitä, että olen keksinyt uusia käyttötarkoituksia rakentaessani ohjelmaa. Tämä aiheuttaa varmasti
uusissa käyttäjissä aluksi sekaannusta, sillä ohjelma käynnistetään ensin tekstipohjaisena ja tämän jälkeen (komennoilla
2, 1, 2) saatetaan siirtyä graafiseen käyttöliittymään. Ohjelman "aloitusruutu" on mielestäni sen heikoin osa.

Kun ohjelman suoritustavan on kerran valinnut, sitä ei voi enää muuttaa ennen kuin sen käynnistää uudelleen.
