package arbeidskrav2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GUI {
    Kontroll kontroll = new Kontroll();
    // Alternativer / valg i menyen
    private String[] ALTERNATIVER =
            {"Registrer gaupe",
            "Registrer hare",
            "Gjenfangst gaupe",
            "Gjenfangst hare"};

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
            switch(valg) {
                case 0:
                    // registrerGaupe();
                    break;
                case 1:
                    // registrerHare();
                    break;
                case 2:
                    // gjenfangstGaupe();
                    break;
                case 3:
                    // gjenfangstHare();
                default:
                    fortsette = false;
            }
        }
    }

    public void registrerGaupe() {
        String kjonn = JOptionPane.showInputDialog("Kjønnet: ");
        double lengde = Double.parseDouble(JOptionPane.showInputDialog("Lengde: "));
        double vekt = Double.parseDouble(JOptionPane.showInputDialog("Vekt: "));
        String sted = JOptionPane.showInputDialog("Sted: ");
        String dato = JOptionPane.showInputDialog("Dato (dd.mm.yyyy): ");
        double lengdeOre = Double.parseDouble(JOptionPane.showInputDialog("Lengde (øretust): "));
        kontroll.registrerGaupe(kjonn, lengde, vekt, sted, dato, lengdeOre);
    }
}
