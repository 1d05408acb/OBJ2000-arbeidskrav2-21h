package arbeidskrav2;

import java.util.ArrayList;

public class Gjenfangst {
    public static ArrayList<Gjenfangst> listeGjenfangst = new ArrayList<>();
    private final String datoen;
    private final String stedet;
    private final double lengden;
    private final double vekten;
    private String idn;

    public Gjenfangst(String id, String dato, String sted, double lengde, double vekt) {
        idn = id;
        datoen = dato;
        stedet = sted;
        lengden = lengde;
        vekten = vekt;
    }

    public static ArrayList<Gjenfangst> getGjenfangst() {
        return listeGjenfangst;
    }

    public String hentId() {
        return idn;
    }

    public String toString() {
        return "Dato for gjenfangst: " + datoen + "\n" +
                "Sted: " + stedet + "\n" +
                "Lengde: " + lengden + "\n" +
                "Vekt: " + vekten;
    }
}
