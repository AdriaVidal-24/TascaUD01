package cat.paucasesnoves.lloguerjocs.logica;

import cat.paucasesnoves.lloguerjocs.dto.EstatLloguer;
import cat.paucasesnoves.lloguerjocs.dto.Joc;
import cat.paucasesnoves.lloguerjocs.dto.Lloguer;
import cat.paucasesnoves.lloguerjocs.dto.Usuari;
import java.util.ArrayList;
import java.util.List;

public class LogicaNegoci {

    private static List<Usuari> llistaUsuaris = new ArrayList<>();
    private static List<Joc> llistaJocs = new ArrayList<>();
    private static List<Lloguer> llistaLloguers = new ArrayList<>();
    private static int darrerNumero = 0;

    public static List<Usuari> getUsuaris() {
        return llistaUsuaris;
    }

    public static List<Joc> getJocs() {
        return llistaJocs;
    }

    public static List<Lloguer> getLloguers() {
        List<Lloguer> ordenats = new ArrayList<>();
        for (int i = llistaLloguers.size() - 1; i >= 0; i--) {
            ordenats.add(llistaLloguers.get(i));
        }
        return ordenats;
    }

    public static int getSeguentNumero() {
        return darrerNumero + 1;
    }

    public static int comptarLloguers(EstatLloguer estat) {
        int total = 0;
        for (Lloguer lloguer : llistaLloguers) {
            if (lloguer.getEstat() == estat) {
                total++;
            }
        }
        return total;
    }
}
