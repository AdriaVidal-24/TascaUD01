package cat.paucasesnoves.lloguerjocs.dto;

public enum Plataforma {
    PS5("PS5"),
    SWITCH_2("Switch 2"),
    XBOX("Xbox"),
    PC("PC");

    private final String nom;

    Plataforma(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}
