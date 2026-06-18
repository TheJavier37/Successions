package edu.unl.cc.succession.business;

import edu.unl.cc.succession.common.SuccessionBase;

/**
 * Serie 1
 * Representa la serie de numeros pares hasta un limite de valor.
 * S = 2 + 4 + 6 + 8 + ... + N
 * @author TheJavier37 (Javier Guarnizo)
 */
public class EvenNumberCalculatorUpToLimit extends SuccessionBase {

    public EvenNumberCalculatorUpToLimit(Integer start, Integer limit) {
        super(0,limit);
        start = validateInput(start, "Down limit");
        this.currentTerm = nextTerm(start).intValue();
    }

    @Override
    public Number calculate() {
        long result = 0;
        while (this.currentTerm <= this.boundaryValue) {
            this.seriesText.append(this.currentTerm).append(" + ");
            result += this.currentTerm;
            this.currentTerm = this.nextTerm(this.currentTerm).intValue();
        }
        return result;
    }

    @Override
    public Number nextTerm(Number current) {
        return current.intValue() + 2;
    }

}