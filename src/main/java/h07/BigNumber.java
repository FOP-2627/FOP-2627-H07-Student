package h07;

import org.tudalgo.algoutils.student.annotation.*;

/**
 * A class representing a large number using a linked list of bits.
 */
public class BigNumber {
    /**
     * The bit value of this node, if this is the root node it is the least
     * significant bit (LSB first).
     */
    @DoNotTouch
    public final boolean bit;
    /**
     * The next more significant bit in this number, must be null if its the most
     * significant bit of the number, ensuring no leading 0's exist in the number
     */
    @DoNotTouch
    public BigNumber nextBits;

    /**
     * Constructor creating a {@link BigNumber} node with a specified bit value.
     *
     * @param bit the bit value of this node
     */
    @DoNotTouch
    public BigNumber(boolean bit) {
        this.bit = bit;
        this.nextBits = null;
    }

    /**
     * Constructor creating a {@link BigNumber} node with a specified bit value
     * and a reference to the next more significant bit.
     *
     * @param bit      the bit value of this node
     * @param nextBits the next more significant bit in this number
     */
    @DoNotTouch
    public BigNumber(boolean bit, BigNumber nextBits) {
        this.bit = bit;
        this.nextBits = nextBits;
    }

    /**
     * helper function to get the bit at a specific index of a long value
     * used in the construction of a {@link BigNumber} value from a long value
     *
     * @param value the long value to get the bit from
     * @param index the index of the bit to get, 0 is the least significant bit
     * @return the bit at the specified index of the long value
     */
    @DoNotTouch
    private static boolean getBit(long value, int index) {
        return ((value >> index) & 1) != 0;
    }

    /**
     * generates a {@link BigNumber} value from a long value, the msb of the long
     * value will be the msb of the generated {@link BigNumber} value
     * ensuring no leading 0's exist in the generated {@link BigNumber} value
     *
     * @param value the long value to convert
     * @return the generated {@link BigNumber} value
     */
    @DoNotTouch
    public static BigNumber fromLong(long value) {
        int indexOfValueMSB = 63;
        while (indexOfValueMSB >= 0 && !getBit(value, indexOfValueMSB)) {
            indexOfValueMSB--;
        }
        BigNumber bigNumber = null;
        for (int i = indexOfValueMSB; i >= 0; i--) {
            bigNumber = new BigNumber(getBit(value, i), bigNumber);
        }
        return bigNumber;
    }

    /**
     * Converts this {@link BigNumber} value to a long value.
     *
     * @return the long value representing the number
     * @implNote This method assumes that the {@link BigNumber} value can be
     *           represented within the range of a long. If the value exceeds this
     *           range, the result may be incorrect.
     */
    @DoNotTouch
    public long toLong() {
        long result = 0;
        int position = 0;
        BigNumber iter = this;
        while (iter != null) {
            if (iter.bit) {
                result |= (1L << position);
            }
            iter = iter.nextBits;
            position++;
        }
        return result;
    }

    /**
     * Adds two {@link BigNumber} values recursively.
     *
     * @param other the second number
     * @return the sum of the two numbers
     */
    @StudentImplementationRequired("H7.2.1")
    public BigNumber addRecursive(BigNumber other) {
        // TODO: H7.2.1
        return org.tudalgo.algoutils.student.Student.crash("H7.2.1 - Remove if implemented");
    } 

    /**
     * Adds two {@link BigNumber} values iteratively.
     *
     * @param other the second number
     * @return the sum of the two numbers
     */
    @StudentImplementationRequired("H7.2.2")
    public BigNumber addIterative(BigNumber other) {
        // TODO: H7.2.2
        return org.tudalgo.algoutils.student.Student.crash("H7.2.2 - Remove if implemented");
    } 

    /**
     * Multiplies two {@link BigNumber} values recursively, using the
     * shift-and-add method.
     *
     * @param other the number to multiply with
     * @return the product of the two numbers
     */
    @StudentImplementationRequired("H7.2.3")
    public BigNumber multiplyRecursive(BigNumber other) {
        // TODO: H7.2.3
        return org.tudalgo.algoutils.student.Student.crash("H7.2.3 - Remove if implemented");
    } 

    /**
     * Multiplies two {@link BigNumber} values iteratively, using the
     * shift-and-add method.
     *
     * @param other the number to multiply with
     * @return the product of the two numbers
     */
    @StudentImplementationRequired("H7.2.4")
    public BigNumber multiplyIterative(BigNumber other) {
        // TODO: H7.2.4
        return org.tudalgo.algoutils.student.Student.crash("H7.2.4 - Remove if implemented");
    } 

    /**
     * Raises the current {@link BigNumber} value to the power of the specified
     * exponent.
     *
     * @param exponent the exponent to raise the base to
     * @return the result of raising the base to the power of the exponent
     */
    @DoNotTouch
    public BigNumber pow(BigNumber exponent) {
        BigNumber base = this;
        BigNumber result = new BigNumber(true); // Initialize result as 1

        BigNumber expIter = exponent;

        while (expIter != null) {
            if (expIter.bit) {
                result = result.multiplyIterative(base);
            }
            base = base.multiplyIterative(base);
            expIter = expIter.nextBits;
        }

        return result;
    }

    /**
     * Evaluates a polynomial with arbitrary coefficients and exponents at the
     * current {@link BigNumber} value.
     *
     * @param coefficients an array of {@link BigNumber} representing the
     *                     coefficients of the polynomial
     * @param exponents    an array of {@link BigNumber} representing the
     *                     exponents of the polynomial
     * @return a {@link BigNumber} representing the evaluated result of the
     *         polynomial
     */
    @StudentImplementationRequired("H7.2.5")
    public BigNumber evaluateArbitraryPolynomial(BigNumber[] coefficients, BigNumber[] exponents) {
        // TODO: H7.2.5
        return org.tudalgo.algoutils.student.Student.crash("H7.2.5 - Remove if implemented");
    } 

    /**
     * Returns a string representation of the {@link BigNumber} value in binary
     * format, along with its decimal equivalent.
     * This may be useful for debugging and visualization purposes.
     */
    @DoNotTouch
    @Override
    public String toString() {
        return Utils.n9lToBinaryString(this) + " (decimal: " + Utils.n9lToDecimalString(this) + ")";
    }
}
