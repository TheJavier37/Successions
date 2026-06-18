package edu.unl.cc.succession.business;

import edu.unl.cc.succession.common.SuccessionBase;

/**
 * Serie 6
 * Representa la serie de numeros primos elevados a la raiz de numeros pares hasta un limite
 * S = 1^(1/2) + 3^(1/4) + 5^(1/6) + 7^(1/8) + ... + N
 * @author kisalo (Kiara Condoy)
 **/

public class EvenRootPrimeSeriesUpToLimit extends SuccessionBase {

    @Override
    protected Integer validateInput(Number value, String label) {
        return super.validateInput(value, label);
    }

    @Override
    protected boolean isPrime(Integer number) {
        return super.isPrime(number);
    }

    @Override
    public void setLimit(Number limit) {
        super.setLimit(limit);
    }

    @Override
    public Number calculate() {
        long result = 0;
        int exponentDenominator = 2;
        final double exponentNumerator = 1;
        double currentValue =  Math.pow(nextTerm(1).intValue(), exponentNumerator/exponentDenominator);

        while (currentValue<boundaryValue){
            this.seriesText.append(currentTerm).append("^(")
                    .append(exponentNumerator).append("/")
                    .append(exponentDenominator).append(" + ");

            result += (long)currentValue;
            currentTerm = nextTerm(currentTerm).intValue();
            exponentDenominator += 2;
            currentValue = Math.pow(currentTerm,exponentNumerator/exponentDenominator);

            if (seriesText.length() >= 3) {
                seriesText.setLength(seriesText.length() - 3);
            }
        }

        return result;
    }

    /**
     * Method that calculates the next prime number (the base number) for the succession
     * @param current inicial term
     * @return next term
     */
    @Override
    public Number nextTerm(Number current) {
        this.currentTerm = current.intValue() + 1;

        while (!isPrime(this.currentTerm)) {
            this.currentTerm++;
        }
        return this.currentTerm;
    }

    @Override
    public String print() {
        return this.seriesText.toString();
    }
}