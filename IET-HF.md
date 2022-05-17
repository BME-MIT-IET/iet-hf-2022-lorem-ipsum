

## Első lépések
A házi feladat első lépéseként végig olvastuk a projekt leírását valamint megvizsgáltuk a projekt fájljait és tesztjeit. Mivel ez a projekt sajnos nem rendelkezik UI-al így a példakód kipróbálása mellett döntöttünk.
Mint ahogy a READ.me-ben is szerepel egy egyszerűbb Java Bean osztály segítségével már tesztelhető is lett a program.
Ehhez a Person osztályt használtuk fel és majd késöbb bővítettük a teszteknek megfelelően.

#### A projekt célja
A Pinto egy olyan alkalmazás amely fog egy paraméterül kapott Java Bean osztályt, és a megfelelő property-jei mentén RDF-re alakítja. Ezt ugyan úgy visszafele is megtudja tenni.

## Solar Cloud implementation - Valent Barnabás

- sonarcloud.io weboldal megnyitása, GitHub opció kiválasztása
- A projekt importálása opció kiválasztása
- Megfelelő projekt kiválasztása 
    - BME-MIT-IET
    - csak a kiválasztott repository-k opció alkalmazása
    - saját repository-nk kiválasztása (iet-hf-2022-lorem-ipsum)
        - itt mivel nem volt a hozzáadáshoz jogosultságom, a projekt tulajdonosát kellett megkérnem, hogy hozzáadjam
- Ez után a SonarCloud oldalon az Analysis Method menübe lépve a GitHub Actions opciót választva egy tutorialt végigkövetve adtam hozzá a projekthez
    - Először egy github secretet kellett a projekthez adni
    - Utána a pom.xml fájl kiegészítése a SonarCloud propertijével
    - Végül a build.yaml fájl létrehozása, és a megadott kóddal való feltöltése
- Az analízis módszer beállítása után nem akart tesztelni a program, egy kis kutatás után jöttem rá, hogy a "new code definition" beállítása elmaradt, így, mivel hosszú életű a branch, nem futott le rajta teszt. Itt a new code definíciójának átírása megjavította a problémát, a 30 napnál frissebb kódrészeket fogja tesztelni futtatásokkor
- Mivel a projekt nem tartalmazott hibákat, így nem volt szükséges javítást eszközölni


## Github Action implementálása - Lőrincz Alexandra

- A projekt már eredetileg tartalmazott egy build keretrendszert és teszteket
- Ezeket először lokálisan teszteltem, lefordítottam Gradle-el
- A tesztek és a projekt is sikeresen lefutott
- Ezek után GitHub felületén kezdtem el az Actiont felépíteni
- Beépített funkció segítségével létrehoztam a build.yml file-t (Java with Gradle)
- Ezen belül pedig a megfelelő pontokkal kiegészítettem a workflow-t
- Ilyen volt például a verziókezelés
  - A projekt 2016-ban készült és a gradle verziók sajnos teljesen elmentek egymás mellett, ezt orvosolnom kellett
  - Miután ez megvolt a Java verzión is állítanom kellett, hogy kompatibilis legyen a korábban beállított gradle-el
  - Az újabb verziókkal újabb szintaxisok is jártak, így bele kellett nyúlni a build.gradle-be is ahol a megfelelő kulcsszavakat az új verziónak megfelelőre kellett cserélni (compile, testCompile)
  - Legutolsó lépésként pedig egy elég fájó pontot kellett orvosolni. Http helyett https-t kellett írni a fájlba, és így sikeresen le tudta szedni a megfelelő disztribúciót. (https://github.com/BME-MIT-IET/iet-hf-2022-lorem-ipsum/blob/main/build.gradle#L7)
