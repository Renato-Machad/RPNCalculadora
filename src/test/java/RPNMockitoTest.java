import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RPNMockitoTest {

    @InjectMocks
    RPN rpn;

    @Mock
    Stack mockStack;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.openMocks(this).close();
    }

    @Test
    public void testSumWithTwoOrMoreOperands() {
        //Arrange
        when(mockStack.getSize()).thenReturn(2);
        GeneralNumber decimalNumber = new DecimalNumber(2);
        when(mockStack.pull()).thenReturn(decimalNumber);

        ArgumentCaptor<DecimalNumber> arg = ArgumentCaptor.forClass(DecimalNumber.class);

        //Act
        assertTrue(rpn.sum());

        //Assert
        verify(mockStack).push(arg.capture());

        assertEquals(arg.getValue().getValue(), 4);
    }

    @Test
    public void testSumWithOneOrLessOperands() {
        when(mockStack.getSize()).thenReturn(1);
        assertFalse(rpn.sum());

        when(mockStack.getSize()).thenReturn(0);
        assertFalse(rpn.sum());
    }

    @Test
    public void testMultiplyWithOneOrLessOperands() {
        when(mockStack.getSize()).thenReturn(1);
        assertFalse(rpn.multiply());

        when(mockStack.getSize()).thenReturn(0);
        assertFalse(rpn.multiply());
    }

    @Test
    public void divideTestMockitoSuccess() {
        //Arrange
        when(mockStack.getSize()).thenReturn(2);
        GeneralNumber decimalNumber = new DecimalNumber(12);
        GeneralNumber binaryNumber2 = new BinaryNumber("11");
        when(mockStack.pull()).thenReturn(binaryNumber2, decimalNumber);

        ArgumentCaptor<DecimalNumber> expectedResult = ArgumentCaptor.forClass(DecimalNumber.class);

        //Act
        assertTrue(rpn.divide());

        //Assert
        verify(mockStack).push(expectedResult.capture());

        assertEquals(expectedResult.getValue().getValue(), 4);
    }

    @Test
    public void divideTestMockitoFail() {
        when(mockStack.getSize()).thenReturn(1);
        assertFalse(rpn.divide());

        when(mockStack.getSize()).thenReturn(0);
        assertFalse(rpn.divide());
    }

    @Test
    public void testMinusWithTwoOrMoreDecimalOperands() {
        //Arrange
        when(mockStack.getSize()).thenReturn(2);
        GeneralNumber decimalNumber = new DecimalNumber(2);
        when(mockStack.pull()).thenReturn(decimalNumber);

        ArgumentCaptor<DecimalNumber> arg = ArgumentCaptor.forClass(DecimalNumber.class);

        //Act
        assertTrue(rpn.minus());

        //Assert
        verify(mockStack).push(arg.capture());
        assertEquals(arg.getValue().getValue(), 0);
    }

    @Test
    public void testMinusWithOneOrLessOperands() {
        when(mockStack.getSize()).thenReturn(1);
        assertFalse(rpn.minus());

        when(mockStack.getSize()).thenReturn(0);
        assertFalse(rpn.minus());
    }

    @Test
    public void testMinusWithTwoOrMoreBinaryOperands() {
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
        //Arrange
        when(mockStack.getSize()).thenReturn(2);
        GeneralNumber binaryNumber = new BinaryNumber("101");
        when(mockStack.pull()).thenReturn(binaryNumber);

        ArgumentCaptor<DecimalNumber> arg = ArgumentCaptor.forClass(DecimalNumber.class);

        //Act
        assertTrue(rpn.minus());

        //Assert
        verify(mockStack).push(arg.capture());
        assertEquals(arg.getValue().getValue(), 0);
    }

    @Test
    public void convertIntoNegativeTestSuccess() {
        //Arrange
        when(mockStack.getSize()).thenReturn(1);
        GeneralNumber decimalNumber = new DecimalNumber(2);
        when(mockStack.pull()).thenReturn(decimalNumber);

        ArgumentCaptor<DecimalNumber> arg = ArgumentCaptor.forClass(DecimalNumber.class);

        //Act
        assertTrue(rpn.convertIntoNegative());

        //Assert
        verify(mockStack).push(arg.capture());

        assertEquals(arg.getValue().getValue(), -2);
    }

    @Test
    public void convertIntoNegativeBinaryTestSuccess() {
        //Arrange
        when(mockStack.getSize()).thenReturn(1);
        GeneralNumber binaryNumber = new BinaryNumber("10101");
        when(mockStack.pull()).thenReturn(binaryNumber);

        ArgumentCaptor<DecimalNumber> arg = ArgumentCaptor.forClass(DecimalNumber.class);

        //Act
        assertTrue(rpn.convertIntoNegative());

        //Assert
        verify(mockStack).push(arg.capture());

        assertEquals(arg.getValue().getValue(), -21);
    }

    @Test
    public void convertIntoNegativeTestFail() {
        when(mockStack.getSize()).thenReturn(0);
        assertFalse(rpn.convertIntoNegative());
    }
}