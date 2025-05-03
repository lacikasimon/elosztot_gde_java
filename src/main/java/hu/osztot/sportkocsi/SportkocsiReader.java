package hu.osztot.sportkocsi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// Ez az osztály felelős a JSON fájl beolvasásáért és a sportautók listává alakításáért
public class SportkocsiReader {
    // Ez a metódus beolvassa a JSON fájlt és visszaadja a sportautók listáját
    public static List<Sportkocsi> beolvas(String fajlNev) throws Exception {
        // Létrehozunk egy üres listát a sportautóknak
        List<Sportkocsi> sportkocsik = new ArrayList<>();
        
        try {
            // Létrehozunk egy JSON parser-t a fájl feldolgozásához
            JSONParser parser = new JSONParser();
            // Beolvassuk a JSON fájlt és átalakítjuk JSONArray-vé
            JSONArray autok = (JSONArray) parser.parse(new InputStreamReader(
                SportkocsiReader.class.getResourceAsStream(fajlNev)));
            
            // Végigmegyünk az összes autón a JSON tömbben
            for (Object o : autok) {
                // Átalakítjuk az objektumot JSONObject-té
                JSONObject auto = (JSONObject) o;
                // Létrehozunk egy új Sportkocsi objektumot a JSON adatokból
                Sportkocsi s = new Sportkocsi(
                    String.valueOf(auto.get("id")),      // Azonosító
                    (String) auto.get("marka"),          // Márka
                    (String) auto.get("modell"),         // Modell
                    ((Long) auto.get("loero")).intValue(),      // Lóerő
                    ((Long) auto.get("vegsebesseg")).intValue(), // Végsebesség
                    ((Long) auto.get("ar")).intValue()          // Ár
                );
                // Hozzáadjuk az autót a listához
                sportkocsik.add(s);
            }
        } catch (Exception e) {
            // Ha hiba történik, továbbadjuk a kivételt
            throw new Exception("Hiba történt a JSON fájl feldolgozása során: " + e.getMessage());
        }
        
        // Visszaadjuk a sportautók listáját
        return sportkocsik;
    }
} 