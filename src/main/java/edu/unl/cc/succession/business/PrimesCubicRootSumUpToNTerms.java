package edu.unl.cc.succession.business;

import edu.unl.cc.succession.common.SuccessionBase;

/**
 * 8. Representa el cálculo de la Serie de primos elevados a la raiz cúbica hasta un n términos
 * (S = 1^(1/3) + 3^(1/3) + 5^(1/3) + 7^(1/3) + 11^(1/3) + 13^(1/3) =)
 * @author Domenica Narvaez
 */

public class PrimesCubicRootSumUpToNTerms extends SuccessionBase {

    public PrimesCubicRootSumUpToNTerms(Integer boundaryValue) {
        super(boundaryValue);
    }

    public PrimesCubicRootSumUpToNTerms(Integer start, Integer boundaryValue) {
        super(start, boundaryValue);
    }

    @Override
    public Number calculate() {
        this.currentTerm = nextTerm(this.currentTerm).intValue();
        double result = 0;
        int countTerm = 0;

        while (countTerm < boundaryValue) {
            this.seriesText
                    .append(currentTerm)
                    .append("^(1/3) + ");
            result += Math.pow(currentTerm, 1.0 / 3);
            currentTerm = nextTerm(currentTerm).intValue();
            countTerm++;
        }
        this.seriesText.append("= ").append(result);
        return result;
    }

    @Override
    public Number nextTerm(Number current) {
        int next = current.intValue() + 1;
        while (!isPrime(next)) {
            next++;
        }
        return next;
    }
}
