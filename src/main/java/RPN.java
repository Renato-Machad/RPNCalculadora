public class RPN {

    private Stack stack;

    public RPN() {
        stack = new Stack();
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }

    public Stack getStack() {
        return stack;
    }

    public boolean sum() {
        if (stack.getSize() < 2) {
            return false;
        } else {
            GeneralNumber a = stack.pull();
            GeneralNumber b = stack.pull();

            int a2 = a.getValue();
            int b2 = b.getValue();

            int result = a2 + b2;
            DecimalNumber resultGeneral = new DecimalNumber(result);
            stack.push(resultGeneral);
            return true;
        }
    }

    public boolean multiply() {
        if (stack.getSize() < 2) {
            return false;
        } else {
            GeneralNumber a = stack.pull();
            GeneralNumber b = stack.pull();

            int a2 = a.getValue();
            int b2 = b.getValue();

            int result = a2 * b2;
            DecimalNumber resultGeneral = new DecimalNumber(result);
            stack.push(resultGeneral);
            return true;
        }
    }

    public boolean divide() {
        if (stack.getSize() < 2) {
            return false;
        } else {
            GeneralNumber a = stack.pull();
            GeneralNumber b = stack.pull();

            int a2 = a.getValue();
            int b2 = b.getValue();

            if (a2 != 0) {
                int result = b2 / a2;
                DecimalNumber resultGeneral = new DecimalNumber(result);
                stack.push(resultGeneral);
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
            GeneralNumber a = stack.pull();
            GeneralNumber b = stack.pull();

            int a2 = a.getValue();
            int b2 = b.getValue();

            int result = b2 - a2;
            DecimalNumber resultGeneral = new DecimalNumber(result);
            stack.push(resultGeneral);
            return true;
        }
    }

    public boolean convertIntoNegative() {
        if (stack.getSize() < 1) {
            return false;
        } else {
            GeneralNumber a = stack.pull();
            int value;
            int a2 = a.getValue();
            if (a2 <= 0) {
                value = a2;
            } else {
                value = a2 * (-1);
            }
            DecimalNumber result = new DecimalNumber(value);
            stack.push(result);
        }
        return true;
    }

    public String listNFirstNodes(int number) {
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

    public boolean duplicateFirstStackElement() {
        if (stack.getSize() >= 1) {
            GeneralNumber a = stack.pull();
            int a2 = a.getValue();
            DecimalNumber duplicateA = new DecimalNumber(a2);
            stack.push(a);
            stack.push(duplicateA);
            return true;
        } else {
            return false;
        }
    }


}