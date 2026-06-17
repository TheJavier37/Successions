package edu.unl.cc.successions.business;


/**
 * Serie 5
 * Representa la serie de primos elevados a impares hasta n terminos
 * S = 1^1 + 3^3 + 5^5 + 7^7 + 11^9 + ...
 * @author TheJavier37 (Javier Guarnizo)
 *
 */
public class OddPoweredPrimeSeriesUpToNTerms extends TermBasedSuccession {

    private Integer currentExponent;

    public OddPoweredPrimeSeriesUpToNTerms(Integer termsCount) {
        this(1, termsCount);
    }

    public OddPoweredPrimeSeriesUpToNTerms(Integer start, Integer termsCount) {
        start = validateLimit(start, "Down limit");
        setLimit(termsCount);
        this.currentTerm = nextTerm(start - 1).intValue();
        this.currentExponent = 1;
        this.printableTerms = new StringBuilder("S = ");
    }

    @Override
    public Number calculate() {
        long result = 0;
        int termsGenerated = 0;

        while (termsGenerated < this.finalTerm) {
            long poweredValue = (long) Math.pow(this.currentTerm, this.currentExponent);

            this.printableTerms.append(this.currentTerm)
                    .append("^")
                    .append(this.currentExponent)
                    .append(" + ");

            result += poweredValue;

            this.currentTerm = this.nextTerm(this.currentTerm).intValue();
            this.currentExponent += 2;

            termsGenerated++;
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
