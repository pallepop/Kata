import java.util.ArrayList;
import java.util.List;

public class RomanNumeralConverter {
    static final private char[] IXCM = {'I', 'X', 'C', 'M'};
    static final private char[] VLD = {'V', 'L', 'D'};

    /**
     * Convert a complex integer into a roman number
     *
     * @param number Input number
     * @return Input number converted into roman number
     */
    public static String convert(int number) {

        if (number < 1 || number > 3999) {
            System.out.println("Error");
            return ("");
        } else {
            List<String> romanNumber;

            int[] numberDecomposed = decomposeNumber(number);

            romanNumber = convertEachElementIntoRomanNumber(numberDecomposed);

            return String.join("", romanNumber);
        }
    }

    /**
     * Decompose number into an integer array. For example, given 1548 it will output [1000,500,40,8]
     *
     * @param number Input number
     * @return An integer array of each element in the sum representing the input number
     */
    private static int[] decomposeNumber(int number) {
        int powerOfTen = getPowerOfTenOf(number);

        int[] decomposedNumberArray = new int[powerOfTen + 1];

        if (number < 10) {
            decomposedNumberArray[0] = number;
        } else {
            int numberTemp = number;
            for (int i = 0; i < decomposedNumberArray.length; i++) {
                decomposedNumberArray[i] = getIntPartOfNumberAtOrderN(numberTemp, powerOfTen - i);
                numberTemp -= decomposedNumberArray[i];
            }

        }
        return decomposedNumberArray;


    }

    /**
     * Convert each element of the list into roman number
     *
     * @param numberDecomposed Decomposed integer array
     * @return Integer list with elements converted to roman numbers
     */
    private static List<String> convertEachElementIntoRomanNumber(int[] numberDecomposed) {
        List<String> romanNumbers = new ArrayList<>();

        for (int j : numberDecomposed) {
            romanNumbers.add(convertIntoRomanNumber(j));
        }

        return romanNumbers;
    }

    /**
     * Find the power of ten of a given number
     *
     * @param number Input number
     * @return Power of ten of given number
     */
    private static int getPowerOfTenOf(int number) {
        int powerOfTen = 0;
        int comparator = 1;

        while (comparator < number) {
            powerOfTen++;
            comparator = (int) (1 * Math.pow(10, powerOfTen));
        }

        if (comparator != number) {
            powerOfTen -= 1;
        }

        return powerOfTen;
    }

    /**
     * Get the integer part of order n of a number.
     * For example, if given 957 as a number and 2 as an order, it will output 900
     *
     * @param number     Input number
     * @param powerOfTen Order desired
     * @return Integer part of order n of a number
     */
    private static int getIntPartOfNumberAtOrderN(int number, int powerOfTen) {
        return (int) (Math.floor(number / Math.pow(10, powerOfTen)) * Math.pow(10, powerOfTen));
    }

    /**
     * Convert simple number into roman number
     *
     * @return Input number converted into roman number
     */
    private static String convertIntoRomanNumber(int number) {

        int powerOfTen = getPowerOfTenOf(number);
        StringBuilder result = new StringBuilder();
        int nbOfIXCMSymbol;

        if (number == (4 * Math.pow(10, powerOfTen))) {
            result.append(IXCM[powerOfTen]);
            result.append(VLD[powerOfTen]);
            return result.toString();

        } else if (number == (9 * Math.pow(10, powerOfTen))) {
            result.append(IXCM[powerOfTen]);
            result.append(IXCM[powerOfTen + 1]);
            return result.toString();

        } else if (number < 5 * Math.pow(10, powerOfTen)) {
            nbOfIXCMSymbol = getFirstDigitOf(number);

        } else {
            result.append(VLD[powerOfTen]);
            nbOfIXCMSymbol = getFirstDigitOf(number) - 5;
        }

        result.append(String.valueOf(IXCM[powerOfTen]).repeat(Math.max(0, nbOfIXCMSymbol)));

        return result.toString();
    }

    /**
     * @param number Input number
     * @return The first digit of input number
     */
    private static int getFirstDigitOf(int number) {
        int powerOfTen = getPowerOfTenOf(number);
        return (int) (Math.floor(number / Math.pow(10, powerOfTen)));
    }
}
