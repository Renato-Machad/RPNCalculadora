//
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//
//public class NodeTest {
//    @Test
//    public void listStackSuccess() {
//        //Arrange
//        RPN rpn = new RPN();
//        Stack stack = rpn.getStack();
//        stack.push(7);
//        stack.push(3);
//        String expectedResult = "List:\n3\n7\n";
//
//        //Act
//        String actualResult = stack.listNodes();
//
//        //Assert
//        assertEquals(expectedResult,actualResult);
//    }
//
//    @Test
//    public void listStackFail(){
//
//        //Arrange
//        Stack stack = new Stack();
//        String expectedResult = "The list is empty";
//
//        //Act
//        String actualResult = stack.listNodes();
//
//        //Assert
//        assertEquals(expectedResult,actualResult);
//    }
//
//}
