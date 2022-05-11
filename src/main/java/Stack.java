public class Stack {

    private static Node top;
    private int size;

    public Stack() {
        top = new Node();
        size = 0;
    }

    public Stack(Node num){
        this.top=num;
    }

    public int getSize() {
        return size;
    }
//Este método deve devolver uma cópia do top para o proteger e nao ser alterado/apagado
    public Node getTop() {
        return new Node(top.getData());
    }

    public void push(int data) {
        if (top == null) // stack nao tem nada
            top = new Node(data);
        else {
            Node current = new Node(data, top);
            top = current;
        }
        size++;
    }

//    public void push (Node novo){
//        novo.setNext(top);
//        top = novo;
//    }

    public int pull() {
        final int data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    public boolean isEmpty() {
        return true;
    }

    @Override
    public String toString() {
        return top.toString();
    }


    public static String listNodes() {
        StringBuilder result = new StringBuilder();
        Node aux = top;
        if (aux.getNext() != null) {
            Node current = aux;
            while (current.getNext() != null) {
                result.append(current.getData());
                if (current.getNext() != null) {
                    result.append("\n");
                }
                current = current.getNext();
            }
            return "List:\n" + result;
        } else
            return "The list is empty";
    }
}
