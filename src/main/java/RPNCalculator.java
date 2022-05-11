import java.util.Scanner;

public class RPNCalculator {

    public static void main(String[] args) {
        Stack stack = new Stack();
        String value = null;

        System.out.println("---RPN Calculator---\n");
        System.out.println("Type the expression:");

        Scanner read = new Scanner(System.in);

        do {
            value = read.nextLine();

            stack.push(Integer.parseInt(value));

            System.out.println("Do you want to add another value? (Yes-y/No-n?");
            value = read.nextLine();
        } while (value.equalsIgnoreCase("y"));

        System.out.println(stack);
        System.out.println(stack);

        int option = 0;

        do {
            switch (option = RPNCalculator.reader()) {
                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                default:
                    System.out.println("Invalid expression.");
                    break;
            }
        } while (value != "99");
    }

    public static int reader() {
        Scanner read = new Scanner(System.in);
        int option = 0;
        System.out.println("Choose from the following: \n" +
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


