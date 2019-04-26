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

Sekvenssikaavio tapahtumassa, jossa:

1: Käyttöliittymä luodaan

2: Käyttöliittymä käynnistetään

3: Valitaan standardivarasto ja aloitetaan varastopeli

4: Täydennetän tuotetta banaani

5: Tilausgeneraattori luo uuden tilauksen

6: Käyttöliittymän while-loop päättyy

<img src="https://github.com/Hipsterisiili/ohjelmistotuotanto/blob/master/dokumentointi/WhatsApp%20Image%202019-04-16%20at%2021.36.34.jpeg" width="800">

