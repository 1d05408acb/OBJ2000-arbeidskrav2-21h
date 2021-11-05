package arbeidskrav2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GUI {
    Kontroll kontroll = new Kontroll();
    // Alternativer / valg i menyen
    private final String[] ALTERNATIVER =
            {"Registrer gaupe",
            "Registrer hare",
            "Registrer gjenfangst gaupe",
            "Registrer gjenfangst hare",
            "Finn ett dyr",
            "Skriv ut dyre liste",
            "Dyr med fangst",
            "Avslutt"};

    // Kode for å motta valg (integer input) fra knapper
    public int valgt() {
        int valg;
        valg = JOptionPane.showOptionDialog(null,
                "MENY - Gjør et valg",
                "Dyre register",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                ALTERNATIVER,
                ALTERNATIVER[0]);
        return valg;
    }

    // Kode for å aktivere ulike funksjoner ved valg av knapper
    public void program() {
        boolean fortsette = true;
        while(fortsette) {
            int valg = valgt();
            switch (valg) {
                case 0 -> registrerGaupe();
                case 1 -> registrerHare();
                case 2 -> registrerGjennfangstGaupe();
                case 3 -> registrerGjennfangstHare();
                case 4 -> finnDyr();
                case 5 -> listDyr();
                case 6 -> listDyrMedGjenfangst();
                default -> fortsette = false;
            }
        }
    }

    public void registrerGaupe() {
        String kjonn = JOptionPane.showInputDialog("Gaupen's kjønn (hann/hunn): ");
        double lengde = Double.parseDouble(JOptionPane.showInputDialog("Gaupen's lengde i cm: "));
        double vekt = Double.parseDouble(JOptionPane.showInputDialog("Gaupen's vekt i kg: "));
        String sted = JOptionPane.showInputDialog("Sted fanget: ");
        String dato = JOptionPane.showInputDialog("Dato fanget (dd.mm.yyyy): ");
        double lengdeOre = Double.parseDouble(JOptionPane.showInputDialog("Gaupen's lengde øretust (cm): "));
        kontroll.registrerGaupe(kjonn, lengde, vekt, sted, dato, lengdeOre);
    }

    public void registrerHare() {
        String kjonn = JOptionPane.showInputDialog("Haren's kjønn (hann/hunn): ");
        double lengde = Double.parseDouble(JOptionPane.showInputDialog("Haren's lengde i cm: "));
        double vekt = Double.parseDouble(JOptionPane.showInputDialog("Haren's vekt i kg: "));
        String sted = JOptionPane.showInputDialog("Sted fanget: ");
        String dato = JOptionPane.showInputDialog("Dato fanget (dd.mm.yyyy): ");
        String type = JOptionPane.showInputDialog("Haren's type (vanlig hare/sørhare): ");
        char type_formatert = type.charAt(0);
        String farge = JOptionPane.showInputDialog("Haren's farge (hvit/brun): ");
        char farge_formatert = farge.charAt(0);
        kontroll.registrerHare(kjonn, lengde, vekt, sted, dato, type_formatert, farge_formatert);
    }

    public void registrerGjennfangstGaupe() {
        String id = JOptionPane.showInputDialog("Dyrets ID: ");
        double lengde = Double.parseDouble(JOptionPane.showInputDialog("Gaupen's lengde i cm: "));
        double vekt = Double.parseDouble(JOptionPane.showInputDialog("Gaupen's vekt i kg: "));
        String sted = JOptionPane.showInputDialog("Sted gjenfanget: ");
        String dato = JOptionPane.showInputDialog("Dato gjenfanget (dd.mm.yyyy): ");
        double lengdeOre = Double.parseDouble(JOptionPane.showInputDialog("Gaupen's lengde øretust (cm): "));
        kontroll.registrerGjenfangstGaupe(id, dato, sted, lengde, vekt, lengdeOre);
    }

    public void registrerGjennfangstHare() {
        String id = JOptionPane.showInputDialog("Dyrets ID: ");
        double lengde = Double.parseDouble(JOptionPane.showInputDialog("Haren's lengde i cm: "));
        double vekt = Double.parseDouble(JOptionPane.showInputDialog("Haren's vekt i kg: "));
        String sted = JOptionPane.showInputDialog("Sted gjenfanget: ");
        String dato = JOptionPane.showInputDialog("Dato gjenfanget (dd.mm.yyyy): ");
        String farge = JOptionPane.showInputDialog("Haren's farge (hvit/brun): ");
        char farge_formatert = farge.charAt(0);
        kontroll.registrerGjenfangstHare(id, dato, sted, lengde, vekt, farge_formatert);
    }

    public void finnDyr() {
        String id = JOptionPane.showInputDialog("Dyrets ID: ");
        id = id.trim();
        Dyr Dyret = kontroll.finnDyr(id);
        if (Dyret != null) {
            JOptionPane.showMessageDialog(null, Dyret.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Fant ikke dyret");
        }
    }

    public void listDyr() {
        ArrayList<Dyr> Dyrene = kontroll.getDyr();
        StringBuilder tekst = new StringBuilder();
        for (Dyr Dyret : Dyrene) {
            tekst.append(Dyret.toString());
            tekst.append("\n");
            tekst.append("------------------------");
            tekst.append("\n");
        }
        JOptionPane.showMessageDialog(null, tekst.toString());
    }

    public void listDyrMedGjenfangst() {
        ArrayList<Dyr> Dyrene = kontroll.getDyr();
        StringBuilder tekst = new StringBuilder();
        for (Dyr Dyret : Dyrene) {
            tekst.append(Dyret.toString());
            tekst.append("\n");
            tekst.append("------------------------");
            tekst.append("\n");
            for (Gjenfangst g : Dyret.listeGjenfangst) {
                tekst.append(g.toString());
                tekst.append("\n");
                tekst.append("------------------------");
                tekst.append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, tekst.toString());
    }
}
