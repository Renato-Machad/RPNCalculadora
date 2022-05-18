import java.util.Objects;

public class BinaryNumber extends GeneralNumber {

    private String binaryNumber;

    public BinaryNumber(String binaryNumber) {
        this.binaryNumber = binaryNumber;
    }

    @Override
    public GeneralNumber decimalToBinary(int value) {
        String binaryString = Integer.toBinaryString(value);
        BinaryNumber binaryNumber = new BinaryNumber(binaryString);
        return binaryNumber;
    }

    @Override
    public int getValue() {
        return Integer.parseInt(binaryNumber, 2);
    }


    @Override
    public String toString() {
        return "BinaryNumber: " + binaryNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryNumber that = (BinaryNumber) o;
        return Objects.equals(binaryNumber, that.binaryNumber);
    }
}
