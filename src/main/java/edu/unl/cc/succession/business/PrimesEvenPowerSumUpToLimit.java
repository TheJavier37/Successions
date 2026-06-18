package edu.unl.cc.succession.business;

import edu.unl.cc.succession.common.SuccessionBase;

/**
 * Serie 4
 * Representa la serie de primos elevados a potencias pares hasta un limite
 * S = 1^2 + 3^4 + 5^6 + 7^8 + 11^10 + ... + N
 * @author Dario "Monao" Chillogallo, Kisalo, TheJavier37, JsValencia, Domenica Naravez
 *
 */
public class PrimesEvenPowerSumUpToLimit extends SuccessionBase {


    public PrimesEvenPowerSumUpToLimit(Integer boundaryValue) {
        super(boundaryValue);
    }

    public PrimesEvenPowerSumUpToLimit(Integer start, Integer boundaryValue) {
        super(start, boundaryValue);

        if (this.currentTerm < 2){
            this.currentTerm = 2;
        }
    }

    @Override
    public Number calculate() {
        long result = 0;
        int exponent = 2;

        //Calculo del currentTerm (termino actual)
        long powerValue = (long)Math.pow(this.currentTerm,exponent);

        while (powerValue <= boundaryValue){
            this.seriesText.append(this.currentTerm).
                    append(" ^ ").
                    append(exponent).
                    append(" + ");
            
            result += powerValue;

            this.currentTerm = nextTerm(this.currentTerm).intValue();
            exponent += 2;

            powerValue = (long)Math.pow(this.currentTerm, exponent);
        }
        return result;
    }

    @Override
    public Number nextTerm(Number current) {
        int nextPrimeTerm = current.intValue() + 1;

        while(!isPrime(nextPrimeTerm)){
            nextPrimeTerm ++;
        }
        return nextPrimeTerm;
    }
}
