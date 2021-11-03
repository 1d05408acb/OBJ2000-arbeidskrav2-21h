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

    public void registrerHare(String kjonn, double lengde, double vekt, String sted, String dato, char type_formatert, String farge) {
        antallHarer++;
        String id = "H" + antallHarer;
        id.trim(); // Fjerner mellomrom mellom string og int
        Hare nyHare = new Hare(id, kjonn, lengde, vekt, sted, dato, type_formatert, farge);
        listeDyr.add(nyHare);
    }

    public void registrerDyr(Dyr dyr) {
        listeDyr.add(dyr);
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

    public void registrerGjenfangst(GjenfangstGaupe Gjenfangst, String id) {
        Dyr dyret = finnDyr(id);
        if(dyret != null) {
            dyret.registrerGjenfangst(Gjenfangst);
        }
    }

    public void registrerGjenfangstGaupe(String id, String dato, String sted, double lengde, double vekt, double lengdeOre) {
        Gaupe gaupen = (Gaupe)finnDyr(id);
        if (gaupen != null) {
            GjenfangstGaupe Gjenfangst = new GjenfangstGaupe(dato, sted, lengde, vekt, lengdeOre);
            gaupen.registrerGjenfangst(Gjenfangst);
        }
    }

    public void registrerGjennfangstHare(String id, String dato, String sted, double lengde, double vekt, char farge) {
        Hare haren = (Hare)finnDyr(id);
        if (haren != null) {
            GjenfangstHare Gjenfangst = new GjenfangstHare(dato, sted, lengde, vekt, farge);
            haren.registrerGjenfangst(Gjenfangst);
        }
    }

    public ArrayList<Dyr>  getDyr() {
        return listeDyr;
    }
}
