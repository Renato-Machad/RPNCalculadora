import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Esta classe só testa métodos da classe RPN.
 */
public class RPNMockitoTest {

    /**
     * Esta é a classe a ser testada. Neste objecto são injetados os mocks definidos nesta classe
     * (neste caso, apenas o mockStack, porque Stack é a única classe utilizada pela RPN.
     */
    @InjectMocks
    RPN rpn;


    /**
     *  Mock que substitui o atribute 'stack', do tipo Stack, da classe RPN.
     */
    @Mock
    Stack mockStack;

    /**
     * Isto serve apenas para inicializar os mocks e injetá-los no objecto rpn no início dos testes.
     * Basicamente substitui fazer isto em cada teste -> Stack mockStack = Mockito.mock(Stack.class);
     * É necessário que a classe a ser testada (RPN neste caso) haja um construtor com os seus atributos todos ou
     * um setter para cada um dos atributos. (o Mockito vai utilizar o que estiver disponível por esta ordem)
     */
    @Before
    public void init() throws Exception {
        MockitoAnnotations.openMocks(this).close();
    }

    /**
     * exemplo de teste apropriado: apenas a lógica da classe RPN; tudo o resto é simulado por nós
     */
    @Test
    public void testSumWithTwoOrMoreOperands() {
        // simulação do comportamento externo à classe RPN
        when(mockStack.getSize()).thenReturn(2);
        GeneralNumber decimalNumber = new DecimalNumber(2);
        when(mockStack.pull()).thenReturn(decimalNumber);

        // este objecto serve para capturar referências a objetos aos quais não temos acesso de outra forma
        //(por exemplo neste caso é um objeto criado no interior do método RPN.sum() que não é devolvido, apenas
        // usado como argumento no stack.push()
        ArgumentCaptor<DecimalNumber> arg = ArgumentCaptor.forClass(DecimalNumber.class);

        //VERIFICAÇÕES
        //verifica a lógica de devolver true se houver 2 ou mais operandos
        assertTrue(rpn.sum());

        // verifica que o mockstack.push() foi chamado uma e uma única vez, e captura o valor que foi utilizado
        verify(mockStack).push(arg.capture());

        // verifica que o DecimalNumber usado como argumento na chamada ao método stack.push() é a soma correcta
        assertEquals(arg.getValue().getValue(), 4);
    }

    /**
     * exemplo de teste apropriado: apenas a lógica da classe RPN; tudo o resto é simulado por nós
     */
    @Test
    public void testSumWithOneOrLessOperands() {
        when(mockStack.getSize()).thenReturn(1);
        assertFalse(rpn.sum());

        when(mockStack.getSize()).thenReturn(0);
        assertFalse(rpn.sum());
    }

    /**
     * este teste não deveria ser feito assim teoricamente porque só queremos testar o comportamento da classe RPN.
     * Todas as outras classes (incluindo a Stack) assume-se sempre que estão a comportar-se de forma pefeita.
     */
    @Test
    public void sumTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        GeneralNumber decimalNumber = new DecimalNumber(2);
        GeneralNumber decimalNumber2 = new DecimalNumber(2);
        Stack stack = rpn.getStack();
        stack.push(decimalNumber);
        stack.push(decimalNumber2);
        int expectedResult = 4;
        GeneralNumber decimalNumber3 = new DecimalNumber(expectedResult);

        //Act
        rpn.sum();

