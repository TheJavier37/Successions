package edu.unl.cc.succession.business;

import edu.unl.cc.succession.common.SuccessionBase;

/**
 * Serie 1
 * Representa la serie de numeros pares hasta un limite de valor.
 * S = 2 + 4 + 6 + 8 + ... + N
 * @author TheJavier37 (Javier Guarnizo)
 */
public class EvenNumberCalculatorUpToLimit extends SuccessionBase {

    /**
     * Constructor por defecto que inicializa la serie de numeros pares desde cero.
     * @param limit El valor maximo permitido para los terminos de la serie.
     */
    public EvenNumberCalculatorUpToLimit(Integer limit) {
        this(0, limit);
    }

    /**
     * Constructor sobrecargado que permite definir el punto de inicio de la serie.
     * @param start El valor entero desde donde comenzara a buscarse el primer termino.
     * @param limit El valor maximo permitido para los terminos de la serie.
     */
    public EvenNumberCalculatorUpToLimit(Integer start, Integer limit) {
        super();
        start = validateInput(start, "Down limit");
        setLimit(limit);
        this.currentTerm = nextTerm(start).intValue();
        this.seriesText = new StringBuilder("S = ");
    }

    /**
     * Realiza el bucle de calculo sumando los numeros pares de la secuencia.
     * El proceso se detiene cuando el termino actual supera el valor frontera establecido.
     * @return La suma acumulada de todos los terminos validos generados.
     */
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

    /**
     * Calcula analiticamente cual es el siguiente numero par consecutivo.
     * @param current El termino par actual sobre el cual se calculara el siguiente.
     * @return El numero entero par inmediatamente posterior.
     */
    @Override
    public Number nextTerm(Number current) {
        return current.intValue() + 2;
    }

    /**
     * Obtiene la representacion en cadena de texto de la serie de numeros pares generada.
     * Extrae de forma directa el contenido acumulado en el buffer local.
     * @return Cadena de texto que detalla los terminos de la sucesion.
     */
    @Override
    public String print() {
        return this.seriesText != null ? this.seriesText.toString() : "";
    }
}