import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryNumberTest {

    @Test
    public void integerToString() {
        //Arrange
        int value = 101;
        String valueString = String.valueOf(value);

        //Act
        BinaryNumber binaryNumber = new BinaryNumber(valueString);
        GeneralNumber result = binaryNumber.decimalToBinary(5);

        //Assert
        assertEquals(new BinaryNumber(valueString), result);
    }

    @Test
    public void getValueDecimal() {
        //Arrange
        int number = 5;

        //Act
        DecimalNumber resultDecimal = new DecimalNumber(number);
        int resultNumber = resultDecimal.getValue();

        //Assert
        assertEquals(number, resultNumber);
    }

    @Test
    public void emptyConstructor() {
        //Arrange
        BinaryNumber binaryNumber = new BinaryNumber();
        BinaryNumber other = new BinaryNumber();
        
        //Assert
        assertEquals(binaryNumber, other);
    }
}