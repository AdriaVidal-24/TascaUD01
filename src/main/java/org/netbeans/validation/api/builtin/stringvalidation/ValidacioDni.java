package org.netbeans.validation.api.builtin.stringvalidation;

import org.netbeans.validation.api.Problems;
import org.openide.util.NbBundle;

public class ValidacioDni extends StringValidator {

    private static final String LLETRES = "TRWAGMYFPDXBNJZSQVHLCKE";

    @Override
    public void validate(Problems problems, String compName, String text) {
        if (!"".equals(text) && !esDniValid(text)) {
            String missatge = NbBundle.getMessage(this.getClass(), "MSG_DNI", compName);
            problems.add(missatge);
        }
    }

    public static boolean esDniValid(String dni) {
        String net = dni.trim().toUpperCase();
        if (!net.matches("[0-9]{8}[A-Z]")) {
            return false;
        }
        int numero = Integer.parseInt(net.substring(0, 8));
        return LLETRES.charAt(numero % 23) == net.charAt(8);
    }
}
