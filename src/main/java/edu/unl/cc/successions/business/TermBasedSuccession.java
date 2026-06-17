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

    @Override
    public void setLimit(Number limit) {
        if (limit == null) {
            throw new IllegalArgumentException("limit cannot be null");
        }
        if (limit instanceof Integer) {
            if (limit.intValue() <= 0) {
                throw new IllegalArgumentException("terms count must be greater than zero");
            }
            this.finalTerm = (Integer) limit;
        } else {
            throw new IllegalArgumentException("limit must be an integer");
        }
    }

    @Override
    public String print() {
        String output = printableTerms.toString();
        if (output.endsWith(" + ")) {
            output = output.substring(0, output.length() - 3);
        }
        return output;
    }
}
