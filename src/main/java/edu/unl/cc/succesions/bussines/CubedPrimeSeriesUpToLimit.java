package edu.unl.cc.succesions.bussines;

/**
 * Representa la serie de primos elevados al cubo hasta un limite
 * @author TheJavier37 (Javier Guarnizo)
 *
 */
public class CubedPrimeSeriesUpToLimit extends NumericLimitSuccession {

    public CubedPrimeSeriesUpToLimit(Integer limit) {
        setLimit(limit);
        currentTerm = 0;
        printableTerms = new StringBuilder("S = ");
    }

    @Override
    public Number calculate() {
        long result = 0;
        this.currentTerm = this.nextTerm(this.currentTerm).intValue();
        long cubedValue = (long) Math.pow(this.currentTerm, 3);
        while (cubedValue <= this.limit) {
            this.printableTerms.append(this.currentTerm).append("^3").append(" + ");
            result += cubedValue;
            this.currentTerm = this.nextTerm(this.currentTerm).intValue();
            cubedValue = (long) Math.pow(this.currentTerm, 3);
        }
        return result;
    }

    @Override
    public Number nextTerm(Number current) {
        int next = current.intValue();
        if (next == 0) {
            return 1;
        }
        if (next == 1) {
            return 2;
        }
        next++;
        while (!isPrime(next)) {
            next++;
        }
        return next;
    }

    private boolean isPrime(int number) {
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