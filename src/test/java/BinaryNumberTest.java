import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryNumberTest {

    @Test
    public void integerToString() {
        //Arrange
        int value = 5;
        String valueString = String.valueOf(value); // "5"
        String valueEmBinário = "101";
        BinaryNumber binaryNumber = new BinaryNumber(valueString);
        GeneralNumber binaryNumber2 = binaryNumber.integerToString(value);

        //Act
        BinaryNumber binaryNumber3 = new BinaryNumber(valueString);
        GeneralNumber binaryNumber1 = binaryNumber3.integerToString(value);


        //Assert
        assertEquals(binaryNumber2, binaryNumber1);
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