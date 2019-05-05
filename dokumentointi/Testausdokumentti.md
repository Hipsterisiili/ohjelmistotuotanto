# Testausdokumentti

Ohjelman testaamiseen on luotu joukko tarkoituksenmukaisia JUnit-testejä.

Ohjelman käyttöjärjestelmää ei ole testattu, sillä se on melko haastavaa eikä vastaa annettua tehtävänantoa. Sen sijaan sovelluslogiikkaa 
testataan ohjelmassa testikattavuudela 75%. Sovelluslogiikasta testaamatta jää ainoastaan ne toiminnallisuudet, jotka joko
*Käsittelevät tekstitiedostoja, joita ei haluta testatessa käsiteltävän.
*Sisältävät satunnaislukuja, joten niiden testaaminen ei ole kovin mielekästä.

### Jacoco-testikattavuus sovelluslogiikasta:
<img src="https://raw.githubusercontent.com/Hipsterisiili/ohjelmistotuotanto/master/dokumentointi/Screenshot%20from%202019-05-05%2023-15-23.png" width="800">

Testaamatta jäi yllämainitun kaltaisten rivien lisäksi muutamia pelkkiä tulostuksia sisältäviä haaroja, joiden testaus ei ole kovinkaan mielekästä.
