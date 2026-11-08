package org.netbeans.validation.api.builtin.stringvalidation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Locale;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.netbeans.validation.api.Problems;

public class ValidadorsTest {

    @BeforeAll
    public static void establirIdioma() {
        Locale.setDefault(Locale.forLanguageTag("ca-ES"));
    }

    @Test
    public void unNomAmbMajusculaEsCorrecte() {
        Problems problems = new Problems();
        new ValidacioMajuscula().validate(problems, "Nom", "Anna");
        assertFalse(problems.hasFatal());
    }

    @Test
    public void unNomSenseMajusculaDonaErrorEnCatala() {
        Problems problems = new Problems();
        new ValidacioMajuscula().validate(problems, "Nom", "anna");
        assertTrue(problems.hasFatal());
        assertEquals("El camp Nom ha de començar amb una lletra majúscula.", problems.getLeadProblem().getMessage());
    }

    @Test
    public void elDniComprovaLaLletra() {
        assertTrue(ValidacioDni.esDniValid("43123456C"));
        assertTrue(ValidacioDni.esDniValid("41234567Y"));
        assertTrue(ValidacioDni.esDniValid("78901234X"));
        assertFalse(ValidacioDni.esDniValid("43123456A"));
        assertFalse(ValidacioDni.esDniValid("1234567Z"));
    }

    @Test
    public void elTelefonHaDeTenirNouXifres() {
        Problems problems = new Problems();
        new ValidacioTelefon().validate(problems, "Telèfon", "12345");
        assertTrue(problems.hasFatal());
        Problems correcte = new Problems();
        new ValidacioTelefon().validate(correcte, "Telèfon", "612345678");
        assertFalse(correcte.hasFatal());
    }

    @Test
    public void elsMissatgesDeLaLlibreriaEstanEnCatala() {
        Problems problems = new Problems();
        StringValidators.REQUIRE_NON_EMPTY_STRING.validate(problems, "Nom", "");
        assertEquals("El camp Nom no pot estar buit.", problems.getLeadProblem().getMessage());
    }
}
