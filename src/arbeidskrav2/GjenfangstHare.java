package arbeidskrav2;

public class GjenfangstHare extends Gjenfangst {
    private char fargen;

    public GjenfangstHare(String dato, String sted, double lengde, double vekt, char farge) {
        super(dato, sted, lengde, vekt);
        fargen = farge;
    }
    public String toString() {
        return super.toString() + "\t" + "Fargen:" + fargen;
    }

}
