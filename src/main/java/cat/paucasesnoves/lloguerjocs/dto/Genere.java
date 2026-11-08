package cat.paucasesnoves.lloguerjocs.dto;

public enum Genere {
    ACCIO,
    AVENTURA,
    ESPORTS,
    CURSES,
    ROL,
    ESTRATEGIA,
    LLUITA,
    PLATAFORMES,
    SIMULACIO,
    TRETS;

    public String getClau() {
        return "genere." + name().toLowerCase();
    }
}
