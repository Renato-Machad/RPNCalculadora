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
        int a = stack.pull();
        int value;
        if (a <= 0) {
            value = a;
        } else {
            value = a * (-1);
        }
        stack.push(value);
    }

    public String listNumberNodes(int number) {
        StringBuilder result = new StringBuilder();
        Node aux = stack.getTop();
        if (aux.getNext() != null) {
            if (stack.getSize() >= number) {
                for (int i = 0; i < number; i++) {
                    result.append(aux.getData());
                    if (aux.getNext() != null) {
                        result.append("\n");
                    }
                    aux = aux.getNext();
                }
                return "List:\n" + result;
            }
            return "The list is smaller than that number";
        } else
            return "The list is empty";
    }

    public String decimalToBinaryConverter(int decimal) {
        String binary = Integer.toBinaryString(decimal);
        stack.push(Integer.parseInt(binary));
        return binary;
    }
}
