package edu.unl.cc.succession.common;

import edu.unl.cc.succession.model.Printable;
import edu.unl.cc.succession.model.Successionable;

/**
 * @author Darío Chillogallo, Kiara Condoy, Javier Guarnizo, Domenica Narvaez y José Valencia
 */

public abstract class SuccessionBase implements Successionable, Printable {
    protected Integer boundaryValue;
    protected Integer currentTerm;
    protected StringBuilder seriesText;
    protected boolean isPrime;

    public SuccessionBase(Integer boundaryValue) {
        this(1, boundaryValue);
    }

    public SuccessionBase(Integer boundaryValue, boolean isPrime) {
        this(isPrime ? 2 : 1, boundaryValue);
    }

    public SuccessionBase(Integer start, Integer boundaryValue) {
        start = validateInput(start, "Down limit");
        setLimit(boundaryValue);
        this.currentTerm = start;
        this.seriesText = new StringBuilder("S = ");
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
        for (int i = 2; i <= Math.sqrt(number); i++) {
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
     * Obtiene la representacion en cadena de texto de la serie generada,
     * limpiando el signo "+" sobrante del final de forma automatica.
     *
     * @return Cadena de caracteres formateada limpiamente.
     */
    @Override
    public String print() {
        if (this.seriesText != null && this.seriesText.length() > 4) {
            String text = this.seriesText.toString();
            if (text.endsWith(" + ")) {
                return text.substring(0, text.length() - 3);
            }
            return text;
        }
        return this.seriesText != null ? this.seriesText.toString() : "";
    }
}