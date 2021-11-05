package arbeidskrav2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import static arbeidskrav2.Dyr.listeGjenfangst;

public class GUI {
    // Alternativer / valg i menyen som aktiveres med case
    Kontroll kontroll = new Kontroll();
    private final String[] ALTERNATIVER =
            {"Registrer gaupe",
            "Registrer hare",
            "Registrer gjenfangst gaupe",
            "Registrer gjenfangst hare",
            "Finn ett dyr:",
            "Skriv ut dyre liste",
            "Dyr med fangst",
            "Avslutt"};

    // Kode for å motta valg (integer input) fra knapper og melding på hovedsiden + tittel på vinduet
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
    // Bruker while løkke som avsluttes hvis brukeren trykket på noe annet enn 0-6 som er valg 0-6
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

    // Lager registrer gaupe funksjon som tar imot input og sender videre til registrerGaupe i kontroll klassen.
    public void registrerGaupe() {
        String kjonn = JOptionPane.showInputDialog("Gaupen's kjønn (hann/hunn): ");
        double lengde = Double.parseDouble(JOptionPane.showInputDialog("Gaupen's lengde i cm: "));
        double vekt = Double.parseDouble(JOptionPane.showInputDialog("Gaupen's vekt i kg: "));
        String sted = JOptionPane.showInputDialog("Sted fanget: ");
        String dato = JOptionPane.showInputDialog("Dato fanget (dd.mm.yyyy): ");
        double lengdeOre = Double.parseDouble(JOptionPane.showInputDialog("Gaupen's lengde øretust (cm): "));
        kontroll.registrerGaupe(kjonn, lengde, vekt, sted, dato, lengdeOre);
    }

    // Lager registrer hare funksjon som tar imot input og sender videre til registrerHare i kontroll klassen
    public void registrerHare() {
        String kjonn = JOptionPane.showInputDialog("Haren's kjønn (hann/hunn): ");
        double lengde = Double.parseDouble(JOptionPane.showInputDialog("Haren's lengde i cm: "));
        double vekt = Double.parseDouble(JOptionPane.showInputDialog("Haren's vekt i kg: "));
        String sted = JOptionPane.showInputDialog("Sted fanget: ");
        String dato = JOptionPane.showInputDialog("Dato fanget (dd.mm.yyyy): ");
        String type = JOptionPane.showInputDialog("Haren's type (vanlig hare/sørhare): ");
        char type_formatert = type.charAt(0); //formatere til å kun ta imot bokstav/char på plass 0 (første bokstav) i stringen
        String farge = JOptionPane.showInputDialog("Haren's farge (hvit/brun): ");
        char farge_formatert = farge.charAt(0); //formatere til å kun ta imot bokstav/char på plass 0 (første bokstav) i stringen
        kontroll.registrerHare(kjonn, lengde, vekt, sted, dato, type_formatert, farge_formatert);
    }

    // Lager registrer gjenfangst gaupe funksjon som tar imot input og sender videre til registrerGjenfangstGaupe i kontroll klassen
    public void registrerGjennfangstGaupe() {
        String id = JOptionPane.showInputDialog("Dyrets ID: ");
        double lengde = Double.parseDouble(JOptionPane.showInputDialog("Gaupen's lengde i cm: "));
        double vekt = Double.parseDouble(JOptionPane.showInputDialog("Gaupen's vekt i kg: "));
        String sted = JOptionPane.showInputDialog("Sted gjenfanget: ");
        String dato = JOptionPane.showInputDialog("Dato gjenfanget (dd.mm.yyyy): ");
        double lengdeOre = Double.parseDouble(JOptionPane.showInputDialog("Gaupen's lengde øretust (cm): "));
        kontroll.registrerGjenfangstGaupe(id, dato, sted, lengde, vekt, lengdeOre);
    }

    // Lager registrer gjenfangst hare funksjon som tar imot input og sender videre til registrerGjenfangstHare i kontroll klassen
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

    // Lage finn dyr funksjon som tar imot input på dyrets ID. Hvor den så kobler seg mot kontroll klassen og finnDyr hvor den sender "id" parameteren
    public void finnDyr() {
        String id = JOptionPane.showInputDialog("Dyrets ID: ");
        StringBuilder tekst = new StringBuilder();
        Dyr DyretBinaert = kontroll.finnDyrBinaert(id);
        if (DyretBinaert != null) {
            tekst.append(DyretBinaert);
            tekst.append("\n");
            tekst.append("------------------------");
            tekst.append("\n");
            /*Gjenfangst DyretLinjaert = kontroll.finnDyrLinjaert(id);
            tekst.append(DyretLinjaert);
            tekst.append("\n");
            tekst.append("------------------------");
            tekst.append("\n"); Har kommentert ut koden her siden jeg ikke klarte å koble det opp mot linjær søket i kontroll*/
            } else {
                JOptionPane.showMessageDialog(null, "Fant ingen dyr med den ID'en");
        }
        JOptionPane.showMessageDialog(null, tekst.toString());
    }

    // Liste ut dyr uten gjenfangst
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

    // Liste ut dyr + gjenfangst
    public void listDyrMedGjenfangst() {
        ArrayList<Dyr> Dyrene = kontroll.getDyr();
        StringBuilder tekst = new StringBuilder();
        for (Dyr Dyret : Dyrene) {
            tekst.append(Dyret.toString());
            tekst.append("\n");
            tekst.append("------------------------");
            tekst.append("\n");
            for (Gjenfangst g : listeGjenfangst) {
                tekst.append(g.toString());
                tekst.append("\n");
                tekst.append("------------------------");
                tekst.append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, tekst.toString());
    }
}
