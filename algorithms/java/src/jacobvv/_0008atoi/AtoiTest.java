package jacobvv._0008atoi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AtoiTest {

    private String[] inputs = new String[]{
            "42",
            "         -42 32",
            "4193 with words",
            "words and 987",
            "-91283472332",
            "-002147483648",
            "       -2147483647   ",
            "   2147483647eeea",
            "0002147483646我去",
            "+0 555",
            "  +887 -34",
            "  000 +3",
            "123 -456",
            "+",
            "-  555"
    };
    private int[] outputs = new int[]{42, -42, 4193, 0, -2147483648, -2147483648, -2147483647, 2147483647, 2147483646,
            0, 887, 0, 123, 0, 0};

    @Test
    void atoiTest() {
        Atoi target = new Atoi();
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(outputs[i], target.atoi(inputs[i]), "Source string is: \"" + inputs[i] + "\"");
        }
    }

}