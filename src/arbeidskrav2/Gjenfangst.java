package arbeidskrav2;

public class Gjenfangst {
    private String dato;
    private String sted;
    private double lengde;
    private double vekt;

    public Gjenfangst(String d, String s, double l, double v) {
        dato = d;
        sted = s;
        lengde = l;
        vekt = v;
    }

    public String hentDato() {
        return dato;
    }

    public String hentSted() {
        return sted;
    }

    public double hentLengde() {
        return lengde;
    }

    public double hentVekt() {
        return vekt;
    }

    public String toString() {
        return "Dato for gjenfangst: " + dato + "\n" +
                "Sted: " + sted + "\n" +
                "Lengde: " + lengde + "\n" +
                "Vekt: " + vekt;
    }

}
