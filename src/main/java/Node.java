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

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}
