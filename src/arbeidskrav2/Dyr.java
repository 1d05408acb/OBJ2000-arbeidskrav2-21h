package arbeidskrav2;

import java.text.Collator;
import java.util.ArrayList;

public class Dyr {
    private String idn;
    private String kjonnet;
    private double lengden;
    private double vekten;
    private String stedet;
    private String datoen;
    public ArrayList<Gjenfangst> listeGjenfangst = new ArrayList<Gjenfangst>();
    private final static Collator Kollator = Collator.getInstance();

    public Dyr(String id, String kjonn, double lengde, double vekt, String sted, String dato) {
        idn = id;
        kjonnet = kjonn;
        lengden = lengde;
        vekten = vekt;
        this.stedet = sted;
        datoen = dato;
    }

    public int compareTo(Dyr dyr) {
        return Kollator.compare(this.idn, dyr.idn);
    }

    public boolean equals(Dyr dyr) {
        return Kollator.equals(this.idn, dyr.idn);
    }

    public ArrayList<Gjenfangst> hentFangst() {
        return listeGjenfangst;
    }

    public String hentId() {
        return idn;
    }

    public double hentLengde() {
        return lengden;
    }
    public double hentVekt() {
        return vekten;
    }

    public String hentSted() {
        return stedet;
    }

    public String hentDato() {
        return datoen;
    }

    public void registrerGjenfangst(Gjenfangst g) {
        listeGjenfangst.add(g);
    }

    public ArrayList<Gjenfangst> getGjenfangst() {
        return listeGjenfangst;
    }

    public String toString() {
        return "ID: " + idn + "\n" +
                "Kjønn: " + kjonnet + "\n" +
                "Lengde: " + lengden + "cm" + "\n" +
                "Vekt: " + vekten + "kg" + "\n" +
                "Fangested: " + stedet + "\n" +
                "Dato: " + datoen;
    }
}


