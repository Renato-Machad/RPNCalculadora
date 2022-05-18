import java.util.Objects;

public class Node {

    private GeneralNumber data;
    private Node next; //proximo elemento da lista, referência ou apontador para o seguinte

    public Node() {
    }

    public Node(GeneralNumber data) {
        this.data = data;
    }

    public Node(GeneralNumber data, Node next) {
        this.data = data;
        this.next = next;
    }

    public GeneralNumber getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "" + data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return data == node.data && Objects.equals(next, node.next);
    }
}
