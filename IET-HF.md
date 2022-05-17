

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

## Manuális tesztek - Lőrincz Alexandra & Valent Barnabás
  
Manuális tesztelésre két megközelítést használtunk. A korábban említett Person Java Bean osztályt, valamint a már meglévő projekten belüli teszteket.

#### Kiválasztott tesztek és azok leírása:
  
##### testMultipleSubjectsNoIdProvided

A teszt célja: annak tesztelése, hogy létrejönnek-e az RDF entitások, ha nincs id mint megkülönböztető jegy megadva

Elvárt kimenet: RDFMappingException: Multiple subjects found, need to specify the identifier of the object to create
Azaz az elvárt kimenetet az, hogy nem lehet létrehozni RDF-es elemeket megkülönböztető mező nélkül.

##### testWriteMap

A teszt célja: Olyan objektum átadása az RDFMappernek amely egy Map-ben tartalmazza az RDF attribútumokat

Elvárt kimenet: A result tartalmazza a megfelelő subject-et, object-et, tag-eket, és label-eket a kapott attribútum Map szerint

##### testConstructFromEmpty

A teszt célja: Annak tesztelése, hogy az RDFMapper működik-e üres konstruktorra is.

Elvárt kimenet: Ha az RDFMapper üres contruktort kap, csak egy Instance-t adjon vissza üresen, a kapott classhoz igazítva

## Coverage teszt - Lőrincz Alexandra

Az IntelliJ programozói környezet segítségével lehetőségünk volt a már meglévő tesztek segítségével egy lefedettség tesztet is futtatni, így a következő eredményeket kaptuk:

![](coverage_test.png)

Az az a tesztek az osztályok 66%-át, a metódusok 64%-át valamint a sorok 71%-át tesztelik.


## Stresszés limitáció teszt - Benedek Boldizsár
#### Lépések:
- Egyszerűbb Person osztály elkészítése
- Egyszerűbb Car osztály elkészítése
- Egy alap main osztály elkészítése
#### Feladatok:
- Megnézni, hogy különböző bemeneteknél mennyire romlik a performancia ha egyáltalán romlik
- Limitációk tesztelése
#### Eredmény:
- Üres konstuktornál egy üres Graph -et kaptam vissza nem pedig egy nullt, ez pedig kicsit félrevezető lehet
- Performanica beli romlás az egy egy új apraméterenként kb. 10% volt, 1 millió iterációnál az 1 paraméteres teszt 3000ms -ig futott, 2 -nél már 3300ms
- Performancia beli romlás egymásba ágyazott objektumoknál viszont már jelentősebb, 3500ms- ről 5600ms -re ugrott, egy egyszerűbb Car osztály hozzáadásától is
   - Több egymásba ágyazott objektumnál ez hamar összeadódhat!
