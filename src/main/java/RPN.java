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

    public boolean multiply() {
        if (stack.getSize() >= 2) {
            int a = stack.pull();
            int b = stack.pull();
            int result = a * b;
            stack.push(result);
        } else {
            return false;
        }
        return true;
    }

    public boolean divide() {
        if (stack.getSize() < 2) {
            return false;
        } else {
            int a = stack.pull();
            int b = stack.pull();
            if (a != 0) {
                int result = b / a;
                stack.push(result);
                return true;
            } else {
                stack.push(b);
                stack.push(a);
                return false;
            }
        }
    }

    public boolean minus() {
        if (stack.getSize() < 2) {
            return false;
        } else {
            int a = stack.pull();
            int b = stack.pull();
            int result = b - a;
            stack.push(result);
        }
        return true;
    }

    public void convertIntoNegative(int lastInput) {
        stack.pull();
        int negative = lastInput * (-1);
        lastInput = negative;
        stack.push(lastInput);
    }

}
