public class RPN {
    private static Stack stack;

    public RPN() {
        stack = new Stack();
    }

    public Stack getStack() {
        return stack;
    }

    public void sum() {
        int a = stack.pull();
        int b = stack.pull();
        int result = a + b;
        stack.push(result);
    }

    public void multiply() {
        int a = stack.pull();
        int b = stack.pull();
        int result = a * b;
        stack.push(result);
    }

    public void convertIntoNegative(int lastInput) {
        int a = stack.pull();
        int value;
        if (a <= 0) {
            value = a;
        } else {
            value = a * (-1);
        }
        stack.push(value);
    }

}
