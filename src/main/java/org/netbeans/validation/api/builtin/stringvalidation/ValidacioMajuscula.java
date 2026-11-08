package org.netbeans.validation.api.builtin.stringvalidation;

import org.netbeans.validation.api.Problems;
import org.openide.util.NbBundle;

public class ValidacioMajuscula extends StringValidator {

    @Override
    public void validate(Problems problems, String compName, String text) {
        if (!"".equals(text) && !Character.isUpperCase(text.charAt(0))) {
            String missatge = NbBundle.getMessage(this.getClass(), "MSG_MAJUSCULA", compName);
            problems.add(missatge);
        }
    }
}
