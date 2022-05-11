import static org.junit.Assert.*;

import org.junit.Test;

public class RPNTest {



    @Test
    public void sumTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(2);
        stack.push(2);
        int expectedResult = 4;

        //Act
        rpn.sum();
        Node node = stack.getTop();

        //Assert
        assertEquals(expectedResult,node.getData());
    }

    @Test
    public void multiplyTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(2);
        stack.push(3);
        int expectedResult = 6;

        //Act
        rpn.multiply();
        Node node = stack.getTop();

        //Assert
        assertEquals(expectedResult,node.getData());
    }

    @Test
    public void convertIntoNegativeTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(2);
        int expectedResult = -2;

        //Act
        rpn.convertIntoNegative((stack.getTop()).getData());
        Node node = stack.getTop();

        //Assert
        assertEquals(expectedResult,node.getData());
    }

    @Test
    public void convertIntoNegativeTestUnsuccess() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();

        int expectedResult = 2;

        //Act
        rpn.convertIntoNegative((stack.getTop()).getData());
        Node node = stack.getTop();

        //Assert
        assertEquals(expectedResult,node.getData());
    }

}