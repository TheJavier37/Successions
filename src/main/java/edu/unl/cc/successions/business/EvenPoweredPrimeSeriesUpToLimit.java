package edu.unl.cc.successions.business;

/**
 * Serie 4
 * Representa la serie de primos elevados a potencias pares hasta un limite
 * S = 1^2 + 3^4 + 5^6 + 7^8 + 11^10 + ... + N
 * @author TheJavier37 (Javier Guarnizo)
 *
 */
public class EvenPoweredPrimeSeriesUpToLimit extends NumericLimitSuccession {

    private Integer currentExponent;

    public EvenPoweredPrimeSeriesUpToLimit(Integer limit) {
        this(1, limit);
    }

    public EvenPoweredPrimeSeriesUpToLimit(Integer start, Integer limit) {
        start = validateLimit(start, "Down limit");
        setLimit(limit);
        this.currentTerm = nextTerm(start - 1).intValue();
        this.currentExponent = 2;
        this.printableTerms = new StringBuilder("S = ");
    }

    @Override
    public Number calculate() {
        long result = 0;
        long poweredValue = (long) Math.pow(this.currentTerm, this.currentExponent);

        while (poweredValue <= this.limit) {
            this.printableTerms.append(this.currentTerm)
                    .append("^")
                    .append(this.currentExponent)
                    .append(" + ");

            result += poweredValue;

            this.currentTerm = this.nextTerm(this.currentTerm).intValue();
            this.currentExponent += 2;

            poweredValue = (long) Math.pow(this.currentTerm, this.currentExponent);
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
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
