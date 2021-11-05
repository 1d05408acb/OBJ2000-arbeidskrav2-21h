package arbeidskrav2;

import java.util.ArrayList;

public class Dyr {
    private final String idn;
    private final String kjonnet;
    private final double lengden;
    private final double vekten;
    private final String stedet;
    private final String datoen;
    public ArrayList<Gjenfangst> listeGjenfangst = new ArrayList<>();

    public Dyr(String id, String kjonn, double lengde, double vekt, String sted, String dato) {
        idn = id;
        kjonnet = kjonn;
        lengden = lengde;
        vekten = vekt;
        this.stedet = sted;
        datoen = dato;
    }

    public String hentId() {
        return idn;
    }

    public void registrerGjenfangst(Gjenfangst g) {
        listeGjenfangst.add(g);
    }

    public String toString() {
        return "ID: " + idn + "\n" +
                "Kjønn: " + kjonnet + "\n" +
                "Lengde: " + lengden + "cm" + "\n" +
                "Vekt: " + vekten + "kg" + "\n" +
                "Fangested: " + stedet + "\n" +
                "Dato: " + datoen + "\n";
    }
}


