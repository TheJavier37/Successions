package edu.unl.cc.succession.business;

import edu.unl.cc.succession.common.SuccessionBase;

/**
 * Serie 5
 * Representa la serie de primos elevados a numeros impares hasta n terminos
 * S = 2^1 + 3^3 + 5^5 + 7^7 + 11^9 + ...
 * @author kisalo (Kiara Condoy)
 **/

public class PrimesOddPowerSumUpToNTerms extends SuccessionBase {

    public PrimesOddPowerSumUpToNTerms(boolean isPrime, Integer boundaryValue) {
        super(boundaryValue, isPrime);
    }

    @Override
    public Number calculate() {
        long result = 0;
        int terms = 0;
        int exponent = 1;
        while (terms < boundaryValue){
            this.seriesText.append(currentTerm).append("^")
                    .append(exponent).append(" + ");

            result += (long) Math.pow(currentTerm,exponent);
            currentTerm = nextTerm(currentTerm).intValue();
            exponent+=2;
            terms++;
        }
        return result;
    }

    @Override
    public Number nextTerm(Number current) {
        currentTerm = current.intValue() + 1;

        while (!isPrime(currentTerm)) {
            currentTerm++;
        }
        return currentTerm;
    }
}