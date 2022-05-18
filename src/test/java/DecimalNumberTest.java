import org.junit.Test;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertNotNull;

public class DecimalNumberTest {

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

