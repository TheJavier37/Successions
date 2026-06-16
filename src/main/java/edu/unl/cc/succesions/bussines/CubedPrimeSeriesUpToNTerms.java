package edu.unl.cc.succesions.bussines;

/**
 * Representa la serie de primos elevados al cubo hasta N terminos
 * @author TheJavier37 (Javier Guarnizo)
 *
 */
public class CubedPrimeSeriesUpToNTerms extends TermBasedSuccession {

    public CubedPrimeSeriesUpToNTerms(Integer termsCount) {
        setLimit(termsCount);
        currentTerm = 0;
        printableTerms = new StringBuilder("S = ");
    }

    @Override
    public Number calculate() {
        long result = 0;
        int termsGenerated = 0;

        while (termsGenerated < this.finalTerm) {
            this.currentTerm = this.nextTerm(this.currentTerm).intValue();
            long cubedValue = (long) Math.pow(this.currentTerm, 3);

            this.printableTerms.append(this.currentTerm).append("^3").append(" + ");
            result += cubedValue;

            termsGenerated++;
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
