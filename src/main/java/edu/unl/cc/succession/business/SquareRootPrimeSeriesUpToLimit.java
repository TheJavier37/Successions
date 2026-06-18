package edu.unl.cc.succession.business;

/**
 * Serie 9
 * Representa la serie de primos elevados a la raiz cuadrada hasta un limite.
 * S = 1^(1/2) + 3^(1/2) + 5^(1/2) + 7^(1/2) + 11^(1/2) + 13^(1/2) + ... + N^(1/2)
 * @author js_valencia (Jose Valencia)
 */
public class SquareRootPrimeSeriesUpToLimit extends NumericLimitSuccession {

    public SquareRootPrimeSeriesUpToLimit(Integer limit) {
        this(1, limit);
    }

    public SquareRootPrimeSeriesUpToLimit(Integer start, Integer limit) {
        start = validateLimit(start, "Down limit");
        setLimit(limit);
        this.currentTerm = nextTerm(start - 1).intValue();
        this.printableTerms = new StringBuilder("S = ");
    }

    @Override
    public Number calculate() {
        double result = 0;

        while (this.currentTerm <= this.limit) {
            double rootedValue = Math.sqrt(this.currentTerm);
            this.printableTerms.append(this.currentTerm)
                    .append("^(1/2) + ");

            result += rootedValue;

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
