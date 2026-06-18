package edu.unl.cc.succession.business;

import edu.unl.cc.succession.common.SuccessionBase;

/**
 * Serie 5
 * Representa la serie de primos elevados a numeros impares hasta n terminos
 * S = 1^1 + 3^3 + 5^5 + 7^7 + 11^9 + ...
 * @author kisalo (Kiara Condoy)
 **/

public class PrimesOddPowerSumUpToNTerms extends SuccessionBase {

    public PrimesOddPowerSumUpToNTerms(Integer boundaryValue) {
        super(boundaryValue);
    }

    @Override
    public Number calculate() {
        long result = 0;
        int terms = 0;
        int exponent = 1;
        currentTerm = 1;
        while (terms < boundaryValue){
            this.seriesText.append(currentTerm).append("^")
                    .append(exponent);
                    if (terms < boundaryValue - 1) {
                        seriesText.append(" + ");
                    }
            result += (long) Math.pow(currentTerm,exponent);
            currentTerm = nextTerm(currentTerm).intValue();
            exponent+=2;
            terms++;
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