package hu.osztot.sportkocsi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// Ez az osztály a felhasználói felületet kezeli
public class SportkocsiGUI extends JFrame {
    // A szolgáltatás osztály, ami a sportautókkal kapcsolatos műveleteket végzi
    private SportkocsiService service;
    // A szövegterület, ahol megjelenítjük az eredményeket
    private JTextArea textArea;

    // Konstruktor - itt állítjuk be a sportautók listáját és inicializáljuk a GUI-t
    public SportkocsiGUI(List<Sportkocsi> sportkocsik) {
        this.service = new SportkocsiService(sportkocsik);
        initializeGUI();
    }

    // Inicializálja a felhasználói felületet
    private void initializeGUI() {
        // Beállítjuk az ablak címét és méretét
        setTitle("Sportkocsik Adatbázis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Létrehozzuk a fő panelt
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Létrehozzuk a gombok panelt
        JPanel buttonPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        
        // Létrehozzuk és hozzáadjuk a gombokat
        String[] buttonLabels = {
            "Legnagyobb teljesítmény",
            "Legnagyobb végsebesség",
            "Átlagár",
            "Legdrágább autó",
            "Teljesítmény szerint csökkenő",
            "Átlag végsebesség",
            "Legalacsonyabb ár",
            "Legtöbb modell márkája",
            "Teljesítmény szűrés",
            "Ár szerint növekvő"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        // Létrehozzuk a szövegterületet
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Hozzáadjuk a komponenseket a fő panelhez
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);
    }

    // Ez az osztály kezeli a gombok kattintásait
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = ((JButton) e.getSource()).getText();
            StringBuilder result = new StringBuilder();

            // A gomb szövege alapján végrehajtjuk a megfelelő műveletet
            switch (command) {
                case "Legnagyobb teljesítmény":
                    Sportkocsi legnagyobbLoero = service.legnagyobbTeljesitmeny();
                    result.append("Legnagyobb teljesítményű autó:\n").append(legnagyobbLoero);
                    break;
                case "Legnagyobb végsebesség":
                    Sportkocsi legnagyobbVegsebesseg = service.legnagyobbVegsebesseg();
                    result.append("Legnagyobb végsebességű autó:\n").append(legnagyobbVegsebesseg);
                    break;
                case "Átlagár":
                    double atlagAr = service.atlagAr();
                    result.append(String.format("Átlagár: %.2f Ft", atlagAr));
                    break;
                case "Legdrágább autó":
                    Sportkocsi legdragabb = service.legdragabb();
                    result.append("Legdrágább autó:\n").append(legdragabb);
                    break;
                case "Teljesítmény szerint csökkenő":
                    List<Sportkocsi> teljesitmenySzerint = service.teljesitmenySzerintCsokkeno();
                    result.append("Teljesítmény szerint csökkenő sorrend:\n");
                    for (Sportkocsi s : teljesitmenySzerint) {
                        result.append(s).append("\n");
                    }
                    break;
                case "Átlag végsebesség":
                    double atlagVegsebesseg = service.atlagVegsebesseg();
                    result.append(String.format("Átlag végsebesség: %.2f km/h", atlagVegsebesseg));
                    break;
                case "Legalacsonyabb ár":
                    Sportkocsi legalacsonyabbAr = service.legalacsonyabbAr();
                    result.append("Legalacsonyabb árú autó:\n").append(legalacsonyabbAr);
                    break;
                case "Legtöbb modell márkája":
                    String legtobbModellMarka = service.legtobbModellMarka();
                    result.append("Legtöbb modelllel rendelkező márka: ").append(legtobbModellMarka);
                    break;
                case "Teljesítmény szűrés":
                    String input = JOptionPane.showInputDialog("Adja meg a minimális teljesítményt (lóerő):");
                    try {
                        int minLoero = Integer.parseInt(input);
                        List<Sportkocsi> szurtLista = service.szuresTeljesitmenyFelett(minLoero);
                        result.append(String.format("Autók %d lóerő felett:\n", minLoero));
                        for (Sportkocsi s : szurtLista) {
                            result.append(s).append("\n");
                        }
                    } catch (NumberFormatException ex) {
                        result.append("Érvénytelen számformátum!");
                    }
                    break;
                case "Ár szerint növekvő":
                    List<Sportkocsi> arSzerint = service.arSzerintNovekvo();
                    result.append("Ár szerint növekvő sorrend:\n");
                    for (Sportkocsi s : arSzerint) {
                        result.append(s).append("\n");
                    }
                    break;
            }

            // Megjelenítjük az eredményt a szövegterületen
            textArea.setText(result.toString());
        }
    }

    // A program belépési pontja
    public static void main(String[] args) {
        // Az Event Dispatch Thread-en futtatjuk a GUI-t
        SwingUtilities.invokeLater(() -> {
            try {
                // Beolvassuk a sportautókat a JSON fájlból
                List<Sportkocsi> sportkocsik = SportkocsiReader.beolvas("/sportkocsik.json");
                // Létrehozzuk és megjelenítjük a GUI-t
                SportkocsiGUI gui = new SportkocsiGUI(sportkocsik);
                gui.setVisible(true);
                
                // Kiírjuk az összes betöltött adatot
                StringBuilder allData = new StringBuilder("Betöltött sportkocsik:\n\n");
                for (Sportkocsi s : sportkocsik) {
                    allData.append(s).append("\n");
                }
                gui.textArea.setText(allData.toString());
            } catch (Exception e) {
                // Ha hiba történik, megjelenítjük a hibaüzenetet
                JOptionPane.showMessageDialog(null, "Hiba történt az adatok betöltése során: " + e.getMessage());
            }
        });
    }
} 