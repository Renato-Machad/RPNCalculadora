
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void addValueToTopEmptyStack() {
        //Arrange
        int num = 1;
        Node node = new Node(num);
        Stack stack = new Stack(node);

        //Act
        Stack stackResult = new Stack();
        stackResult.push(stack.getTop().getData());

        //Assert
        assertEquals(stack.getTop().getData(), stackResult.getTop().getData());
    }

    @Test
    public void addValueToTopStackAndCompare2EqualStacks() {
        //arrange
        Stack stack = new Stack(new Node(1));
        int num = 1;
        Node node = new Node(num);

        //Act
        Stack stack2 = new Stack();
        stack2.push(node.getData());

        //assert
        assertEquals(stack.toString(), stack2.toString());
    }


    @Test
    public void pullValueFromStackWithValues(){
        //Arrange
        int num =1;
        int num2 =2;
        Stack stack = new Stack();
        stack.push(num);
        stack.push(num2);

        //Act
        int result = stack.pull();

        //Assert
        assertEquals(2,result);
    }

    @Test
    public void pullValueFromStackWithOneValue(){
        //Arrange
        int num =1;
        Stack stack = new Stack();
        stack.push(num);

        //Act
        stack.pull();

        //Assert
        assertTrue(stack.isEmpty());
    }



    @Test
    public void pullValueFromStackWithNoValues(){
        //Arrange
        Stack stack = new Stack();

        //Act
        stack.pull();

        //Assert
        assertNull(stack.getTop().getData());
    }

}
