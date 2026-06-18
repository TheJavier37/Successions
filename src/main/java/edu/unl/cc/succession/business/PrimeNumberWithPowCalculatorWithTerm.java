package edu.unl.cc.succession.business;

import edu.unl.cc.succession.common.SuccessionBase;

/**
 * 7. Representa el cálculo de la Serie de números primos elevados a la potencia inversa del número primo hasta N términos
 * (S = 1^(1/1) + 3^(1/3) + 5^(1/5) + 7^(1/7) + 11^(1/9) + 13^(1/11)):
 * @author Darío Chillogallo, Kiara Condoy, Javier Guarnizo, Domenica Narvaez y José Valencia
 */

public class PrimeNumberWithPowCalculatorWithTerm extends SuccessionBase {
    public PrimeNumberWithPowCalculatorWithTerm(Integer boundaryValue) {
        super(boundaryValue);
    }

    public PrimeNumberWithPowCalculatorWithTerm(Integer start, Integer boundaryValue) {
        super(start, boundaryValue);
    }

    @Override
    public Number calculate() {
        this.currentTerm = nextTerm(this.currentTerm).intValue();
        double result = 0;
        int countTerm = 0;
        int denominatorExponent = 1;

        while (countTerm < boundaryValue) {
            this.seriesText
                    .append(currentTerm)
                    .append("^(1/")
                    .append(denominatorExponent)
                    .append(") + ");
            result += Math.pow(currentTerm, 1.0 / denominatorExponent);
            currentTerm = nextTerm(currentTerm).intValue();
            denominatorExponent += 2;
            countTerm++;
        }
        this.seriesText.append("= ").append(result);
        return result;
    }

    /**
     * Representar el término solo de la base de la serir
     * @param current
     * @return
     */
    @Override
    public Number nextTerm(Number current) {
        int next = current.intValue() + 1;
        while (!isPrime(next)) {
            next++;
        }
        return next;
    }

    @Override
    public String print() {
        return this.seriesText.toString();
    }
}
