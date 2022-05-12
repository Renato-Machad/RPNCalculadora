import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryNumberTest {

    @Test
    public void integerToString() {
        //Arrange
        int value = 5;
        String valueEmBinário = "101";

        //Act
        String binario = Integer.toBinaryString(value);

        //Assert
        assertEquals(binario, valueEmBinário);
    }

    @Test
    public void stringToInteger() {
    }

    @Test
    public void getValueDecimal() {
    }
}