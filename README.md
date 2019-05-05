# *VARASTOPELI*

Ohjelmistotekniikka kevät 2019
Varastosimulaatio ja varastopeli yhdessä sovelluksessa

[Määrittelydokumentti](https://github.com/Hipsterisiili/ohjelmistotuotanto/blob/master/dokumentointi/maarittelydokumentti.txt)

[Työaikakirjanpito](https://github.com/Hipsterisiili/ohjelmistotuotanto/blob/master/dokumentointi/tyoaikakirjanpito.txt)

[Arkkitehtuuri](https://github.com/Hipsterisiili/ohjelmistotuotanto/blob/master/dokumentointi/Arkkitehtuurikuvaus.md)

[Käyttöohjeet](https://github.com/Hipsterisiili/ohjelmistotuotanto/blob/master/dokumentointi/K%C3%A4ytt%C3%B6ohjeet.txt)

## *Releaset*

[viikko 5](https://github.com/Hipsterisiili/ohjelmistotuotanto/releases/tag/v.5.1) (huom. vain vapaa tila toimii jar-tiedostossa)

[viikko 6](https://github.com/Hipsterisiili/ohjelmistotuotanto/releases/tag/6.1)

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
 
Checkstyleä voi tarkastella avaamalla selaimella tiedosto target/site/checkstyle.html

