package edu.unl.cc.succession.business;

import edu.unl.cc.succession.common.SuccessionBase;

/**
 * Serie 2
 * Representa la serie de numeros primos elevados al cubo hasta un limite de valor.
 * S = 1^3 + 2^3 + 3^3 + 5^3 + ... + N
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
        long result = 0;
        long cubedValue = (long) Math.pow(this.currentTerm, 3);
        while (cubedValue <= this.boundaryValue) {
            this.seriesText.append(this.currentTerm).append("^3").append(" + ");
            result += cubedValue;
            this.currentTerm = this.nextTerm(this.currentTerm).intValue();
            cubedValue = (long) Math.pow(this.currentTerm, 3);
        }
        return result;
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

