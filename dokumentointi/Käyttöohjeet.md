Ohjelma käynnistyy luomalla uusi käyttöliittymä ja käynnistämällä se:
>Kayttoliittyma kayttis = new Kayttoliittyma(lukija);        
>kayttis.kaynnista();

Ohjelmaa voi ajaa neljällä eri tavalla: 
1) Vapaassa tilassa tyhjällä varastolla
2) vapaassa tilassa standardivarastolla
3) varastopeli standardivarastolla tekstipohjaisessa käyttöliittymässä
4) varastopeli standardivarastolla graafisessa käyttöliittymässä

Se, millä tavalla ohjelmaa ajetaan päätetään muutamalla kysymyksellä, jotka ohjelma kysyy heti kun se käynnistetään.
Kun tila on valittu, sitä ei voi enää muttaa, vaan se täytyy käynnistää uudelleen.

Ensimmäiseksi käyttöliittymä kysyy millainen varasto luodaan. Vaihtoehdot ovat:
1: tyhjä varasto, jossa ei ole vielä yhtäkään tuotetta. Tällä valinnalla alkaa välittömästi vapaa tila tekstipohjaisessa 
käyttöliittymässä. 
2: standardivarasto, joka saa sisältönsä ohjelman juurikansioon tallennetusta standardi.txt -tiedostosta. Tämän 
standardivaraston sisältö on seuraava: 
10 ananasta 
10 banaania 
5 currya
0 dijonia
20 etikkaa
11 falafelia
12 greippiä
13 hedelmää
14 inkivääriä
15 juustoa
16 kurkkua. 
Jos käyttäjä loi standardivaraston, ohjelma kysyy käyttäjältä tahtooko hän aloittaa varastopelin, vai aloittaa vapaan tilan 
työskentelyn. Valinnalla 1 alkaa varastopeli ja valinnalla 2 alkaa vapaan tilan työskentely.

## VAPAA TILA

Jos käyttäjä valitsi vapaan tilan, hän saa käyttöönsä seuraavat komennot:
uusi: Luodaan paikka uudelle tuotteelle varastoon. Ohjelma kysyy käyttäjältä tuotteen nimeä ja jos sen nimistä tuotetta ei 
vielä ole varastossa, sellainen lisätään.

lisaa: Lisätään jotakin tuotetta varastoon. Ohjelma kysyy minkä nimistä tuotetta lisätään ja kuinka monta kappaletta. Jos 
annetun nimistä tuotetta ei ole varastossa tai jos annettu määärä on negatiivinen, ei tehdä mitään. Jos tuotetta yritetään 
lisätä niin, että sitä olisi varastossa yli 20kpl, täydennetään tuotteen määrä olemaan 20.

ota: Poistetaan jotakin tuotetta varastosta, jos sitä on tarpeeksi. Ohjelma kysyy käyttäjältä minkä nimistä tuotetta 
poistetaan ja kuinka monta kappaletta sitä poistetaan. Jos annetun nimistä tuotetta ei ole varastossa tai jos annettu määärä 
on negatiivinen, ei tehdä mitään. Jos tuotetta yritetään poistaa enemmän, kuin sitä on varastossa, ei myöskään tehdä mitään

otav: Poistetaan tuotetta varastosta, vaikka sitä ei olisi riittävästi. Jos tuotetta ei ole riittävästi, otetaan kaikki.
tulosta: Tulostetaan koko varaston sisältö tuotteittain muodossa id/nimi/määrä

lopeta: Lopetetaan ohjelman toiminta. Viikon 5 releasessa varaston uutta tilaa ei tallenneta mihinkään.

## VARASTOPELI

Ohjelma kysyy vielä käyttäjältä haluaako hän pelata varastopeliä tekstipohjaisessa- vaiko graafisessa käyttöliittymässä.
Valinnalla 1 käynnistyy tekstipohjainen varastopeli
Valinnalla 2 käynnistyy graafinen varastopeli

## TEKSTIPOHJAINEN VARASTOPELI

