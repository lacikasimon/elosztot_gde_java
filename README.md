# Sportautó Nyilvántartó Alkalmazás

## Projektről

Ez a projekt az Elosztott Alkalmazások tantárgy keretében készült. Az alkalmazás egy komplex sportautó nyilvántartó rendszer, amely lehetővé teszi különböző sportautók adatainak kezelését, elemzését és megjelenítését. A program segítségével könnyen áttekinthetők a különböző sportautók jellemzői, összehasonlíthatók teljesítmény, ár és egyéb paraméterek alapján.

### Kiemelt Funkciók

#### 1. JSON Fájlkezelés
- Adatok perzisztens tárolása JSON formátumban
- Automatikus fájl beolvasás az alkalmazás indításakor
- JSON Simple library használata a hatékony feldolgozáshoz
- Strukturált adattárolás a következő mezőkkel:
  - Azonosító (id)
  - Márka (marka)
  - Modell (modell)
  - Teljesítmény (loero)
  - Végsebesség (vegsebesseg)
  - Ár (ar)

#### 2. Kivételkezelés
- Részletes hibakezelési mechanizmusok
- Felhasználóbarát hibaüzenetek
- A következő kivételes esetek kezelése:
  - Fájl nem található
  - Érvénytelen JSON formátum
  - Hiányzó vagy hibás adatmezők
  - Típuskonverziós hibák
  - Null pointer kivételek
- Stack trace naplózás fejlesztői módban

## Részletes Funkcionalitás

### Adatmegjelenítés
- Összes sportautó listázása táblázatos formában
- Részletes adatok megjelenítése minden autóról:
  - Márka és modell
  - Teljesítmény (lóerőben)
  - Végsebesség (km/h)
  - Ár (EUR)

### Keresési és Szűrési Funkciók
1. **Teljesítmény alapú funkciók**
   - Legnagyobb teljesítményű autó kiválasztása
   - Teljesítmény szerinti csökkenő sorrendbe rendezés
   - Minimum teljesítmény alapján történő szűrés
   
2. **Sebesség alapú funkciók**
   - Legnagyobb végsebességű autó meghatározása
   - Átlagos végsebesség kiszámítása
   - Sebesség szerinti rendezés lehetősége

3. **Ár alapú funkciók**
   - Átlagár kiszámítása
   - Legdrágább autó kiválasztása
   - Legolcsóbb autó meghatározása
   - Ár szerinti növekvő sorrendbe rendezés

4. **Márka alapú elemzések**
   - Legtöbb modellel rendelkező márka meghatározása
   - Márkánkénti statisztikák
   - Márka szerinti csoportosítás

## Technológiai Részletek

### Architektúra
Az alkalmazás háromrétegű (MVC) architektúrát követ:

#### Model réteg
- **`Sportkocsi` osztály**
  - Adatmodell megvalósítása
  - Getter és setter metódusok
  - toString metódus az adatok formázott megjelenítéséhez
  - Belső adatvalidáció

#### View réteg
- **`SportkocsiGUI` osztály**
  - Swing alapú grafikus felület
  - Reszponzív elrendezés
  - Felhasználóbarát vezérlőelemek
  - Dinamikus adatmegjelenítés
  - Hibaüzenetek kezelése

#### Controller réteg
- **`SportkocsiService` osztály**
  - Üzleti logika megvalósítása
  - Adatfeldolgozó műveletek
  - Stream API használata a hatékony adatkezeléshez
  - Hibakezelési mechanizmusok

### Adatkezelés
- **`SportkocsiReader` osztály**
  - JSON fájl beolvasása és feldolgozása
  - Kivételkezelés
  - Adatkonverzió és validáció

### Felhasznált Technológiák

1. **Java Core Technológiák**
   - Java 11 nyelvi elemek
   - Stream API a hatékony adatfeldolgozáshoz
   - Lambda kifejezések
   - Funkcionális interfészek
   - Try-with-resources a biztonságos erőforrás-kezeléshez
   - Többszintű kivételkezelés (Exception hierarchy)

2. **GUI Fejlesztés**
   - Java Swing komponensek
   - Eseménykezelés (ActionListener)
   - Layout menedzserek
   - JFrame, JPanel, JButton, JTextArea komponensek
   - Felhasználóbarát hibaüzenetek megjelenítése

3. **Adatkezelés és Perzisztencia**
   - JSON Simple library (com.googlecode.json-simple)
   - Fájlkezelés (InputStreamReader, ResourceAsStream)
   - JSON parsing és formázás
   - Típuskonverziók kezelése
   - Null-biztos adatkezelés
   - Hibatűrő fájlbeolvasás

4. **Build és Projekt Menedzsment**
   - Maven projekt struktúra
   - Függőségek kezelése
   - Build életciklus
   - Plugin konfiguráció
   - Resource fájlok kezelése

## Telepítési és Futtatási Útmutató

### Rendszerkövetelmények
- Java Development Kit (JDK) 11 vagy újabb
- Apache Maven 3.6.x vagy újabb
- Minimum 2GB RAM
- 100MB szabad tárhely

### Fejlesztői Környezet Beállítása

1. **JDK Telepítése**
   ```bash
   # Java verzió ellenőrzése
   java -version
   
   # JAVA_HOME környezeti változó beállítása
   set JAVA_HOME=C:\Program Files\Java\jdk-11
   ```

2. **Maven Telepítése**
   ```bash
   # Maven verzió ellenőrzése
   mvn -version
   
   # MAVEN_HOME környezeti változó beállítása
   set MAVEN_HOME=C:\Program Files\Apache\maven
   ```

### Projekt Telepítése

1. **Forráskód Letöltése**
   ```bash
   # Repository klónozása
   git clone <repository-url>
   
   # Projekt könyvtárába lépés
   cd sportkocsi-alkalmazas
   ```

