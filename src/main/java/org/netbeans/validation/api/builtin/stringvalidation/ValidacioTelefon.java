package org.netbeans.validation.api.builtin.stringvalidation;

import org.netbeans.validation.api.Problems;
import org.openide.util.NbBundle;

public class ValidacioTelefon extends StringValidator {

    @Override
    public void validate(Problems problems, String compName, String text) {
        if (!"".equals(text) && !text.trim().matches("[6789][0-9]{8}")) {
            String missatge = NbBundle.getMessage(this.getClass(), "MSG_TELEFON", compName);
            problems.add(missatge);
        }
    }
}
