import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RPNCalculatorMockitoTest {

    @InjectMocks
   RPNCalculator rpnCalculator;

    @Mock
    DecimalNumber decimalNumber;

    @Mock
    Stack stack;


    @Test
    public void addDecimalNumberToStackTest() {
        when(stack.getSize()).thenReturn(1);


        //Act
        stack.push(decimalNumber);

        //Assert
        assertEquals(1, stack.getSize());
    }

}