2. **Függőségek Telepítése**
   ```bash
   # Maven függőségek letöltése
   mvn dependency:resolve
   
   # Projekt tiszta build-elése
   mvn clean install
   ```

3. **Alkalmazás Indítása**
   ```bash
   # Futtatás Maven-nel
   mvn exec:java
   
   # Vagy közvetlenül JAR fájlból
   java -jar target/sportkocsi-alkalmazas-1.0-SNAPSHOT.jar
   ```

## Adatok Kezelése

### JSON Fájl Struktúra
```json
{
    "id": "1",
    "marka": "Ferrari",
    "modell": "488 GTB",
    "loero": 670,
    "vegsebesseg": 330,
    "ar": 250000
}
```

### Új Autó Hozzáadása
1. Nyisd meg a `src/main/resources/sportkocsik.json` fájlt
2. Kövesd a meglévő JSON formátumot
3. Add hozzá az új autó adatait
4. Mentsd el a fájlt
5. Indítsd újra az alkalmazást

## Hibakezelés és Hibaelhárítás

### Gyakori Hibák és Megoldások

1. **JSON Fájl Nem Található**
   - Ellenőrizd a fájl elérési útját
   - Ellenőrizd a fájl jogosultságokat
   - Ellenőrizd a fájl nevét és kiterjesztését

2. **Érvénytelen JSON Formátum**
   - Validáld a JSON szintaxist
   - Ellenőrizd a kötelező mezőket
   - Ellenőrizd az adattípusokat

3. **Futtatási Hibák**
   - Ellenőrizd a Java verziót
   - Ellenőrizd a Maven beállításokat
   - Nézd meg a konzol hibaüzeneteit

### Naplózás
- A program részletes hibaüzeneteket jelenít meg
- A kivételek stack trace-e elérhető a fejlesztői konzolban
- A felhasználói felületen informatív hibaüzenetek jelennek meg

## Fejlesztési Lehetőségek

### Rövid Távú Tervek
1. **Adatbázis Integráció**
   - SQL adatbázis bevezetése
   - CRUD műveletek implementálása
   - Adatbázis kapcsolat kezelése

2. **Felhasználói Felület Fejlesztése**
   - Részletesebb adatmegjelenítés
   - Szerkesztési lehetőségek
   - Keresési funkciók bővítése

3. **Adatvalidáció**
   - Input mezők ellenőrzése
   - Adatformátum validáció
   - Hibaüzenetek finomítása

### Hosszú Távú Tervek
1. **Többnyelvű Támogatás**
   - Nyelvi fájlok bevezetése
   - Dinamikus nyelvváltás
   - Lokalizált felület

2. **Jelentéskészítés**
   - PDF exportálás
   - Excel exportálás
   - Statisztikai riportok

3. **Hálózati Funkciók**
   - Kliens-szerver architektúra
   - Valós idejű adatfrissítés
   - Többfelhasználós támogatás

## Közreműködés

### Fejlesztői Irányelvek
1. Kövesse a Java kódolási konvenciókat
2. Írjon dokumentációt az új funkciókhoz
3. Készítsen unit teszteket
4. Használja a Git verziókezelőt

### Pull Request Folyamat
1. Fork-olja a repository-t
2. Hozzon létre új branch-et
3. Commitolja a változtatásokat
4. Nyisson Pull Request-et
5. Várja meg a review-t

## Licensz

Ez a projekt a MIT licensz alatt áll. További információkért lásd a LICENSE fájlt.

## Kapcsolat

- Fejlesztő: [Az Ön Neve]
- Email: [Az Ön Email Címe]
- Egyetem: [Egyetem Neve]
- Tantárgy: Elosztott Alkalmazások
- Konzulens: [Konzulens Neve]

## Kivételkezelési Stratégia

### 1. Fájlkezelési Kivételek
```java
try {
    // JSON fájl beolvasása
    JSONParser parser = new JSONParser();
    JSONArray autok = (JSONArray) parser.parse(new InputStreamReader(
        SportkocsiReader.class.getResourceAsStream(fajlNev)));
} catch (FileNotFoundException e) {
    // Fájl nem található
    throw new Exception("A JSON fájl nem található: " + e.getMessage());
} catch (IOException e) {
    // I/O hiba
    throw new Exception("Hiba történt a fájl olvasása közben: " + e.getMessage());
} catch (ParseException e) {
    // JSON parsing hiba
    throw new Exception("A JSON fájl formátuma érvénytelen: " + e.getMessage());
}
```

### 2. Adatkonverziós Kivételek
```java
try {
    // Adatok konvertálása
    int loero = ((Long) auto.get("loero")).intValue();
    int vegsebesseg = ((Long) auto.get("vegsebesseg")).intValue();
    int ar = ((Long) auto.get("ar")).intValue();
} catch (ClassCastException e) {
    // Típuskonverziós hiba
    throw new Exception("Érvénytelen adattípus: " + e.getMessage());
} catch (NullPointerException e) {
    // Hiányzó adat
    throw new Exception("Hiányzó kötelező mező: " + e.getMessage());
}
```

### 3. Felhasználói Felület Kivételkezelése
```java
try {
    // Felhasználói művelet végrehajtása
    int minLoero = Integer.parseInt(input);
    List<Sportkocsi> szurtLista = service.szuresTeljesitmenyFelett(minLoero);
} catch (NumberFormatException e) {
    // Érvénytelen szám formátum
    JOptionPane.showMessageDialog(null, "Érvénytelen számformátum!");
} catch (Exception e) {
    // Egyéb hibák
    JOptionPane.showMessageDialog(null, "Hiba történt: " + e.getMessage());
} 