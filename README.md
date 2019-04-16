# *VARASTOPELI*

Sovellus tarjoaa mahdollisuuden erään elintarvikevaraston tuotteiden tarkasteluun ja tilaamiseen, sekä tilausten toteuttamiseen. Tarkempi kuvaus linkin "dokumentointi" takana.

[Dokumentointi](https://github.com/Hipsterisiili/ohjelmistotuotanto/blob/master/dokumentointi/dokumentointi1.txt) (sis vaativuusmäärittely ja arkkitehtuurikuvaus)

[Työaikakirjanpito](https://github.com/Hipsterisiili/ohjelmistotuotanto/blob/master/dokumentointi/tyoaikakirjanpito.txt)

[Arkkitehtuuri](https://github.com/Hipsterisiili/ohjelmistotuotanto/blob/master/dokumentointi/arkkitehtuuri.md)

## *Releaset*

[Ohjelma (viikko 4)](https://github.com/Hipsterisiili/ohjelmistotuotanto/tree/master/ot-varastopeli)

## *Käyttöohjeet*

[Varaston käsitteleminen tekstipohjaisessa käyttöliittymässä](https://github.com/Hipsterisiili/ohjelmistotuotanto/blob/master/dokumentointi/K%C3%A4ytt%C3%B6ohjeet.txt)

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

Checkstyle-virheet tarkastellaan komennolla:
 >mvn jxr:jxr checkstyle:checkstyle
 
JavaDocia voi tarkastella avaamalla selaimella tiedosto target/site/checkstyle.html

