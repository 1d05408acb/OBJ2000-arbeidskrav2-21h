package arbeidskrav2;

public class Gaupe extends Dyr {
    double lengdeOre;

    public Gaupe(String id, String kjonn, double lengde, double vekt, String sted, String dato, double lengdeOre) {
        super(id, kjonn, lengde, vekt, sted, dato);
        this.lengdeOre = lengdeOre;
    }

    @Override
    public String toString() {
        return super.toString() + "Lengde øre: " + lengdeOre;
    }

    public double getLengdeOre() {
        return lengdeOre;
    }
}
