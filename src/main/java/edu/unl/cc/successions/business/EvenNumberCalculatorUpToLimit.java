package edu.unl.cc.successions.business;

/**
 * Serie 1
 * Representa la serie de numeros pares hasta un limite
 * @author TheJavier37 (Javier Guarnizo)
 *
 */
public class EvenNumberCalculatorUpToLimit extends NumericLimitSuccession {

    public EvenNumberCalculatorUpToLimit(Integer limit) {
        this(0, limit);
    }

    public EvenNumberCalculatorUpToLimit(Integer start, Integer limit) {
        start = validateLimit(start, "Down limit");
        setLimit(limit);
        this.currentTerm = nextTerm(start).intValue();
        printableTerms = new StringBuilder("S = ");
    }

    @Override
    public Number calculate() {
        long result = 0;
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
