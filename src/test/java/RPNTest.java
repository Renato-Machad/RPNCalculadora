import static org.junit.Assert.*;

public class RPNTest {



    @org.junit.Test
    public void sumTest() {
        //Arrange
        Stack stack = new Stack();
        stack.push(2);
        stack.push(2);
        int resultadoEsperado = 4;

        //Act
        RPN.sum();
        Node node = stack.getTop();

        //Assert
        assertEquals(resultadoEsperado,node.getData());
    }

    @org.junit.Test
    public void multiply() {

    }
}