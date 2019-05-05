# Ohjelmistotekniikka harjoitustyö, k2019 Rasmus Marttila 
## Varastopelin määrittelydokumentti

## Perusidea
Kurssilla rakennan ohjelman, joka simuloi erästä elintarvikkeita sisältävää varastoa. Varastoa voidaan joko työstää vapaassa tilassa tai sillä voidaan pelata eräänlaista varastopeliä. Ohjelmaan on otettu vaikutteita työpaikaltani varaston tilauksien kerääjänä ja
varastopelin idea on kypsynyt pitkinä työpäivinä keräämisen lomassa.

## Käyttäjäroolit
Ohjelmassa voi toimia kahdessa erilaisessa roolissa, jotka ovat tosin kaikki täysin toisistaan riippumattomia. Kun jonkin roolin on
kertaalleen valinnut, sen voi vaihtaa vain käynnistämällä ohjelman uudelleen.
1) Vapaa tila, jossa varastoon voi vapaasti tuoda uusia tuotteita ja poistaa niitä. Tässä tilassa voi työstää täysin tyhjää varastoa
tai työstää ohjelmassa valmiiksi olevaa standardivarastoa.
2) Varastopeli, jossa pelaaja työstää varastoa ja yrittää toteuttaa tilauksia mahdollisimman tehokkaasti. Varastopeliä voi pelata
tekstikäyttöliittymässä tai graafisessa käyttöliittymässä.

## Ohjelman käynnistäminen:

Kun ohjelma käynnistetään, käyttäjä kulkee seuraavanlaista polkua tekstikäyttöliittymässä käyttäen komentoja 1 ja 2

<img src="https://raw.githubusercontent.com/Hipsterisiili/ohjelmistotuotanto/master/dokumentointi/Untitled%20Diagram(5).png" width="500">

### Vapaa tila, tyhjä varasto (komennot 1)
Käyttäjä voi luoda tekstikäyttöliittymän komentojen avulla uusia tuotteita, tilata tuotteita sekä poistaa tuotteita.

### Vapaa tila, stadardivarasto (komennot 2,1)
Samanlainen kuin vapaan tilan tyhjä varasto, mutta varaston sisältö on ennalta suunnitellun standardivaraston mukainen.

### Varastopeli, tekstikäyttöliittymä (komennot 2,2,1)
Pelaajan tulee järjestellä varastoaan samanlaisilla komennoilla kuin vapaassa tilassa, mutta lisättynä on myös komennto "toteuta". 
Näillä komennoilla toteutetaan tilauksia, joita varastoon tulee tasaisin väliajoin. Pelaaja häviää, kun hänellä on yli 5 toteuttamatonta 
tilausta. 

### Varastopeli, graafinen käyttöliittymä (komennot 2,2,2)
Samanlainen kuin varastopeli tekstikäyttöliittymässä, mutta nyt tilannekuva ja komennot esitetään javaFX-kirjaston avulla rakennetussa 
käyttöliittymässä. Kunkin tuotteen tilaamiseksi on määritelty nappi, kuten myös kunkin tilauksen toteuttamiseksi. Lisäksi pelikentällä 
näkyy jatkuvasti graafinen kuva varaston ja sen tilauksien sisällöistä.


## Sovelluslogiikka

### Varasto
Varasto sisältää tuotteita, ja tietyn määrän kutakin tuotetta, esim 10 banaania, 2 kurkkua jne.
Varasto sisältää myös lukuisia tilauksia.

### Tuote
Tuote sisältää tiedon nimestään sekä id:stään

### Tilaus
Tilaus kuuluu jollekin varastolle ja sisältää tietyn määrän joitakin tuotteita esim 3 greippiä, 5 ananasta.

### Tilausgeneraattori
Tilausgeneraattori kuuluu jollekin varastolle ja luo siihen automaattisesti tilauksia satunaisin väliajoin. Tilausgeneraattoria 
käytetään ainoastaan varastopelissä.

### HighScoreTallennin
HighScoreTallennin tallettaa tuloksia ja nimiä sekä selvittää talletetuista tuloksista top-listoja
