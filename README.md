# *VARASTOPELI*

Sovellus tarjoaa mahdollisuuden erään elintarvikevaraston tuotteiden tarkasteluun ja tilaamiseen, sekä tilausten toteuttamiseen. Tarkempi kuvaus linkin "dokumentointi" takana.

[Dokumentointi](https://github.com/Hipsterisiili/ohjelmistotuotanto/blob/master/dokumentointi/dokumentointi1.txt) (sis vaativuusmäärittely ja arkkitehtuurikuvaus)

[Työaikakirjanpito](https://github.com/Hipsterisiili/ohjelmistotuotanto/blob/master/dokumentointi/tyoaikakirjanpito.txt)

## *Releaset*

[Ohjelma (viikko 3)](https://github.com/Hipsterisiili/ohjelmistotuotanto/tree/master/ot-varastopeli)

## *Komentorivitoiminnot*

Ohjelmaan sisäänrakennettujen yksikkötestien ajaminen komennolla:
>mvn test

testikattavuusraportti hakemistoon target luodaan komennolla:
>mvn jacoco:report

Suoritettavan jarin generointi komennolla: 
>mvn package
generoi hakemistoon target suoritettavan jar-tiedoston OtmTodoApp-1.0-SNAPSHOT.jar

JavaDoc generoidaan komennolla:
>mvn javadoc:javadoc
JavaDocia voi tarkastella avaamalla selaimella tiedosto target/site/apidocs/index.html

## *Käyttöohjeet*
