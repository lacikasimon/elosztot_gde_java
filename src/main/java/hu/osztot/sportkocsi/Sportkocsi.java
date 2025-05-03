package hu.osztot.sportkocsi;

// Importáljuk a szükséges osztályokat a JSON kezeléshez
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// Ez az osztály egy sportautót reprezentál
public class Sportkocsi {
    // Az autó egyedi azonosítója
    private String id;
    // Az autó márkája (pl. Ferrari, Porsche)
    private String marka;
    // Az autó modellje (pl. 488 GTB, 911 Turbo S)
    private String modell;
    // Az autó teljesítménye lóerőben
    private int loero;
    // Az autó maximális sebessége km/h-ban
    private int vegsebesseg;
    // Az autó ára forintban
    private int ar;

    // Konstruktor - itt állítjuk be az autó tulajdonságait
    public Sportkocsi(String id, String marka, String modell, int loero, int vegsebesseg, int ar) {
        this.id = id;
        this.marka = marka;
        this.modell = modell;
        this.loero = loero;
        this.vegsebesseg = vegsebesseg;
        this.ar = ar;
    }

    // Getterek és setterek - ezekkel lehet lekérdezni és módosítani az autó tulajdonságait
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getMarka() { return marka; }
    public void setMarka(String marka) { this.marka = marka; }
    public String getModell() { return modell; }
    public void setModell(String modell) { this.modell = modell; }
    public int getLoero() { return loero; }
    public void setLoero(int loero) { this.loero = loero; }
    public int getVegsebesseg() { return vegsebesseg; }
    public void setVegsebesseg(int vegsebesseg) { this.vegsebesseg = vegsebesseg; }
    public int getAr() { return ar; }
    public void setAr(int ar) { this.ar = ar; }

    // toString metódus - az autó adatait szövegként adja vissza
    @Override
    public String toString() {
        return marka + " " + modell + " (" + loero + " LE, " + vegsebesseg + " km/h, " + ar + " EUR)";
    }
}