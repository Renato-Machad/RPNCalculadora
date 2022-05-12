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

        //Act
        rpn.sum();

        //Assert
        assertEquals(expectedResult, stack.pull());
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

        //Act
        rpn.multiply();

        //Assert
        assertEquals(expectedResult, stack.pull());
    }

    @org.junit.Test
    public void divideTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        DecimalNumber a = new DecimalNumber(4);
        DecimalNumber b = new DecimalNumber(2);
        stack.push(a);
        stack.push(b);
        DecimalNumber expectedResult = new DecimalNumber(2);

        //Act
        rpn.divide();

        //Assert
        assertEquals(expectedResult, stack.pull());
    }

    @org.junit.Test
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

    @org.junit.Test
    public void minusTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        GeneralNumber decimalNumber = new DecimalNumber(2);
        GeneralNumber decimalNumber2 = new DecimalNumber(2);
        Stack stack = rpn.getStack();
        stack.push(decimalNumber);
        stack.push(decimalNumber2);
        int expectedResult = 0;

        //Act
        rpn.minus();

        //Assert
        assertEquals(expectedResult, stack.pull());
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
        rpn.convertIntoNegative((stack.getTop()).getData());
        Node node = stack.getTop();

        //Assert
        assertEquals(expectedResult, node.getData());
    }

    @Test
    public void convertIntoNegativeTestUnsuccess() { //O caso de insucesso é a stack estar vazia, tem de ser alterado!!!!
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();

        int expectedResult = 2;

        //Act
        rpn.convertIntoNegative((stack.getTop()).getData());
        Node node = stack.getTop();

        //Assert
        assertEquals(expectedResult, node.getData());
    }

    //US04
    @Test
    public void listNumberStackSuccess() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(new BinaryNumber("3"));
        stack.push(new DecimalNumber(3));
        stack.push(new DecimalNumber(2));
        stack.push(new DecimalNumber(4));
        int numberOfElementsToList = 3;
        String expectedResult = "List:\n4\n2\n3\n";

        //Act
        String actualResult = rpn.listNumberNodes(numberOfElementsToList);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    //US04
    @Test
    public void listNumberStackTooShortFail() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(new BinaryNumber("5"));
        stack.push(new DecimalNumber(2));
        int numberOfElementsToList = 3;
        String expectedResult = "The list is smaller than that number";

        //Act
        String actualResult = rpn.listNumberNodes(numberOfElementsToList);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    //US04
    @Test
    public void listNumberStackEmptyFail() {
        //Arrange
        RPN rpn = new RPN();
        int numberOfElementsToList = 3;
        String expectedResult = "The list is empty";

        //Act
        String actualResult = rpn.listNumberNodes(numberOfElementsToList);

        //Assert
        assertEquals(expectedResult, actualResult);
    }
}