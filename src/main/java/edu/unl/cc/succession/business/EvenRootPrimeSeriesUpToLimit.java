package edu.unl.cc.succession.business;

/**
 * Serie 6
 * Representa la serie de primos elevados a la raiz de numeros pares hasta un limite
 * S = 1^(1/2) + 3^(1/4) + 5^(1/6) + 7^(1/8) + ... + N
 * @author TheJavier37 (Javier Guarnizo)
 *
 */
public class EvenRootPrimeSeriesUpToLimit extends NumericLimitSuccession {

    private Integer currentDenominator;

    public EvenRootPrimeSeriesUpToLimit(Integer limit) {
        this(1, limit);
    }

    public EvenRootPrimeSeriesUpToLimit(Integer start, Integer limit) {
        start = validateLimit(start, "Down limit");
        setLimit(limit);
        this.currentTerm = nextTerm(start - 1).intValue();
        this.currentDenominator = 2;
        this.printableTerms = new StringBuilder("S = ");
    }

    @Override
    public Number calculate() {
        long result = 0;
        double exponent = 1.0 / this.currentDenominator;
        long rootedValue = (long) Math.pow(this.currentTerm, exponent);

        while (rootedValue <= this.limit) {
            this.printableTerms.append(this.currentTerm)
                    .append("^(1/")
                    .append(this.currentDenominator)
                    .append(") + ");

            result += rootedValue;

            this.currentTerm = this.nextTerm(this.currentTerm).intValue();
            this.currentDenominator += 2;

            exponent = 1.0 / this.currentDenominator;
            rootedValue = (long) Math.pow(this.currentTerm, exponent);
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