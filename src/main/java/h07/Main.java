package h07;

/**
 * Main entry point in executing the program.
 */
public class Main {
    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(String[] args) {

        // remove all this for the final submission, this is just for testing purposes
        BigNumber a = BigNumber.fromLong(111);
        BigNumber b = BigNumber.fromLong(37);
        System.out.println("a: " + a);
        System.out.println("b: " + b);

        BigNumber sum = a.addRecursive(b);
        System.out.println("Sum (recursive): " + sum);
        BigNumber sum_it = a.addIterative(b);
        System.out.println("Sum (iterative): " + sum_it);

        BigNumber product = a.multiplyIterative(b);
        System.out.println("Product (iterative): " + product);
        BigNumber product_rec = a.multiplyRecursive(b);
        System.out.println("Product (recursive): " + product_rec);

        BigNumber fastexp = a.pow(b);
        System.out.println("Fast exponentiation (iterative): " + fastexp);

        BigNumber[] coefficients = {
                BigNumber.fromLong(1), // Coefficient for x^0
                BigNumber.fromLong(2), // Coefficient for x^1
                BigNumber.fromLong(3) // Coefficient for x^2
        };
        BigNumber[] exponents = {
                BigNumber.fromLong(0), // Exponent for x^0
                BigNumber.fromLong(1), // Exponent for x^1
                BigNumber.fromLong(2) // Exponent for x^2
        };

        BigNumber polynomialResult = a.evaluateArbitraryPolynomial(coefficients, exponents);
        System.out.println("Polynomial evaluation result: " + polynomialResult);
    }
}
