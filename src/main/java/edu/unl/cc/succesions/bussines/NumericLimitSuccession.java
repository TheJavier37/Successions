package edu.unl.cc.succesions.bussines;

import edu.unl.cc.succesions.model.Printable;
import edu.unl.cc.succesions.model.Successionable;

/**
 * Clase abstracta que representa una sucesion basada en un limite de valor
 * @author TheJavier37 (Javier Guarnizo)
 *
 */
public abstract class NumericLimitSuccession implements Successionable, Printable {

    protected Integer limit;
    protected Integer currentTerm;
    protected StringBuilder printableTerms;

    @Override
    public void setLimit(Number limit) {
        if (limit == null) {
            throw new IllegalArgumentException("limit cannot be null");
        }
        if (limit instanceof Integer) {
            if (limit.intValue() < 0) {
                throw new IllegalArgumentException("limit cannot be negative");
            }
            this.limit = (Integer) limit;
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
