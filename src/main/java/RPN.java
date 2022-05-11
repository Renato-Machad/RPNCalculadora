public class RPN {
    private static Stack stack;

    public RPN() {
        stack = new Stack();
    }

    public Stack getStack() {
        return stack;
    }

    public boolean sum() {
        if(stack.getSize() < 2) {
            return false;
        } else {
            int a = stack.pull();
            int b = stack.pull();
            int result = a + b;
            stack.push(result);
            return true;
        }
    }

    public void multiply() {
        int a = stack.pull();
        int b = stack.pull();
        int result = a * b;
        stack.push(result);
    }

    public void convertIntoNegative(int lastInput) {
        stack.pull();
        int negative = lastInput * (-1);
        lastInput = negative;
        stack.push(lastInput);
    }

}
