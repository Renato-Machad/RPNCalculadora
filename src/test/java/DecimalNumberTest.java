import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DecimalNumberTest {


    @Test
    public void decimalToBinary() {
        //Arrange
        int value = 5;
        DecimalNumber decimalNumber = new DecimalNumber(value);
        GeneralNumber expected = new DecimalNumber(value);

        //Act
        GeneralNumber result = decimalNumber.decimalToBinary(value);

        //Assert
        assertEquals(result, expected);
    }

    @Test
    public void integerToDecimalSuccess() {
        //Arrange
        int value = 5;

        //Act
        DecimalNumber result = new DecimalNumber(value);

        //Assert
        assertNotNull(result);
    }
}

