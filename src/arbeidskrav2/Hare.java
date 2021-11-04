package arbeidskrav2;

// Lage en subklasse Hare av Dyr
public class Hare extends Dyr {
    private char typen; // Initiere variabel
    private char fargen; // Initiere variabel

    public Hare(String id, String kjonn, double lengde, double vekt, String sted, String dato, char type, char farge) {
        super(id, kjonn, lengde, vekt, sted, dato);
        typen = type;
        fargen = farge;
    }

    public char hentType() {
        return typen;
    }

    public char hentFarge() {
        return fargen;
    }

    public String toString() {
        return super.toString() +
                "Type: " + typen +
                "\n" +
                "Farge: " + fargen;
    }

}
