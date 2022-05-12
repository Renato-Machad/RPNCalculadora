import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryNumberTest {

    @Test
    public void integerToString() {
        //Arrange
        int value = 5;
        String valueString = String.valueOf(value); // "5"
        String valueEmBinário = "101";

        //Act
        BinaryNumber binaryNumber = new BinaryNumber(valueString);
        GeneralNumber binaryNumber1 = binaryNumber.integerToString(value);


        //Assert
        assertEquals(binaryNumber1, valueEmBinário);
    }

    @Test
    public void getValueDecimal() {
        //Arrange
        GeneralNumber decimal = new DecimalNumber(5);

        //Act
        decimal.getValueDecimal(decimal);

        //Assert
        assertEquals(decimal, decimal.getValueDecimal(decimal));
    }
}