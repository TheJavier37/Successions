package edu.unl.cc.succession.business;

import edu.unl.cc.succession.common.SuccessionBase;

/**
 * Serie 6
 * Representa la serie de numeros primos elevados a la raiz de numeros pares hasta un limite
 * S = 2^(1/2) + 3^(1/4) + 5^(1/6) + 7^(1/8) + ...
 * @author kisalo (Kiara Condoy)
 **/
public class PrimesEvenRootSumUpToLimit extends SuccessionBase {

    public PrimesEvenRootSumUpToLimit(boolean isPrime, Integer boundaryValue) {
        super(boundaryValue, isPrime);

        if (this.currentTerm < 2) {
            this.currentTerm = 2;
        }
    }

    @Override
    public Number calculate() {
        double sum = 0.0;
        int exponentDenominator = 2;
        final double exponentNumerator = 1.0;

        while (this.currentTerm <= this.boundaryValue) {

            double currentValue = Math.pow(this.currentTerm, exponentNumerator / exponentDenominator);

            if (sum > 0) {
                this.seriesText.append(" + ");
            }
            this.seriesText.append(this.currentTerm).append("^(")
                    .append((int)exponentNumerator).append("/")
                    .append(exponentDenominator).append(")");

            sum += currentValue;

            this.currentTerm = nextTerm(this.currentTerm).intValue();
            exponentDenominator += 2;
        }

        return sum;
    }

    @Override
    public Number nextTerm(Number current) {
        int value = current.intValue() + 1;
        while (!isPrime(value)) {
            value++;
        }
        return value;
    }
}