Jos käyttäjä valitsi tekstipohjaisen käyttöliittymän, hän saa käyttöönsä seuraavat komennot:

lisaa: Täydennetään varastoon jotakin tuotetta maksimirajaan (20) saakka.

toteuta: Toteutetaan jokin varastoon tehdyistä tilauksista. Ohjelma kysyy ensin toteutettavan tilauksen tilausnumeroa, ja jos 
sen numeroinen tilaus löytyy varastolta ja se on toteuttamatta, ohjelma yrittää toteuttaa tilauksen. Jos tuotteita ei ole
varastossa tarpeeksi, tilausta ei vielä toteuteta, vaan ohjelma kysyy käyttäjältä toteutetaanko tilaus väkisin. Väkisin
toteuttaminen on samanlainen toiminnallisuus, kuin "toteuta", mutta nyt jos jotakin tuotetta ei ole riittävästi, kaikki 
saatavilla olevat kappaleet otetaan ja näinollen tilaus kerätään "puutteellisena". Jos käyttäjä ei tahdo toteuttaa tilausta
väkisin, ohjelman käyttö jatkuu normaalisti.

lopeta: Peli loppuu. Nykyisessä releasessa tietoja edelisestä pelikerrasta ei tallenneta mihinkään.

Peli etenee tasoina ja vaiheina. Jokaisella tasolla on 10 vaihetta ja kun vaihe 10 on suoritettu, sirrytään uudelle tasolle.
Toistaiseksi tasot ja vaiheet  ovat kaikki toiminnaltaan samanlaisia. Jokaisen vaiheen alussa tulostetaan ensin varaston sisältö 
ja sitten varastolle tehdyt tilaukset.

Jokaisen lisäämisen ja toteuttamisen jälkeen ajetaan Tilausgeneraattori, joka saattaa luoda uuden tilauksen käyttäjän
harmiksi.

Jos toteuttamattomia tilauksia on kerralla 6 tai enemmän, pelaaja häviää ja peli päättyy.

## GRAAFINEN VARASTOPELI

Graafisessa varastopelissä käyttäjä saa käsiinsä seuraavanliasen käyttöliittymän:
[kuva](https://raw.githubusercontent.com/Hipsterisiili/ohjelmistotuotanto/master/dokumentointi/graafinen%20varastopeli.png)

Vasemmalla näkyy allekkain kaikki varaston tuotteet, sekä niiden määrät varastossa. Lisäksi jokaisen tuotteen kohdalla on vielä
tilausnappi, josta käyttäjä voi tilata jotakin tuotetta lisää. (tällöin tuotteiden määrä päivittyy automaattisesti olemaan
20, mutta releasessa tämä ei vielä päivity käyttöliittymässä)

Tuotteiden oikealla puolella näky vierekkäin tilauksia, joita varastoon on tehty. Kukin tilaus sitältää allekkain tiedon siitä
montako kutakin tuotetta siihen kuuluu. Viiva tarkoittaa että tuotetta ei tarvita tilauksessa. Tilauksen alalaidassa on tieto siitä
voiko tilauksen toteuttaa jo (valmis) vai puuttuuko jokin tilauksen haluamista tuotteista varastosta (vajaa). Tämän puutteen voi
luonnollisesti korjata tilaamalla lisää tuotetta edellä kuvatulla tavalla. Tilauksen pohjalla näkyy myös nappi "toteuta", jota
painamalla tilaus toteutetaan, eli varastosta otetaan tilauksen vaatimat tuotteet. Jos tilaus eli vajaa, otetaan kaikki saatavilla
olevat tuotteet ja otetaan yksi käyttäjän viidestä oljenkorresta pois.

Valmiin tilauksen toteuttamisesta saa yhtä monta pistettä kuin tilauksessa oli tuotteita.
Vajaan tilauksen toteuttamisesta saa pisteitä puolet siitä, mitä saisi valmiista tilauksesta.
Nykyisessä releasessa peli ei vielä pääty koskaan, joten pelaajan täytyy lopettaa pelaaminen sulkemalla peli-ikkuna.
