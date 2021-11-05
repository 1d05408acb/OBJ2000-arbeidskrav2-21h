package arbeidskrav2;

import java.util.ArrayList;

public class Dyr implements Comparable<Dyr> {
    public static ArrayList<Gjenfangst> listeGjenfangst = new ArrayList<>();
    private final String idn;
    private final String kjonnet;
    private final double lengden;
    private final double vekten;
    private final String stedet;
    private final String datoen;

    public Dyr(String id, String kjonn, double lengde, double vekt, String sted, String dato) {
        idn = id;
        kjonnet = kjonn;
        lengden = lengde;
        vekten = vekt;
        this.stedet = sted;
        datoen = dato;
    }

    // Legger til i gjenfangst arrayen
    public void registrerGjenfangst(Gjenfangst g) {
        listeGjenfangst.add(g);
    }

    // LAger to string for formatert utskrift
    public String toString() {
        return "ID: " + idn + "\n" +
                "Kjønn: " + kjonnet + "\n" +
                "Lengde: " + lengden + "cm" + "\n" +
                "Vekt: " + vekten + "kg" + "\n" +
                "Fangested: " + stedet + "\n" +
                "Dato: " + datoen + "\n";
    }

    @Override
    public int compareTo(Dyr dyr) {
        return this.idn.compareTo(dyr.idn);
    }
}



