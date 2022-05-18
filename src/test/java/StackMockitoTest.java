import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StackMockitoTest {

    @InjectMocks
    Stack mockStack;

    @Mock
    DecimalNumber decimalNumber;

    @Test
    public void pushDecimalNumberToStackTest() {

        mockStack = Mockito.mock(Stack.class);
        when(mockStack.push(decimalNumber)).thenReturn(new DecimalNumber(1));

        //Act
        GeneralNumber expected = mockStack.push(decimalNumber);

        //Assert
        assertEquals(new DecimalNumber(1), expected);
    }

    @Test
    public void pullDecimalNumberToStackTest() {

        mockStack = Mockito.mock(Stack.class);
        when(mockStack.pull()).thenReturn(new DecimalNumber(1));

        //Act
        GeneralNumber expected = mockStack.pull();

        //Assert
        assertEquals(new DecimalNumber(1), expected);
    }
}


