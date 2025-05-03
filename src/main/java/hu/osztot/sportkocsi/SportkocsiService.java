package hu.osztot.sportkocsi;

import java.util.*;
import java.util.stream.Collectors;

// Ez az osztály a sportautók listáján végez különböző műveleteket
public class SportkocsiService {
    // A sportautók listája
    private List<Sportkocsi> sportkocsik;

    // Konstruktor - itt állítjuk be a sportautók listáját
    public SportkocsiService(List<Sportkocsi> sportkocsik) {
        this.sportkocsik = sportkocsik;
    }

    // Megkeresi a legnagyobb teljesítményű autót
    public Sportkocsi legnagyobbTeljesitmeny() {
        return sportkocsik.stream().max(Comparator.comparingInt(Sportkocsi::getLoero)).orElse(null);
    }

    // Megkeresi a legnagyobb végsebességű autót
    public Sportkocsi legnagyobbVegsebesseg() {
        return sportkocsik.stream().max(Comparator.comparingInt(Sportkocsi::getVegsebesseg)).orElse(null);
    }

    // Kiszámolja az autók átlagárát
    public double atlagAr() {
        return sportkocsik.stream().mapToInt(Sportkocsi::getAr).average().orElse(0);
    }

    // Megkeresi a legdrágább autót
    public Sportkocsi legdragabb() {
        return sportkocsik.stream().max(Comparator.comparingInt(Sportkocsi::getAr)).orElse(null);
    }

    // Rendezi az autókat teljesítmény szerint csökkenő sorrendben
    public List<Sportkocsi> teljesitmenySzerintCsokkeno() {
        return sportkocsik.stream()
                .sorted(Comparator.comparingInt(Sportkocsi::getLoero).reversed())
                .collect(Collectors.toList());
    }

    // Kiszámolja az autók átlagos végsebességét
    public double atlagVegsebesseg() {
        return sportkocsik.stream().mapToInt(Sportkocsi::getVegsebesseg).average().orElse(0);
    }

    // Megkeresi a legalacsonyabb árú autót
    public Sportkocsi legalacsonyabbAr() {
        return sportkocsik.stream().min(Comparator.comparingInt(Sportkocsi::getAr)).orElse(null);
    }

    // Megkeresi azt a márkát, amelyiknek a legtöbb modellje van
    public String legtobbModellMarka() {
        return sportkocsik.stream()
                .collect(Collectors.groupingBy(Sportkocsi::getMarka, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(null);
    }

    // Kiszűri azokat az autókat, amelyek teljesítménye meghaladja a megadott értéket
    public List<Sportkocsi> szuresTeljesitmenyFelett(int minLoero) {
        return sportkocsik.stream()
                .filter(s -> s.getLoero() > minLoero)
                .collect(Collectors.toList());
    }

    // Rendezi az autókat ár szerint növekvő sorrendben
    public List<Sportkocsi> arSzerintNovekvo() {
        return sportkocsik.stream()
                .sorted(Comparator.comparingInt(Sportkocsi::getAr))
                .collect(Collectors.toList());
    }
} 