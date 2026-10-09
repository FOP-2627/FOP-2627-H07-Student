package h07;

import org.tudalgo.algoutils.student.annotation.*;

/**
 * A class implementing basic calculations used to approximate the value of e
 * and calculate factorials.
 */
public class Calculations {
    /**
     * Calculates the factorial of a given value recursively.
     *
     * @param value the value to calculate the factorial for
     * @return the factorial of the given value
     */
    @StudentImplementationRequired("H7.1.1")
    public static long factorial(long value) {
        // TODO: H7.1.1
        return org.tudalgo.algoutils.student.Student.crash("H7.1.1 - Remove if implemented");
    } 

    /**
     * Calculates the nth power of x, where n is an integer.
     * @param x the number to calculate the power of
     * @param n the degree of the power
     * @return the nth power of x
     */
    @DoNotTouch
    private static double pow(double x, int n) {
        double result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }

    /**
     * Approximates the exponential function with precision n using a series expansion.
     *
     * @param x the argument of the exponential function
     * @param n the number of terms to include in the approximation
     * @return the approximate value of e
     */
    @StudentImplementationRequired("H7.1.2")
    public static double approxExp(double x, int n) {
        // TODO: H7.1.2
        return org.tudalgo.algoutils.student.Student.crash("H7.1.2 - Remove if implemented");
    } 

    /**
     * Approximates the xth power of a.
     *
     * @param a the number to approximate the power of
     * @param x the degree of the power
     * @param n the precision of the approximation
     * @return approximation of the xth power of a
     */
    @StudentImplementationRequired("H7.1.3")
    public static double extendedPow(double a, double x, int n) {
        // TODO: H7.1.3
        return org.tudalgo.algoutils.student.Student.crash("H7.1.3 - Remove if implemented");
    } 

}
