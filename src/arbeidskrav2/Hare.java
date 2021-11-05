package arbeidskrav2;

// Lage en subklasse Hare av Dyr
public class Hare extends Dyr {
    private final char typen; // Initiere variabel
    private final char fargen; // Initiere variabel

    public Hare(String id, String kjonn, double lengde, double vekt, String sted, String dato, char type, char farge) {
        super(id, kjonn, lengde, vekt, sted, dato);
        typen = type;
        fargen = farge;
    }

    public String toString() {
        return super.toString() +
                "Type: " + typen +
                "\n" +
                "Farge: " + fargen;
    }

}
