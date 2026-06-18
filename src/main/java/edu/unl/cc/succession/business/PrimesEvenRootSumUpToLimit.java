package edu.unl.cc.succession.business;

import edu.unl.cc.succession.common.SuccessionBase;

/**
 * Serie 6
 * Representa la serie de numeros primos elevados a la raiz de numeros pares hasta un limite
 * S = 1^(1/2) + 3^(1/4) + 5^(1/6) + 7^(1/8) + ... + N
 * @author kisalo (Kiara Condoy)
 **/

public class PrimesEvenRootSumUpToLimit extends SuccessionBase {

    public PrimesEvenRootSumUpToLimit(boolean isPrime, Integer boundaryValue) {
        super(boundaryValue, isPrime);
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

        }

        return result;
    }

    @Override
    public Number nextTerm(Number current) {
        this.currentTerm = current.intValue() + 1;

        while (!isPrime(this.currentTerm)) {
            this.currentTerm++;
        }
        return this.currentTerm;
    }
}