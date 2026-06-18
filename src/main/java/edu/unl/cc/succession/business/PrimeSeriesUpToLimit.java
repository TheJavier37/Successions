package edu.unl.cc.succession.business;
import edu.unl.cc.succession.common.SuccessionBase;

/**
 * Serie 10
 * Representa la serie de primos hasta un limite.
 * S = 1 + 2 + 3 + 5 + 7 + 11 + 13 + ... + N
 * @author js_valencia (Jose Valencia)
 *
 */
public class PrimeSeriesUpToLimit extends NumericLimitSuccession {

    public PrimeSeriesUpToLimit(Integer limit) {
        this(1, limit);
    }

    public PrimeSeriesUpToLimit(Integer start, Integer limit) {
        start = validateLimit(start, "Down limit");
        setLimit(limit);
        this.currentTerm = nextTerm(start - 1).intValue();
        this.printableTerms = new StringBuilder("S = ");
    }

    @Override
    public Number calculate() {
        long result = 0;
        while (this.currentTerm <= this.limit) {
            this.printableTerms.append(this.currentTerm)
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

    private boolean isPrime(Integer number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
