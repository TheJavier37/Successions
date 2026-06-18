package edu.unl.cc.succession.common;

import edu.unl.cc.succession.model.Printable;
import edu.unl.cc.succession.model.Successionable;

public abstract class SuccessionBase implements Successionable, Printable {
    protected Integer boundaryValue;
    protected Integer currentTerm;
    protected StringBuilder seriesText;

    public SuccessionBase(Integer boundaryValue) {
        this(1, boundaryValue);
    }

    public SuccessionBase(Integer start, Integer boundaryValue) {
        start = validateInput(start, "Down limit");
        setLimit(boundaryValue);
        this.currentTerm = start;
        this.seriesText = new StringBuilder("S = ");
    }

    public SuccessionBase() {

    }

    protected Integer validateInput(Number value, String label) {
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

    protected boolean isPrime(Integer number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setLimit(Number limit) {
        this.boundaryValue = validateInput(limit, "Upper limit");
    }

    @Override
    public abstract Number calculate();

    @Override
    public abstract Number nextTerm(Number current);

    /**
     * Implementacion por defecto del metodo print.
     * Al no ser abstracto, las clases hijas pueden usarlo directamente o heredar su comportamiento.
     *
     * @return La cadena de caracteres que representa la serie.
     */
    @Override
    public String print() {
        return this.seriesText != null ? this.seriesText.toString() : "";
    }
}
