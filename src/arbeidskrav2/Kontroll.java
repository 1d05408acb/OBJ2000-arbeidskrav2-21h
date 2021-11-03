package arbeidskrav2;

import java.util.ArrayList;

public class Kontroll {
    // Opprette en array liste
    ArrayList<Dyr> listeDyr = new ArrayList<Dyr>();
    // Opprette variabler for å kunne telle
    private int antallGauper = 0;
    private int antallHarer = 0;

    public void registrerGaupe(String kjonn, double lengde, double vekt, String sted, String dato, double lengdeOre){
        antallGauper++; // Hver gang det loopes igjennom så legges til ett tall til variabelen
        String id = "G" + antallGauper;
        id.trim(); // Fjerner mellomrom mellom string og int
        Gaupe nyGaupe = new Gaupe(id, kjonn, lengde, vekt, sted, dato, lengdeOre);
        listeDyr.add(nyGaupe);
    }
}
