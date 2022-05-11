public class RPN {
    private static Stack stack;

    public RPN() {
        stack = new Stack();
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
}
