package edu.unl.cc.succession.business;

import edu.unl.cc.succession.common.SuccessionBase;

/**
 * Serie 9
 * Representa la serie de primos elevados a la raiz cuadrada hasta un limite.
 * S = 1^(1/2) + 3^(1/2) + 5^(1/2) + 7^(1/2) + 11^(1/2) + 13^(1/2) + ... + N^(1/2)
 * @author js_valencia (Jose Valencia)
 */
public class PrimesSquareRootSumUpToLimit extends SuccessionBase {

    public PrimesSquareRootSumUpToLimit(Integer limit) {
        this(1, limit);
    }

    public PrimesSquareRootSumUpToLimit(Integer start, Integer limit) {
        super(limit);
        setLimit(limit);
        this.currentTerm = nextTerm(start - 1).intValue();
    }

    @Override
    public Number calculate() {
        double result = 0;
        while (this.currentTerm <= this.boundaryValue) {
            result += Math.sqrt(this.currentTerm);
            this.seriesText
                    .append(this.currentTerm)
                    .append("^(1/2) + ");
            this.currentTerm = this.nextTerm(this.currentTerm).intValue();
        }
        return result;
    }

    @Override
    public Number nextTerm(Number current) {
        current = current.intValue() + 1;
        if (current.intValue() == 1) {
            return current;
        }
        if (current.intValue() == 2) {
            current = 3;
        }
        boolean isPrime = false;
        while (!isPrime) {
            isPrime = isPrime(current.intValue());
            if (!isPrime) {
                current = current.intValue() + 1;
            }
        }
        return current;
    }
}
