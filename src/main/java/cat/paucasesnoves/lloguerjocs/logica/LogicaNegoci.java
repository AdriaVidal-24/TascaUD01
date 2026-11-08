package cat.paucasesnoves.lloguerjocs.logica;

import cat.paucasesnoves.lloguerjocs.dto.EstatLloguer;
import cat.paucasesnoves.lloguerjocs.dto.Genere;
import cat.paucasesnoves.lloguerjocs.dto.Joc;
import cat.paucasesnoves.lloguerjocs.dto.Lloguer;
import cat.paucasesnoves.lloguerjocs.dto.Plataforma;
import cat.paucasesnoves.lloguerjocs.dto.Usuari;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LogicaNegoci {

    private static List<Usuari> llistaUsuaris = new ArrayList<>();
    private static List<Joc> llistaJocs = new ArrayList<>();
    private static List<Lloguer> llistaLloguers = new ArrayList<>();
    private static int darrerNumero = 0;

    static {
        carregarDadesInicials();
    }

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

    private static Lloguer crearLloguer(Usuari usuari, Joc joc, Plataforma plataforma, Date dataInici) {
        joc.llogarUnitat(plataforma);
        darrerNumero++;
        Lloguer lloguer = new Lloguer(darrerNumero, usuari, joc, plataforma, dataInici);
        llistaLloguers.add(lloguer);
        return lloguer;
    }

    private static Date faDies(int dies) {
        Calendar calendari = Calendar.getInstance();
        calendari.add(Calendar.DAY_OF_MONTH, -dies);
        return calendari.getTime();
    }

    public static void carregarDadesInicials() {
        llistaUsuaris.clear();
        llistaJocs.clear();
        llistaLloguers.clear();
        darrerNumero = 0;

        Usuari marta = new Usuari("Marta", "Ferrer", "Pons", "43123456C", "612345678", faDies(90));
        Usuari joan = new Usuari("Joan", "Riera", "Bauzà", "41234567Y", "971234567", faDies(60));
        Usuari aina = new Usuari("Aina", "Capó", "Vidal", "78901234X", "678901234", faDies(30));
        llistaUsuaris.add(marta);
        llistaUsuaris.add(joan);
        llistaUsuaris.add(aina);

        Joc fc25 = new Joc("EA Sports FC 25", Genere.ESPORTS);
        fc25.afegirUnitats(Plataforma.PS5, 2);
        fc25.afegirUnitats(Plataforma.SWITCH_2, 1);
        Joc forza = new Joc("Forza Horizon 5", Genere.CURSES);
        forza.afegirUnitats(Plataforma.XBOX, 1);
        forza.afegirUnitats(Plataforma.PC, 2);
        Joc minecraft = new Joc("Minecraft", Genere.AVENTURA);
        minecraft.afegirUnitats(Plataforma.PS5, 1);
        minecraft.afegirUnitats(Plataforma.SWITCH_2, 1);
        minecraft.afegirUnitats(Plataforma.XBOX, 1);
        minecraft.afegirUnitats(Plataforma.PC, 1);
        llistaJocs.add(fc25);
        llistaJocs.add(forza);
        llistaJocs.add(minecraft);

        Lloguer retornat = crearLloguer(aina, minecraft, Plataforma.PC, faDies(15));
        retornat.setDataRetorn(faDies(9));
        minecraft.retornarUnitat(Plataforma.PC);
        crearLloguer(marta, forza, Plataforma.XBOX, faDies(10));
        crearLloguer(joan, fc25, Plataforma.SWITCH_2, faDies(2));
    }
}
