package edu.unl.cc.succession.business;

import edu.unl.cc.succession.model.Printable;
import edu.unl.cc.succession.model.Successionable;

/**
 * Clase abstracta que representa una sucesion basada en un limite de valor
 * @author TheJavier37 (Javier Guarnizo)
 *
 */
public abstract class NumericLimitSuccession implements Successionable, Printable {

    protected Integer limit;
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
        this.limit = validateLimit(limit, "Upper limit");
    }

    @Override
    public String print() {
        return this.printableTerms.toString();
    }
}
