import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void pushValueToTopEmptyStack() {
        //Arrange
        GeneralNumber decimalNumber = new DecimalNumber(1);
        Node node = new Node(decimalNumber);
        Stack stack = new Stack(node);

        //Act
        Stack stackResult = new Stack();
        stackResult.push(stack.getTop().getData());

        //Assert
        assertEquals(stack.getTop().getData(), stackResult.getTop().getData());
    }

    @Test
    public void pushToNullTop() {
        //Arrange
        Node top = null;
        Stack stack = new Stack(top);
        GeneralNumber decimalNumber = new DecimalNumber(1);

        //Act
        Stack stackResult = new Stack(top);
        stackResult.push(decimalNumber);

        //Assert
        assertEquals(stack.getTop(), stackResult.getTop());
    }

    @Test
    public void pushValueToTopStackAndCompare2EqualStacks() {
        //Arrange
        DecimalNumber decimalNumber = new DecimalNumber(1);
        Stack stack = new Stack(new Node(decimalNumber));
        DecimalNumber decimalNumber2 = new DecimalNumber(1);
        Node node = new Node(decimalNumber2);

        //Act
        Stack stack2 = new Stack();
        stack2.push(node.getData());

        //assert
        assertEquals(stack.toString(), stack2.toString());
    }

    @Test
    public void pullValueFromStackWithValues() {
        //Arrange
        DecimalNumber decimalNumber1 = new DecimalNumber(1);
        DecimalNumber decimalNumber2 = new DecimalNumber(2);
        Stack stack = new Stack();
        stack.push(decimalNumber1);
        stack.push(decimalNumber2);

        //Act
        GeneralNumber result = stack.pull();

        //Assert
        assertEquals(decimalNumber2, result);
    }

    @Test
    public void pullValueFromStackWithOneValue() {
        //Arrange
        DecimalNumber decimalNumber = new DecimalNumber(1);
        Stack stack = new Stack();
        stack.push(decimalNumber);

        //Act
        stack.pull();

        //Assert
        assertTrue(stack.isEmpty());
    }

    @Test
    public void pullValueFromStackWithNoValues() {
        //Arrange
        Stack stack = new Stack();

        //Act
        stack.pull();

        //Assert
        assertNull(stack.getTop().getData());
    }

    //US04
    @Test
    public void listNodesSuccess() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(new BinaryNumber("101"));
        stack.push(new DecimalNumber(3));
        stack.push(new DecimalNumber(2));
        stack.push(new DecimalNumber(4));
        String expectedResult = "List:\nDecimalNumber:4\nDecimalNumber:2\nDecimalNumber:3\nBinaryNumber: 101\n";

        //Act
        String actualResult = stack.listNodes();

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    //US04
    @Test
    public void listNodesEmptyFail() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        String expectedResult = "The list is empty";

        //Act
        String actualResult = stack.listNodes();

        //Assert
        assertEquals(expectedResult, actualResult);
    }
}
