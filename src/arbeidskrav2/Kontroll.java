package arbeidskrav2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class Kontroll {
    // Opprette en array liste
    private final ArrayList<Dyr> listeDyr = new ArrayList<>();
    ArrayList<Gjenfangst> listeGjenfangst = Gjenfangst.getGjenfangst();

    // Opprette variabler for å kunne telle
    private int antallGauper = 0;
    private int antallHarer = 0;

    public void registrerGaupe(String kjonn, double lengde, double vekt, String sted, String dato, double lengdeOre){
        antallGauper++; // //Autogenererer nytt nr for hver registrering
        String id = "G" + antallGauper; // Lager id satt sammen av kjennetegn og nytt nr
        Gaupe nyGaupe = new Gaupe(id, kjonn, lengde, vekt, sted, dato, lengdeOre); // Sender variablene videre til sub klassen gaupe av dyr
        listeDyr.add(nyGaupe);
    }

    public void registrerHare(String kjonn, double lengde, double vekt, String sted, String dato, char type_formatert, char farge_formatert) {
        antallHarer++; //Autogenererer nytt nr for hver registrering
        String id = "H" + antallHarer; // Lager id satt sammen av kjennetegn og nytt nr
        Hare nyHare = new Hare(id, kjonn, lengde, vekt, sted, dato, type_formatert, farge_formatert); // Sender variablene videre til sub klassen hare av dyr
        listeDyr.add(nyHare); // Sender variablene videre til sub klassen gaupe av dyr
    }

    public Gjenfangst finnDyrLinjaert(String id) {
        /* Linjært søk med dyr id som parameter. Sliter med å få denne til å ungere ammen med binært.
        Planen var at binært søket nedenfor skulle hente ut alle id registrert i listeDyr og at
        linjær søket skulle hente ut alle fra listeGjenfangst. Men måtte bare gi opp og levere arbeidskravet*/
        Gjenfangst gjenfangst = null;
        boolean funnet = false;
        int teller = 0;
        while (!funnet) {
            gjenfangst = listeGjenfangst.get(teller);
            if (id.equals(gjenfangst.hentId())) {
                funnet = true;
            }
            else {
                teller++;
            }
        }
        return gjenfangst;
    }


    public Dyr finnDyrBinaert(String id) {
        // Binært søk etter dyr med parameter id. Bruker malen som vi har gått igjennom i forelesning.
        Collections.sort(listeDyr);
        Dyr dummy = new Dyr(id, null, 0, 0, null, null);
        int indeks = Collections.binarySearch(listeDyr, dummy);
        if(indeks >= 0) {
            return listeDyr.get(indeks);
        }
        else {
            return null;
        }
    }

    public void registrerGjenfangstGaupe(String id, String dato, String sted, double lengde, double vekt, double lengdeOre) {
        Gaupe gaupen = (Gaupe)finnDyrBinaert(id);
        if (gaupen != null) {
            GjenfangstGaupe Gjenfangst = new GjenfangstGaupe(id, dato, sted, lengde, vekt, lengdeOre);
            gaupen.registrerGjenfangst(Gjenfangst);
        } else {
            JOptionPane.showMessageDialog(null, "Det er ingen gaupe registrert med den ID'en");
        }
    }

    public void registrerGjenfangstHare(String id, String dato, String sted, double lengde, double vekt, char farge) {
        Hare haren = (Hare)finnDyrBinaert(id);
        if (haren != null) {
            GjenfangstHare Gjenfangst = new GjenfangstHare(id, dato, sted, lengde, vekt, farge);
            haren.registrerGjenfangst(Gjenfangst);
        } else {
            JOptionPane.showMessageDialog(null, "Det er ingen hare registrert med den ID'en");
        }
    }
    // Henter ut listen listeDyr med get'er og return.
    public ArrayList<Dyr> getDyr() {
        return listeDyr;
    }
}
