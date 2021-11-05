package arbeidskrav2;

import javax.swing.*;
import java.util.ArrayList;

public class Kontroll {
    // Opprette en array liste
    ArrayList<Dyr> listeDyr = new ArrayList<>();
    // Opprette variabler for å kunne telle
    private int antallGauper = 0;
    private int antallHarer = 0;

    public void registrerGaupe(String kjonn, double lengde, double vekt, String sted, String dato, double lengdeOre){
        antallGauper++; // Hver gang det loopes igjennom så legges til ett tall til variabelen
        String id = "G" + antallGauper;
        Gaupe nyGaupe = new Gaupe(id, kjonn, lengde, vekt, sted, dato, lengdeOre);
        listeDyr.add(nyGaupe);
    }

    public void registrerHare(String kjonn, double lengde, double vekt, String sted, String dato, char type_formatert, char farge_formatert) {
        antallHarer++;
        String id = "H" + antallHarer;
        Hare nyHare = new Hare(id, kjonn, lengde, vekt, sted, dato, type_formatert, farge_formatert);
        listeDyr.add(nyHare);
    }

    public Dyr finnDyr(String id) {
        // Linjært søk etter dyr:
        Dyr dyr = null;
        boolean funnet = false;
        int teller = 0;
        while(!funnet) {
            dyr = listeDyr.get(teller);
            if(id.equals(dyr.hentId()))
                funnet = true;
            else
                teller ++;
        }
        return dyr;
    }

    public void registrerGjenfangstGaupe(String id, String dato, String sted, double lengde, double vekt, double lengdeOre) {
        Gaupe gaupen = (Gaupe)finnDyr(id);
        if (gaupen != null) {
            GjenfangstGaupe Gjenfangst = new GjenfangstGaupe(dato, sted, lengde, vekt, lengdeOre);
            gaupen.registrerGjenfangst(Gjenfangst);
        } else {
            JOptionPane.showMessageDialog(null, "Det er ingen gaupe registrert med den ID'en");
        }
    }

    public void registrerGjenfangstHare(String id, String dato, String sted, double lengde, double vekt, char farge) {
        Hare haren = (Hare)finnDyr(id);
        if (haren != null) {
            GjenfangstHare Gjenfangst = new GjenfangstHare(dato, sted, lengde, vekt, farge);
            haren.registrerGjenfangst(Gjenfangst);
        } else {
            JOptionPane.showMessageDialog(null, "Det er ingen hare registrert med den ID'en");
        }
    }

    public ArrayList<Dyr>  getDyr() {
        return listeDyr;
    }
}
