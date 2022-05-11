import static org.junit.Assert.*;

public class RPNTest {



    @org.junit.Test
    public void sumTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(2);
        stack.push(2);
        int resultadoEsperado = 4;

        //Act
        rpn.sum();
        Node node = stack.getTop();

        //Assert
        assertEquals(resultadoEsperado,node.getData());
    }

    @org.junit.Test
    public void multiply() {

    }
}