package arbeidskrav2;

public class GjenfangstGaupe extends Gjenfangst {
    double lengdeOre;

    public GjenfangstGaupe(String dato, String sted, double lengde, double vekt, double lengdeOre) {
        super(dato, sted, lengde, vekt);
        this.lengdeOre = lengdeOre;
    }
}
