package arbeidskrav2;

public class Gjenfangst {
    private final String datoen;
    private final String stedet;
    private final double lengden;
    private final double vekten;

    public Gjenfangst(String dato, String sted, double lengde, double vekt) {
        datoen = dato;
        stedet = sted;
        lengden = lengde;
        vekten = vekt;
    }

    public String toString() {
        return "Dato for gjenfangst: " + datoen + "\n" +
                "Sted: " + stedet + "\n" +
                "Lengde: " + lengden + "\n" +
                "Vekt: " + vekten;
    }
}
