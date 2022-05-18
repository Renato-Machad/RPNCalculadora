import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void testEquals_equalsObjects() {
        int num = 10;
        DecimalNumber decimalNumber = new DecimalNumber(num);
        Node node = new Node(decimalNumber);
        Node otherNode = new Node(decimalNumber);

        assertEquals(node, otherNode);
    }

    @Test
    public void testEquals_sameObjects() {
        int num = 10;
        DecimalNumber decimalNumber = new DecimalNumber(num);
        Node node = new Node(decimalNumber);
        Node otherNode = node;

        assertEquals(node, otherNode);
    }
}