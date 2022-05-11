
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTest {

    @Test
    public void addValueToTopEmptyStack(){
        //arrange
        int num = 1;
        Node node = new Node(num);
        Stack stack = new Stack(node);

        //Act
        Stack stackResult = new Stack();
        stackResult.push(stack.getTop().getData());

        //assert
        assertEquals(stack.getTop(),stackResult.getTop());

    }
}
