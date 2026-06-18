package edu.unl.cc.succession.business;

import edu.unl.cc.succession.common.SuccessionBase;

/**
 * Serie 3:
 *  Serie de primos elevados al cubo  hasta N términos
 *  (S = 1^3 + 3^3 + 5^3 + 7^3 + 11^3 + 13^3 ...):
 * @author Dario "Monao" Chillogallo, Kisalo, TheJavier37, JsValencia, Domenica Naravez
 */

public class CubicPrimesSumUpToNTerms extends SuccessionBase {

    public CubicPrimesSumUpToNTerms(Integer start, Integer boundaryValue) {
        super(start, boundaryValue);

        if(this.currentTerm < 2){
            this.currentTerm = 2;
        }
    }

    public CubicPrimesSumUpToNTerms(Integer boundaryValue) {
        super(boundaryValue);
    }

    /**
     * method that calculates the sum of the entire serie and create the string:
     * @return result
     */
    @Override
    public Number calculate() {
        long result = 0;
        int termsCount = 0;
        final int exponent = 3;

        while (termsCount < boundaryValue){
            this.seriesText.append(this.currentTerm).append(" ^ ").
                    append(exponent).
                    append(" + ");
            result += (long)Math.pow(this.currentTerm,exponent);
            this.currentTerm = nextTerm(currentTerm).intValue();
            termsCount ++;
        }
        return result;
    }

    /**
     *Method that calculates the next base number (prime number)
     * @param current initial term
     * @return next term
     */
    @Override
    public Number nextTerm(Number current) {
        int nextTerm = current.intValue() + 1;

        while (!isPrime(nextTerm)){
            nextTerm++;
        }
        return nextTerm;
    }
}
