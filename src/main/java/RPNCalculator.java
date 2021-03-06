import java.util.Scanner;

public class RPNCalculator {

    public static void main(String[] args) {
        Stack stack = new Stack();
        RPN rpn = new RPN();
        BinaryNumber binary = new BinaryNumber();
        int value;

        System.out.println("---RPN Calculator---\n");

        Scanner read = new Scanner(System.in);

        int x = 0;

        do {
            switch (x = RPNCalculator.reader()) {
                case 1:
                    System.out.println("Type the expression:");
                    value = read.nextInt();
                    DecimalNumber decimalNumber = new DecimalNumber(value);
                    stack.push(decimalNumber);
                    break;

                case 2:
                    String result = String.valueOf(stack.pull());
                    if (result != null) {
                        System.out.println("First element of the stack removed.");
                    } else
                        System.out.println("No elements in the stack to be removed.");
                    break;

                case 3:
                    System.out.println(stack.listNodes());
                    break;

                case 4:
                    System.out.println("How many stack elements would you like to list:");
                    int numberOfElementsToList = read.nextInt();
                    System.out.println(rpn.listNFirstNodes(numberOfElementsToList));
                    break;

                case 5:
                    if (rpn.duplicateFirstStackElement()) {
                        System.out.println((stack.getTop()).getData());
                    } else {
                        System.out.println("Invalid Operation. Add one or more elements to the stack.");
                    }
                    break;

                case 10:
                    if (rpn.sum()) {
                        System.out.println((stack.getTop()).getData());
                    } else {
                        System.out.println("Invalid Operation. Add at least two elements to the stack.");
                    }
                    break;

                case 11:
                    if (rpn.multiply()) {
                        System.out.println((stack.getTop()).getData());
                    } else {
                        System.out.println("Invalid Operation. Add at least two elements to the stack.");
                    }
                    break;

                case 12:
                    if (rpn.divide()) {
                        System.out.println((stack.getTop()).getData());
                    } else {
                        System.out.println("Invalid Operation. Add at least two elements to the stack.");
                    }
                    break;

                case 13:
                    if (rpn.minus()) {
                        System.out.println((stack.getTop()).getData());
                    } else {
                        System.out.println("Invalid Operation. Add at least two elements to the stack.");
                    }
                    break;

                case 14:
                    if (rpn.convertIntoNegative()) {
                        System.out.println((stack.getTop()).getData());
                    } else
                        System.out.println("There are no elements in the stack");
                    break;

                case 40:
                    System.out.println("Type the expression:");
                    value = read.nextInt();
                    GeneralNumber binaryNumber = binary.decimalToBinary(value);
                    stack.push(binaryNumber);
                    System.out.println(binaryNumber);
                    break;

                default:
                    System.out.println("Invalid expression.");
                    break;
            }
        } while (x != 99);
    }

    public static int reader() {
        Scanner read = new Scanner(System.in);
        System.out.println("\nChoose from the following: \n" +
                "1 - Add an element to the stack \n" +
                "2 - Remove the first element from the stack \n" +
                "3 - List the content of the stack \n" +
                "4 - List the first N elements of the stack \n" +
                "5 - Duplicate the first element of the stack \n" +
                "10 - Replace the first two elements of the stack by their sum \n" +
                "11 - Replace the first two elements of the stack by their multiplication \n" +
                "12 - Replace the first two elements of the stack by dividing the second with the first \n" +
                "13 - Replace the first two elements of the stack by subtracting the second with the first \n" +
                "14 - Replace the first element of the stack by its negative \n" +
                "40 - Add decimal number to convert to binary\n" +
                "99 - Quit");
        return read.nextInt();
    }
}


