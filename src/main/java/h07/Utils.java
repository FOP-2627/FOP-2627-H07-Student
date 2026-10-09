package h07;

import java.util.ArrayList;
import org.tudalgo.algoutils.student.annotation.*;

/**
 * A utility class providing methods to convert BigNumber instances to their
 * binary and decimal string representations.
 */
@DoNotTouch
public class Utils {
    /**
     * Converts a BigNumber instance to its binary string representation.
     *
     * @param number the BigNumber instance to convert
     * @return the binary string representation
     */
    public static String n9lToBinaryString(BigNumber number) {
        BigNumber iter = number;
        StringBuilder sb = new StringBuilder();
        while (iter != null) {
            sb.append(iter.bit ? '1' : '0');
            iter = iter.nextBits;
        }
        return sb.reverse().toString();
    }

    /**
     * Converts a BigNumber instance to its decimal string representation.
     * using the double-and-add method for binary to decimal conversion.
     *
     * @param number the BigNumber instance to convert
     * @return the decimal string representation
     * @implNote This method is sub optimal as it uses the actual string to
     *           represent the decimal number and do the conversion, however
     *           BigNumber is not designed to handle decimal numbers, and does
     *           not provide long division for modulus operations required for
     *           decimal conversions. Therefore this method provides a workaround to
     *           convert the binary representation to decimal without relying on
     *           BigNumber's internal representation.
     */
    public static String n9lToDecimalString(BigNumber number) {
        if (number == null) {
            return "0";
        }

        // Convert the linked list into a standard array or list to read from MSB to LSB
        ArrayList<Boolean> bits = new java.util.ArrayList<>();
        BigNumber iter = number;
        while (iter != null) {
            bits.add(iter.bit);
            iter = iter.nextBits;
        }

        String decimalStr = "0";

        // Double-and-Add from Most Significant Bit to Least Significant Bit
        for (int i = bits.size() - 1; i >= 0; i--) {
            decimalStr = doubleDecimalString(decimalStr);
            if (bits.get(i)) {
                decimalStr = addOneToDecimalString(decimalStr);
            }
        }

        return decimalStr;
    }

    /**
     * Helper method to double a string representation of a decimal number.
     *
     * @param s string representation of a decimal number
     * @return string representation of the doubled decimal number
     */
    private static String doubleDecimalString(String s) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int digit = (s.charAt(i) - '0') * 2 + carry;
            sb.append(digit % 10);
            carry = digit / 10;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    /**
     * Helper method to add one to a string representation of a decimal number.
     *
     * @param s string representation of a decimal number
     * @return string representation of the decimal number after adding one
     */
    private static String addOneToDecimalString(String s) {
        StringBuilder sb = new StringBuilder();
        int carry = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int digit = (s.charAt(i) - '0') + carry;
            sb.append(digit % 10);
            carry = digit / 10;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
