import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RomanNumeralConverterTest {

    @Test
    public void convert_1_Into_I() {
        // Given
        int input = 1;

        // When
        String result = RomanNumeralConverter.convert(input);

        // Then
        assertThat(result).isEqualTo("I");
    }

    @Test
    public void convert_49_Into_XLIX() {
        // Given
        int input = 49;

        // When
        String result = RomanNumeralConverter.convert(input);

        // Then
        assertThat(result).isEqualTo("XLIX");
    }

    @Test
    public void convert_99_Into_XCIX() {
        // Given
        int input = 99;

        // When
        String result = RomanNumeralConverter.convert(input);

        // Then
        assertThat(result).isEqualTo("XCIX");
    }

    @Test
    public void convert_999_Into_CMXCIX() {
        // Given
        int input = 999;

        // When
        String result = RomanNumeralConverter.convert(input);

        // Then
        assertThat(result).isEqualTo("CMXCIX");
    }

    @Test
    public void convert_1444_Into_MCDXLIV() {
        // Given
        int input = 1444;

        // When
        String result = RomanNumeralConverter.convert(input);

        // Then
        assertThat(result).isEqualTo("MCDXLIV");
    }

    @Test
    public void convert_2888_Into_MMDCCCLXXXVIII() {
        // Given
        int input = 2888;

        // When
        String result = RomanNumeralConverter.convert(input);

        // Then
        assertThat(result).isEqualTo("MMDCCCLXXXVIII");
    }

    @Test
    public void convert_2999_Into_MMCMXCIX() {
        // Given
        int input = 2999;

        // When
        String result = RomanNumeralConverter.convert(input);

        // Then
        assertThat(result).isEqualTo("MMCMXCIX");
    }

    @Test
    public void convert_3999_Into_MMMCMXCIX() {
        // Given
        int input = 3999;

        // When
        String result = RomanNumeralConverter.convert(input);

        // Then
        assertThat(result).isEqualTo("MMMCMXCIX");
    }

    @Test
    public void inputLesserThan0ShouldFail() {
        // Given
        int input = -1;

        // When
        String result = RomanNumeralConverter.convert(input);

        // Then
        assertThat(result).isEqualTo("");
    }

    @Test
    public void inputGreaterThan3999ShouldFail() {
        // Given
        int input = 4000;

        // When
        String result = RomanNumeralConverter.convert(input);

        // Then
        assertThat(result).isEqualTo("");
    }


}