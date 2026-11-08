package cat.paucasesnoves.lloguerjocs.dto;

public enum EstatLloguer {
    ACTIU,
    FORA_DE_TERMINI,
    RETORNAT;

    public String getClau() {
        return "estat." + name().toLowerCase();
    }
}