        //Assert
        assertEquals(decimalNumber3, stack.pull());
    }

    @Test
    public void sumDoubleCheckTest() {
        //Arrange
        RPN rpn = new RPN();
        GeneralNumber decimalNumber = new DecimalNumber(3);
        GeneralNumber decimalNumber2 = new DecimalNumber(7);
        Stack stack = rpn.getStack();
        stack.push(decimalNumber);
        stack.push(decimalNumber2);
        int expectedResult = 10;
        GeneralNumber decimalNumber3 = new DecimalNumber(expectedResult);

        //Act
        rpn.sum();

        //Assert
        assertEquals(decimalNumber3, stack.pull());
    }

    @Test
    public void sumBinaryTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        GeneralNumber binaryNumber1 = new BinaryNumber("101");
        GeneralNumber binaryNumber2 = new BinaryNumber("101");
        Stack stack = rpn.getStack();
        stack.push(binaryNumber1);
        stack.push(binaryNumber2);
        int expectedResult = 10;
        GeneralNumber decimalNumber = new DecimalNumber(expectedResult);

        //Act
        rpn.sum();

        //Assert
        assertEquals(decimalNumber, stack.pull());
    }

    @Test
    public void testMultiplyWithOneOrLessOperands() {
        when(mockStack.getSize()).thenReturn(1);
        assertFalse(rpn.multiply());

        when(mockStack.getSize()).thenReturn(0);
        assertFalse(rpn.multiply());
    }

    @Test
    public void multiplyBinaryTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        GeneralNumber binaryNumber1 = new BinaryNumber("101");
        GeneralNumber binaryNumber2 = new BinaryNumber("101");
        Stack stack = rpn.getStack();
        stack.push(binaryNumber1);
        stack.push(binaryNumber2);
        int expectedResult = 25;
        GeneralNumber decimalNumber = new DecimalNumber(expectedResult);

        //Act
        rpn.multiply();

        //Assert
        assertEquals(decimalNumber, stack.pull());
    }

    @Test
    public void divideTestMockitoSuccess() {
        //Arrange
        when(mockStack.getSize()).thenReturn(2);
        GeneralNumber decimalNumber = new DecimalNumber(12);
        GeneralNumber binaryNumber2 = new BinaryNumber("11");
        when(mockStack.pull()).thenReturn(binaryNumber2, decimalNumber);

        ArgumentCaptor<DecimalNumber> expectedResult = ArgumentCaptor.forClass(DecimalNumber.class);

        //Act
        assertTrue(rpn.divide());

        //Assert
        verify(mockStack).push(expectedResult.capture());
        assertEquals(expectedResult.getValue().getValue(), 4);
    }

    @Test
    public void divideTestMockitoFail() {
        when(mockStack.getSize()).thenReturn(1);
        assertFalse(rpn.divide());

        when(mockStack.getSize()).thenReturn(0);
        assertFalse(rpn.divide());
    }

    @Test
    public void testMinusWithTwoOrMoreDecimalOperands() {

        when(mockStack.getSize()).thenReturn(2);
        GeneralNumber decimalNumber = new DecimalNumber(2);
        when(mockStack.pull()).thenReturn(decimalNumber);

        ArgumentCaptor<DecimalNumber> arg = ArgumentCaptor.forClass(DecimalNumber.class);

        //Verify
        assertTrue(rpn.minus());

        verify(mockStack).push(arg.capture());

        assertEquals(arg.getValue().getValue(), 0);
    }

    @Test
    public void testMinusWithOneOrLessOperands() {
        when(mockStack.getSize()).thenReturn(1);
        assertFalse(rpn.minus());

        when(mockStack.getSize()).thenReturn(0);
        assertFalse(rpn.minus());
    }

    @Test
    public void testMinusWithTwoOrMoreBinaryOperands() {

        when(mockStack.getSize()).thenReturn(2);
        GeneralNumber binaryNumber = new BinaryNumber("101");
        when(mockStack.pull()).thenReturn(binaryNumber);

        ArgumentCaptor<DecimalNumber> arg = ArgumentCaptor.forClass(DecimalNumber.class);

        //Verify
        assertTrue(rpn.minus());

        verify(mockStack).push(arg.capture());

        assertEquals(arg.getValue().getValue(), 0);
    }

    @Test
    public void convertIntoNegativeTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        GeneralNumber decimalNumber = new DecimalNumber(2);
        stack.push(decimalNumber);
        GeneralNumber expectedResult = new DecimalNumber(-2);

        //Act
        rpn.convertIntoNegative();
        Node node = stack.getTop();

        //Assert
        assertEquals(expectedResult, node.getData());
    }

    @Test
    public void convertIntoNegativeBinaryTestSuccess() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(new BinaryNumber("10101"));
        GeneralNumber expectedResult = new DecimalNumber(-21);

        //Act
        rpn.convertIntoNegative();
        Node node = stack.getTop();

        //Assert
        assertEquals(expectedResult, node.getData());
    }

    //erro ortografico
    @Test
    public void convertIntoNexgativeTestFail() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();

        boolean expectedResult = false;

        //Act
        rpn.convertIntoNegative();

        //Assert
        assertEquals(expectedResult, rpn.convertIntoNegative());
    }

    //US04
    @Test
    public void listNFisrtNodesOfStackSuccess() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(new BinaryNumber("3"));
        stack.push(new DecimalNumber(3));
        stack.push(new DecimalNumber(2));
        stack.push(new DecimalNumber(4));
        int numberOfElementsToList = 3;
        String expectedResult = "List:\nDecimalNumber:4\nDecimalNumber:2\nDecimalNumber:3\n";

        //Act
        String actualResult = rpn.listNFirstNodes(numberOfElementsToList);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void listNFirstNodesOfStackBinarySuccess() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(new DecimalNumber(3));
        stack.push(new BinaryNumber("10101"));
        stack.push(new BinaryNumber("1001001"));
        int numberOfElementsToList = 2;
        String expectedResult = "List:\nBinaryNumber: 1001001\nBinaryNumber: 10101\n";

        //Act
        String actualResult = rpn.listNFirstNodes(numberOfElementsToList);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    //US04
    @Test
    public void listNFirstNodesOfStackTooShortFail() {
        //Arrange
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(new BinaryNumber("10"));
        stack.push(new DecimalNumber(2));
        int numberOfElementsToList = 3;
        String expectedResult = "The list is smaller than that number";

        //Act
        String actualResult = rpn.listNFirstNodes(numberOfElementsToList);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    //US04
    @Test
    public void listNFirstNodesOfStackEmptyFail() {
        //Arrange
        RPN rpn = new RPN();
        int numberOfElementsToList = 3;
        String expectedResult = "The list is empty";

        //Act
        String actualResult = rpn.listNFirstNodes(numberOfElementsToList);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void duplicateFirstStackElementTestSuccess() {
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        GeneralNumber decimalNumber1 = new DecimalNumber(3);
        stack.push(decimalNumber1);
        GeneralNumber decimalNumber2 = new DecimalNumber(4);
        stack.push(decimalNumber2);
        GeneralNumber expectedResult = new DecimalNumber(4);

        //Act
        rpn.duplicateFirstStackElement();
        Node node = stack.getTop();

        //Assert
        assertEquals(expectedResult, node.getData());
    }

    @Test
    public void duplicateFirstStackElementBinaryTestSuccess() {
        RPN rpn = new RPN();
        Stack stack = rpn.getStack();
        stack.push(new BinaryNumber("101"));
        stack.push(new BinaryNumber("1001"));
        GeneralNumber expectedResult = new DecimalNumber(9);

        //Act
        rpn.duplicateFirstStackElement();
        Node node = stack.getTop();

        //Assert
        assertEquals(expectedResult, node.getData());
    }
}