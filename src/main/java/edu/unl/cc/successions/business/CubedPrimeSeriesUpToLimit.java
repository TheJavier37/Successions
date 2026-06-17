package edu.unl.cc.successions.business;

/**
 * Representa la serie de primos elevados al cubo hasta un limite
 * @author TheJavier37 (Javier Guarnizo)
 *
 */
public class CubedPrimeSeriesUpToLimit extends NumericLimitSuccession {

    public CubedPrimeSeriesUpToLimit(Integer limit) {
        this(1, limit);
    }

    public CubedPrimeSeriesUpToLimit(Integer start, Integer limit) {
        start = validateLimit(start, "Down limit");
        setLimit(limit);
        this.currentTerm = nextTerm(start - 1).intValue();
        printableTerms = new StringBuilder("S = ");
    }

    @Override
    public Number calculate() {
        long result = 0;
        long cubedValue = (long) Math.pow(currentTerm, 3);
        while (cubedValue <= limit) {
            this.printableTerms.append(currentTerm).append("^3").append(" + ");
            result += cubedValue;
            currentTerm = this.nextTerm(currentTerm).intValue();
            cubedValue = (long) Math.pow(currentTerm, 3);
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
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}