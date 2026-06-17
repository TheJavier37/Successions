package edu.unl.cc.successions.bussines;

/**
 * Representa la serie de numeros pares hasta un limite
 * @author TheJavier37 (Javier Guarnizo)
 *
 */
public class EvenNumberCalculatorUpToLimit extends NumericLimitSuccession {

    public EvenNumberCalculatorUpToLimit(Integer limit) {
        setLimit(limit);
        currentTerm = 0;
        printableTerms = new StringBuilder("S = ");
    }

    @Override
    public Number calculate() {
        long result = 0;
        this.currentTerm = this.nextTerm(this.currentTerm).intValue();
        while (currentTerm <= this.limit) {
            this.printableTerms.append(this.currentTerm).append(" + ");
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
