package edu.unl.cc.succession.business;

import edu.unl.cc.succession.common.SuccessionBase;

/**
 * Serie 2
 * Representa la serie de numeros primos elevados al cubo hasta un limite de valor.
 * S = 2^3 + 3^3 + 5^3 + ... + N
 * @author TheJavier37 (Javier Guarnizo)
 */
public class CubicPrimesSumUpToLimit extends SuccessionBase {

    public CubicPrimesSumUpToLimit(Integer start, Integer limit) {
        super(2,limit);
        start = validateInput(start, "Down limit");
        this.currentTerm = nextTerm(start - 1).intValue();
    }

    @Override
    public Number calculate() {
        int sum = 0;
        Integer term = this.currentTerm;

        while (term <= this.boundaryValue) {
            int cubicValue = (int) Math.pow(term, 3);

            if (sum + cubicValue > this.boundaryValue) {
                break;
            }

            sum += cubicValue;
            this.seriesText.append(term).append("^3 + ");

            term = nextTerm(term).intValue();
        }

        this.currentTerm = term;

        return sum;
    }

    @Override
    public Number nextTerm(Number current) {
        current = current.intValue() + 1;
        if (current.intValue() == 1) {
            return current;
        }
        boolean isPrimeResult = false;
        while (!isPrimeResult) {
            isPrimeResult = isPrime(current.intValue());
            if (!isPrimeResult) {
                current = current.intValue() + 1;
            }
        }
        return current;
    }

}

