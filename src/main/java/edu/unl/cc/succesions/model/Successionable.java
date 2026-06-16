package edu.unl.cc.succesions.model;

/**
 * @author TheJavier37 (Javier Guarnizo)
 */
public interface Successionable {

    /**
     * Setter the limit of the succession
     * @param limit
     */
    void setLimit(Number limit);

    /**
     * Calculate the result. The main method in the succession
     * @return Number of the calculate result
     */
    Number calculate();

    /**
     * Generate the next term of the current term of the succession
     * @param current
     * @return Number the next term
     */
    Number nextTerm(Number current);
}
