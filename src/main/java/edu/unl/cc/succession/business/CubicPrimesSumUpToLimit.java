package edu.unl.cc.succession.business;

import edu.unl.cc.succession.common.SuccessionBase;

/**
 * Serie 2
 * Representa la serie de numeros primos elevados al cubo hasta un limite de valor.
 * S = 1^3 + 2^3 + 3^3 + 5^3 + ... + N
 * @author TheJavier37 (Javier Guarnizo)
 *
 */
public class CubicPrimesSumUpToLimit extends SuccessionBase {

    /**
     * Constructor por defecto que inicializa la serie de primos desde el numero uno.
     *
     * @param limit El valor numerico maximo que puede alcanzar el resultado del cubo de un primo.
     */
    public CubicPrimesSumUpToLimit(Integer limit) {
        this(1, limit);
    }

    /**
     * Constructor sobrecargado que permite definir un valor inicial para la busqueda de primos.
     *
     * @param start El numero entero inicial desde el cual comenzara la secuencia prima.
     * @param limit El valor numerico maximo que puede alcanzar el resultado del cubo de un primo.
     */
    public CubicPrimesSumUpToLimit(Integer start, Integer limit) {
        start = validateInput(start, "Down limit");
        setLimit(limit);
        this.currentTerm = nextTerm(start - 1).intValue();
        this.seriesText = new StringBuilder("S = ");
    }

    /**
     * Realiza la iteracion y acumulacion de la suma de los primos elevados al cubo.
     * Controla el freno del bucle evaluando si la potencia resulta menor o igual a la frontera.
     *
     * @return El resultado total de la suma de las potencias cubicas.
     */
    @Override
    public Number calculate() {
        long result = 0;
        long cubedValue = (long) Math.pow(this.currentTerm, 3);
        while (cubedValue <= this.boundaryValue) {
            this.seriesText.append(this.currentTerm).append("^3").append(" + ");
            result += cubedValue;
            this.currentTerm = this.nextTerm(this.currentTerm).intValue();
            cubedValue = (long) Math.pow(this.currentTerm, 3);
        }
        return result;
    }

    /**
     * Evalua secuencialmente los siguientes numeros enteros para encontrar el proximo primo.
     * Utiliza el metodo de validacion centralizado en la clase madre para comprobar la primalidad.
     *
     * @param current El valor del primo actual.
     * @return El siguiente numero primo valido dentro del orden logico.
     */
    @Override
    public Number nextTerm(Number current) {
        current = current.intValue() + 1;
        if (current.intValue() == 1) {
            return current;
        }
        boolean isPrimeResult = false;
        while (!isPrimeResult) {
            isPrimeResult = isPrime(current.intValue());
            if (!isPrimeResult) {
                current = current.intValue() + 1;
            }
        }
        return current;
    }

    /**
     * Obtiene la representacion en cadena de texto de la serie cubica de primos generada.
     * Devuelve la secuencia de operaciones formateadas acumuladas en la clase base.
     *
     * @return Cadena de caracteres que representa visualmente el desarrollo matemático.
     */
    @Override
    public String print() {
        return super.print();
    }
}

