package arbeidskrav2;

public class Hare extends Dyr {
    private char typen;
    private String fargen;

    public Hare(String id, String kjonn, double lengde, double vekt, String sted, String dato, char type, String farge) {
        super(id, kjonn, lengde, vekt, sted, dato);
        typen = type;
        fargen = farge;
    }

    public char hentType() {
        return typen;
    }

    public String hentFarge() {
        return fargen;
    }

    public String toString() {
        return super.toString() + "\t" + "\t" + fargen;
    }

}
