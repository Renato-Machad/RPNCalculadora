import static org.junit.Assert.*;

import org.junit.Test;

public class RPNTest {

    @Test
    public void sumTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        GeneralNumber decimalNumber = new DecimalNumber(2);
        GeneralNumber decimalNumber2 = new DecimalNumber(2);
        Stack stack = rpn.getStack();
        stack.push(decimalNumber);
        stack.push(decimalNumber2);
        int expectedResult = 4;
        GeneralNumber decimalNumber3 = new DecimalNumber(expectedResult);

        //Act
        rpn.sum();

        //Assert
        assertEquals(decimalNumber3, stack.pull());
    }

    @Test
    public void sumDoubleCheckTest() {
        //Arrange
        RPN rpn = new RPN();
        GeneralNumber decimalNumber = new DecimalNumber(3);
        GeneralNumber decimalNumber2 = new DecimalNumber(7);
        Stack stack = rpn.getStack();
        stack.push(decimalNumber);
        stack.push(decimalNumber2);
        int expectedResult = 10;
        GeneralNumber decimalNumber3 = new DecimalNumber(expectedResult);

        //Act
        rpn.sum();

        //Assert
        assertEquals(decimalNumber3, stack.pull());
    }

    @Test
    public void sumBinaryTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        GeneralNumber binaryNumber1 = new BinaryNumber("101");
        GeneralNumber binaryNumber2 = new BinaryNumber("101");
        Stack stack = rpn.getStack();
        stack.push(binaryNumber1);
        stack.push(binaryNumber2);
        int expectedResult = 10;
        GeneralNumber decimalNumber = new DecimalNumber(expectedResult);

        //Act
        rpn.sum();

        //Assert
        assertEquals(decimalNumber, stack.pull());
    }

    @Test
    public void multiplyTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        GeneralNumber decimalNumber = new DecimalNumber(2);
        GeneralNumber decimalNumber2 = new DecimalNumber(3);
        Stack stack = rpn.getStack();
        stack.push(decimalNumber);
        stack.push(decimalNumber2);
        int expectedResult = 6;
        GeneralNumber decimalNumber3 = new DecimalNumber(expectedResult);

        //Act
        rpn.multiply();

        //Assert
        assertEquals(decimalNumber3, stack.pull());
    }

    @Test
    public void multiplyBinaryTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        GeneralNumber binaryNumber1 = new BinaryNumber("101");
        GeneralNumber binaryNumber2 = new BinaryNumber("101");
        Stack stack = rpn.getStack();
        stack.push(binaryNumber1);
        stack.push(binaryNumber2);
        int expectedResult = 25;
        GeneralNumber decimalNumber = new DecimalNumber(expectedResult);

        //Act
        rpn.multiply();

        //Assert
        assertEquals(decimalNumber, stack.pull());
    }

    @Test
    public void divideTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        DecimalNumber a = new DecimalNumber(4);
        DecimalNumber b = new DecimalNumber(2);
        Stack stack = rpn.getStack();
        stack.push(a);
        stack.push(b);
        GeneralNumber expectedResult = new DecimalNumber(2);

        //Act
        rpn.divide();

        //Assert
        assertEquals(expectedResult, stack.pull());
    }

    @Test
    public void divideBinaryTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        GeneralNumber binaryNumber1 = new BinaryNumber("100");
        GeneralNumber binaryNumber2 = new BinaryNumber("10");
        Stack stack = rpn.getStack();
        stack.push(binaryNumber1);
        stack.push(binaryNumber2);
        int expectedResult = 2;
        GeneralNumber decimalNumber = new DecimalNumber(expectedResult);

        //Act
        rpn.divide();

        //Assert
        assertEquals(decimalNumber, stack.pull());
    }

    @Test
    public void divideTestFail() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        DecimalNumber a = new DecimalNumber(4);
        stack.push(a);
        boolean expectedResult = false;

        //Act
        rpn.divide();

        //Assert
        assertEquals(expectedResult, rpn.divide());
    }

    @Test
    public void minusTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        GeneralNumber decimalNumber1 = new DecimalNumber(2);
        GeneralNumber decimalNumber2 = new DecimalNumber(2);
        Stack stack = rpn.getStack();
        stack.push(decimalNumber1);
        stack.push(decimalNumber2);
        int expectedResult = 0;
        GeneralNumber decimalNumber = new DecimalNumber(expectedResult);

        //Act
        rpn.minus();

        //Assert
        assertEquals(decimalNumber, stack.pull());
    }

    @Test
    public void minusBinaryTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        GeneralNumber binaryNumber1 = new BinaryNumber("101");
        GeneralNumber binaryNumber2 = new BinaryNumber("101");
        Stack stack = rpn.getStack();
        stack.push(binaryNumber2);
        stack.push(binaryNumber1);
        int expectedResult = 0;
        GeneralNumber decimalNumber = new DecimalNumber(expectedResult);

        //Act
        rpn.minus();

        //Assert
        assertEquals(decimalNumber, stack.pull());
    }

    @Test
    public void convertIntoNegativeTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        GeneralNumber decimalNumber = new DecimalNumber(2);
        stack.push(decimalNumber);
        GeneralNumber expectedResult = new DecimalNumber(-2);

        //Act
        rpn.convertIntoNegative();
        Node node = stack.getTop();

        //Assert
        assertEquals(expectedResult, node.getData());
    }

    @Test
    public void convertIntoNegativeBinaryTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(new BinaryNumber("10101"));
        GeneralNumber expectedResult = new DecimalNumber(-21);

        //Act
        rpn.convertIntoNegative();
        Node node = stack.getTop();

        //Assert
        assertEquals(expectedResult, node.getData());
    }

    //erro ortografico
    @Test
    public void convertIntoNexgativeTestFail() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();

        boolean expectedResult = false;

        //Act
        rpn.convertIntoNegative();

        //Assert
        assertEquals(expectedResult, rpn.convertIntoNegative());
    }

    //US04
    @Test
    public void listNFirstNodesOfStackSuccess() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(new BinaryNumber("3"));
        stack.push(new DecimalNumber(3));
        stack.push(new DecimalNumber(2));
        stack.push(new DecimalNumber(4));
        int numberOfElementsToList = 3;
        String expectedResult = "List:\nDecimalNumber:4\nDecimalNumber:2\nDecimalNumber:3\n";

        //Act
        String actualResult = rpn.listNFirstNodes(numberOfElementsToList);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void listNFirstNodesOfStackBinarySuccess() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(new DecimalNumber(3));
        stack.push(new BinaryNumber("10101"));
        stack.push(new BinaryNumber("1001001"));
        int numberOfElementsToList = 2;
        String expectedResult = "List:\nBinaryNumber: 1001001\nBinaryNumber: 10101\n";

        //Act
        String actualResult = rpn.listNFirstNodes(numberOfElementsToList);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    //US04
    @Test
    public void listNFirstNodesOfStackTooShortFail() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(new BinaryNumber("10"));
        stack.push(new DecimalNumber(2));
        int numberOfElementsToList = 3;
        String expectedResult = "The list is smaller than that number";

        //Act
        String actualResult = rpn.listNFirstNodes(numberOfElementsToList);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    //US04
    @Test
    public void listNFirstNodesOfStackEmptyFail() {
        //Arrange
        RPN rpn = new RPN();
        int numberOfElementsToList = 3;
        String expectedResult = "The list is empty";

        //Act
        String actualResult = rpn.listNFirstNodes(numberOfElementsToList);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void duplicateFirstStackElementTestSuccess() {
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        GeneralNumber decimalNumber1 = new DecimalNumber(3);
        stack.push(decimalNumber1);
        GeneralNumber decimalNumber2 = new DecimalNumber(4);
        stack.push(decimalNumber2);
        GeneralNumber expectedResult = new DecimalNumber(4);

        //Act
        rpn.duplicateFirstStackElement();
        Node node = stack.getTop();

        //Assert
        assertEquals(expectedResult, node.getData());
    }

    @Test
    public void duplicateFirstStackElementBinaryTestSuccess() {
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(new BinaryNumber("101"));
        stack.push(new BinaryNumber("1001"));
        GeneralNumber expectedResult = new DecimalNumber(9);

        //Act
        rpn.duplicateFirstStackElement();
        Node node = stack.getTop();

        //Assert
        assertEquals(expectedResult, node.getData());
    }
}