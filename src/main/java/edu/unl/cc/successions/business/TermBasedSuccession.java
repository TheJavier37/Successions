package edu.unl.cc.successions.business;

import edu.unl.cc.successions.model.Printable;
import edu.unl.cc.successions.model.Successionable;

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
        return this.printableTerms.toString();
    }
}
