package arbeidskrav2;

public class GjenfangstHare extends Gjenfangst {
    private final char fargen;
    // Lage en sub klasse av klassen gjenfangst

    public GjenfangstHare(String id,String dato, String sted, double lengde, double vekt, char farge) {
        super(id, dato, sted, lengde, vekt);
        fargen = farge;
    }

    @Override
    public String toString() {
        return super.toString()  + "Fargen:" + fargen;
    }
}
