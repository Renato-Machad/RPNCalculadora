import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RPNTestMockito {

    @InjectMocks
    RPN rpn;

    @Mock
    Stack mockStack;

    public void init() throws Exception {
        MockitoAnnotations.openMocks(this).close();
    }

    @org.junit.jupiter.api.Test
    void testSumWithTwoOrMoreOperands() {
        when(mockStack.getSize()).thenReturn(2);
        GeneralNumber decimalNumber = new DecimalNumber(2);
        when(mockStack.pull()).thenReturn(decimalNumber);

        ArgumentCaptor<DecimalNumber> arg = ArgumentCaptor.forClass(DecimalNumber.class);

        //Verify
        assertTrue(rpn.sum());
        verify(mockStack).push(arg.capture());
        assertEquals(arg.getValue().getValue(), 4);
    }

    @org.junit.jupiter.api.Test
    void multiply() {
    }

    @org.junit.jupiter.api.Test
    void divide() {
    }

    @org.junit.jupiter.api.Test
    void minus() {
    }
}