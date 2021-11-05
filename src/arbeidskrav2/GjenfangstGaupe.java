package arbeidskrav2;

public class GjenfangstGaupe extends Gjenfangst {
    double lengdeOre;

    public GjenfangstGaupe(String id, String dato, String sted, double lengde, double vekt, double lengdeOre) {
        super(id, dato, sted, lengde, vekt);
        this.lengdeOre = lengdeOre;
    }
}
