import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RPNCalculatorTest {

    @InjectMocks
    RPNCalculator rpnCalculator;

    @Mock
    DecimalNumber decimalNumber;

    @Mock
    RPN rpnMock;

    @Mock
    Stack stack;

    @Mock
    Node node;


//    @Test
//    public void mainTest() {
//        int x = 0;
//
//        when(rpnCalculator.reader()).thenReturn(1);
//        //Act
//        stack.push(decimalNumber);
//
//        //Assert
//        assertEquals(1, stack.getSize());
//    }




    @Test
    public void addDecimalNumberToStackTest() {

        Stack mockStack = Mockito.mock(Stack.class);
        when(mockStack.push(decimalNumber)).thenReturn(new DecimalNumber(1));

        //Act
        GeneralNumber expected = mockStack.push(decimalNumber);

        //Assert
        assertEquals(new DecimalNumber(1), expected);
    }

    @Test
    public void pullDecimalNumberToStackTest() {

        Stack mockStack = Mockito.mock(Stack.class);
        when(mockStack.pull()).thenReturn(new DecimalNumber(1));

        //Act
        GeneralNumber expected = mockStack.pull();

        //Assert
        assertEquals(new DecimalNumber(1), expected);
    }

}


