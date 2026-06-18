package edu.unl.cc.succession.business;

import edu.unl.cc.succession.common.SuccessionBase;

/**
 * Serie 10
 * Representa la serie de primos hasta un limite.
 * S = 1 + 2 + 3 + 5 + 7 + 11 + 13 + ... + N
 * @author js_valencia (Jose Valencia)
 *
 */
public class PrimesSumUpToLimit extends SuccessionBase {

    public PrimesSumUpToLimit(Integer limit) {
        this(1, limit);
    }

    public PrimesSumUpToLimit(Integer start, Integer limit) {
        super(limit);
        start = validateInput(start, "Down limit");
        this.currentTerm = nextTerm(start - 1).intValue();
    }

    @Override
    public Number calculate() {
        long result = 0;

        while (this.currentTerm <= this.boundaryValue) {
            this.seriesText.append(this.currentTerm)
                    .append(" + ");

            result += this.currentTerm;

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
