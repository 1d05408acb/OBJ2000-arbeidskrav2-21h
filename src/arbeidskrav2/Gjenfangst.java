package arbeidskrav2;

public class Gjenfangst {
    private String datoen;
    private String stedet;
    private double lengden;
    private double vekten;
    double lengdeOre;

    public Gjenfangst(String dato, String sted, double lengde, double vekt) {
        datoen = dato;
        stedet = sted;
        lengden = lengde;
        vekten = vekt;
    }

    public String hentDato() {
        return datoen;
    }

    public String hentSted() {
        return stedet;
    }

    public double hentLengde() {
        return lengden;
    }

    public double hentVekt() {
        return vekten;
    }

    public String toString() {
        return "Dato for gjenfangst: " + datoen + "\n" +
                "Sted: " + stedet + "\n" +
                "Lengde: " + lengden + "\n" +
                "Vekt: " + vekten + "\n";
    }
}
