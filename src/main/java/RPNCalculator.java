import java.util.Scanner;

public class RPNCalculator {

    public static void main(String[] args) {
        Stack stack = new Stack();
        RPN rpn = new RPN();
        String value;

        System.out.println("---RPN Calculator---\n");

        Scanner read = new Scanner(System.in);

        int x = 0;

        do {
            switch (x = RPNCalculator.reader()) {
                case 1:
                    System.out.println("Type the expression:");
                    value = read.nextLine();
                    stack.push(Integer.parseInt(value));
                    break;

                case 2:
                    String result = String.valueOf(stack.pull());
                    System.out.println("First element of the stack removed.");
                    break;

                case 3:
                    System.out.println(stack.toString());
                    break;

                case 10:
                    rpn.sum();
                    System.out.println((stack.getTop()).getData());
                    break;

                case 11:
                    rpn.multiply();
                    System.out.println((stack.getTop()).getData());
                    break;

                case 14:
                    rpn.convertIntoNegative((stack.getTop()).getData());
                    System.out.println((stack.getTop()).getData());
                    break;

                default:
                    System.out.println("Invalid expression.");
                    break;
            }
        } while (x != 99);
    }

    public static int reader() {
        Scanner read = new Scanner(System.in);
        int option = 0;
        System.out.println("\nChoose from the following: \n" +
                "1 - Add an element to the stack \n" +
                "2 - Remove the first element from the stack \n" +
                "3 - List the content of the stack \n" +
                "10 - Replace the first two elements of the stack by their sum \n" +
                "11 - Replace the first two elements of the stack by their multiplication \n" +
                "14 - Replace the first element of the stack by its negative \n" +
                "99 - Quit");
        return option = read.nextInt();
    }
}


