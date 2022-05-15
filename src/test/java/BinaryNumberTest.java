import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryNumberTest {

    @Test
    public void integerToString() {
        //Arrange
        int value = 101;
        String valueString = String.valueOf(value); // "5"
        //String binaryValue = "101";
        //BinaryNumber binaryNumber = new BinaryNumber(valueString);
        //GeneralNumber binaryNumber2 = binaryNumber.integerToString(value);

        //Act
        BinaryNumber binaryNumber = new BinaryNumber(valueString);
        GeneralNumber result = binaryNumber.integerToString(5);


        //Assert
        assertEquals(new BinaryNumber(valueString), result);
    }

    @Test
    public void getValueDecimal() {
        //Arrange
        int number = 5;

        //Act
        DecimalNumber resultDecimal = new DecimalNumber(number);
        int resultNumber = resultDecimal.getValueDecimal();

        //Assert
        assertEquals(number, resultNumber);
    }
}