
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTest {

    @Test
    public void listagemVazia() {
        //arrange
        //int data = 3;
        //Node previousTop = new Node(3);
        //Node top = new Node(5,previousTop);

        //act
        String resultado = Stack.listNodes();

        //assert
        assertEquals(resultado, "A lista está vazia");
    }

//    @Test
//    public void addValueToTopEmptyStack(){
//        //arrange
//        int num = 1;
//        Node node = new Node(num);
//        Stack stack = new Stack(node);
//
//        //Act
//        Stack stackResult = new Stack();
//        stackResult.push(num);
//
//        //assert
//        assertEquals(stack,stackResult);
//
//    }

}
