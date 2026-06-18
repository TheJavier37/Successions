package edu.unl.cc.succession.business;

import edu.unl.cc.succession.model.Printable;
import edu.unl.cc.succession.model.Successionable;

/**
 * Clase abstracta que representa una sucesion basada en una cantidad de terminos
 * @author TheJavier37 (Javier Guarnizo)
 *
 */
public abstract class TermBasedSuccession implements Successionable, Printable {

    protected Integer finalTerm;
    protected Integer currentTerm;
    protected StringBuilder printableTerms;

    protected Integer validateLimit(Number value, String label) {
        if (value == null) {
            throw new IllegalArgumentException(label + " cannot be null");
        }
        if (value instanceof Integer) {
            if (value.intValue() < 0) {
                throw new IllegalArgumentException(label + " cannot be negative");
            }
            return value.intValue();
        } else {
            throw new IllegalArgumentException(label + " must be an integer");
        }
    }

    @Override
    public void setLimit(Number limit) {
        this.finalTerm = validateLimit(limit, "Upper limit");
    }

    @Override
    public String print() {
        String s = this.printableTerms.toString();
        if (s.endsWith(" + ")) {
            s = s.substring(0, s.length() - 3);
        }
        return s;
    }
}
