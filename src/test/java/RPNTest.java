import static org.junit.Assert.*;

public class RPNTest {



    @org.junit.Test
    public void sumTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(2);
        stack.push(2);
        int expectedResult = 4;

        //Act
        rpn.sum();

        //Assert
        assertEquals(expectedResult,stack.pull());
    }

    @org.junit.Test
    public void multiplyTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(2);
        stack.push(3);
        int expectedResult = 6;

        //Act
        rpn.multiply();

        //Assert
        assertEquals(expectedResult,stack.pull());
    }

    @org.junit.Test
    public void divideTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(4);
        stack.push(2);
        int expectedResult = 2;

        //Act
        rpn.divide();

        //Assert
        assertEquals(expectedResult,stack.pull());
    }

    @org.junit.Test
    public void minusTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(2);
        stack.push(2);
        int expectedResult = 0;

        //Act
        rpn.minus();

        //Assert
        assertEquals(expectedResult,stack.pull());
    }

    @org.junit.Test
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
}