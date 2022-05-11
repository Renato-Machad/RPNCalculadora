
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NodeTest {
    @Test
    public void listStackSuccess() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(7);
        stack.push(3);
        String expectedResult = "3  7  null";

        //Act
        String actualResult = stack.toString();

        //Assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void listStackFail(){

        //Arrange
        Stack stack = new Stack();
        String expectedResult = "null";

        //Act
        String actualResult = stack.toString();

        //Assert
        assertEquals(expectedResult,actualResult);
    }

}
