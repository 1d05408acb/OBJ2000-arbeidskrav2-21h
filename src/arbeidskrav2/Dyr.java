package arbeidskrav2;

import java.text.Collator;
import java.util.ArrayList;

public class Dyr {
    private String id;
    private char kjonn;
    private double lengde;
    private double vekt;
    private String sted;
    private String dato;
    private ArrayList<Gjenfangst> listeGjenfangst = new ArrayList<Gjenfangst>();
    private final static Collator Kollator = Collator.getInstance();

    public Dyr(String i, char k, double l, double v, String s, String d) {
        id = i;
        kjonn = k;
        lengde = l;
        vekt = v;
        sted = s;
        dato = d;
    }

    public int compareto(Dyr dyr) {
        return Kollator.compare(this.id, dyr.id);
    }

    public boolean equals(Dyr dyr) {
        return Kollator.equals(this.id, dyr.id);
    }

    public ArrayList<Gjenfangst> hentFangst() {
        return listeGjenfangst;
    }

    public String hentId() {
        return id;
    }

    public double hentLengde() {
        return lengde;
    }
    public double hentVekt() {
        return vekt;
    }

    public String hentSted() {
        return sted;
    }

    public String hentDato() {
        return dato;
    }

    public void regGjenfangst(Gjenfangst g) {
        listeGjenfangst.add(g);
    }

    public ArrayList<Gjenfangst> getGjenfangst() {
        return listeGjenfangst;
    }

    public String toString() {
        return "ID: " + id + "\n" +
                "Kjønn: " + kjonn + "\n" +
                "Lengde: " + lengde + "\n" +
                "Vekt: " + vekt + "\n" +
                "Fangested: " + sted + "\n" +
                "Dato: " + dato;
    }
}
