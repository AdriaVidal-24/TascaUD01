package cat.paucasesnoves.lloguerjocs.logica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cat.paucasesnoves.lloguerjocs.dto.EstatLloguer;
import cat.paucasesnoves.lloguerjocs.dto.Genere;
import cat.paucasesnoves.lloguerjocs.dto.Joc;
import cat.paucasesnoves.lloguerjocs.dto.Lloguer;
import cat.paucasesnoves.lloguerjocs.dto.Plataforma;
import cat.paucasesnoves.lloguerjocs.dto.Usuari;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogicaNegociTest {

    @BeforeEach
    public void reiniciar() {
        LogicaNegoci.carregarDadesInicials();
    }

    private Joc joc(String titol) {
        for (Joc joc : LogicaNegoci.getJocs()) {
            if (joc.getTitol().equals(titol)) {
                return joc;
            }
        }
        return null;
    }

    private Usuari usuari(String nom) {
        for (Usuari usuari : LogicaNegoci.getUsuaris()) {
            if (usuari.getNom().equals(nom)) {
                return usuari;
            }
        }
        return null;
    }

    @Test
    public void lesDadesInicialsTenenLaDisponibilitatCorrecta() {
        assertEquals(3, LogicaNegoci.getUsuaris().size());
        assertEquals(3, LogicaNegoci.getLloguers().size());
        assertEquals(0, joc("Forza Horizon 5").getUnitatsDisponibles(Plataforma.XBOX));
        assertEquals(0, joc("EA Sports FC 25").getUnitatsDisponibles(Plataforma.SWITCH_2));
        assertEquals(1, joc("Minecraft").getUnitatsDisponibles(Plataforma.PC));
        assertEquals(1, LogicaNegoci.comptarLloguers(EstatLloguer.ACTIU));
        assertEquals(1, LogicaNegoci.comptarLloguers(EstatLloguer.FORA_DE_TERMINI));
        assertEquals(1, LogicaNegoci.comptarLloguers(EstatLloguer.RETORNAT));
    }

    @Test
    public void llogarDescomptaUnaUnitatIDevolucioLaTorna() throws ExcepcioLloguer {
        Joc minecraft = joc("Minecraft");
        Lloguer lloguer = LogicaNegoci.registrarLloguer(usuari("Marta"), minecraft, Plataforma.PS5);
        assertEquals(0, minecraft.getUnitatsDisponibles(Plataforma.PS5));
        assertEquals(4, lloguer.getNumero());
        assertEquals(4, LogicaNegoci.getLloguers().get(0).getNumero());
        LogicaNegoci.registrarDevolucio(lloguer);
        assertEquals(1, minecraft.getUnitatsDisponibles(Plataforma.PS5));
        assertEquals(EstatLloguer.RETORNAT, lloguer.getEstat());
        assertThrows(ExcepcioLloguer.class, () -> LogicaNegoci.registrarDevolucio(lloguer));
    }

    @Test
    public void noEsPotLlogarSenseEstocNiAmbUnaPlataformaQueNoTe() {
        assertThrows(ExcepcioLloguer.class, () -> LogicaNegoci.registrarLloguer(usuari("Aina"), joc("Forza Horizon 5"), Plataforma.XBOX));
        assertThrows(ExcepcioLloguer.class, () -> LogicaNegoci.registrarLloguer(usuari("Aina"), joc("Forza Horizon 5"), Plataforma.PS5));
    }

    @Test
    public void noEsPotDuplicarUnLloguerActiu() {
        assertThrows(ExcepcioLloguer.class, () -> LogicaNegoci.registrarLloguer(usuari("Joan"), joc("EA Sports FC 25"), Plataforma.PS5));
    }

    @Test
    public void noEsPotEsborrarAmbLloguersActius() throws ExcepcioLloguer {
        assertThrows(ExcepcioLloguer.class, () -> LogicaNegoci.eliminarUsuari(usuari("Marta")));
        assertThrows(ExcepcioLloguer.class, () -> LogicaNegoci.eliminarJoc(joc("Forza Horizon 5")));
        Usuari aina = usuari("Aina");
        LogicaNegoci.eliminarUsuari(aina);
        assertFalse(LogicaNegoci.getUsuaris().contains(aina));
    }

    @Test
    public void noEsPotRepetirElDniNiElTitol() throws ExcepcioLloguer {
        Usuari repetit = new Usuari("Pere", "Mas", "Coll", "43123456C", "611111111", new Date());
        assertThrows(ExcepcioLloguer.class, () -> LogicaNegoci.afegirUsuari(repetit));
        Joc nou = new Joc("Hades II", Genere.ACCIO);
        nou.afegirUnitats(Plataforma.PC, 2);
        LogicaNegoci.afegirJoc(nou);
        assertTrue(LogicaNegoci.getJocs().contains(nou));
        Joc repetitJoc = new Joc("minecraft", Genere.AVENTURA);
        repetitJoc.afegirUnitats(Plataforma.PC, 1);
        assertThrows(ExcepcioLloguer.class, () -> LogicaNegoci.afegirJoc(repetitJoc));
    }
}
