public class Stack {

    private static Node top;
    private static int size;

    public Stack() {
        top = new Node();
        size = 0;
    }

    public Stack(Node num) {
        top = num;
    }

    public int getSize() {
        return size;
    }

    public Node getTop() {
        return new Node(top.getData(), top.getNext());
    }

    public GeneralNumber push(GeneralNumber data) {
        if (top == null)
            top = new Node(data);
        else {
            Node current = new Node(data, top);
            top = current;
        }
        size++;
        return data;
    }

    public GeneralNumber pull() {
        if (size == 0) {
            return null;
        } else {
            final GeneralNumber data = top.getData();
            top = top.getNext();
            size--;
            return data;
        }
    }

    public boolean isEmpty() {
        return true;
    }

    @Override
    public String toString() {
        return top.toString();
    }

    public String listNodes() {
        StringBuilder result = new StringBuilder();
        Node aux = top;
        if (aux.getNext() != null) {
            while (aux.getNext() != null) {
                result.append(aux.getData());
                if (aux.getNext() != null) {
                    result.append("\n");
                }
                aux = aux.getNext();
            }
            return "List:\n" + result;
        } else
            return "The list is empty";
    }
}
