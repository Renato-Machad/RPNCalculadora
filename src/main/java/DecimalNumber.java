public class DecimalNumber extends GeneralNumber {

    private final int decimalNumber;

    public DecimalNumber(int decimalNumber) {
        this.decimalNumber = decimalNumber;
    }

    @Override
    public GeneralNumber decimalToBinary(int value) {
        GeneralNumber decimalNumber = new DecimalNumber(value);
        return decimalNumber;
    }

    @Override
    public int getValue() {
        return this.decimalNumber;
    }

    @Override
    public String toString() {
        return "DecimalNumber:" + decimalNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DecimalNumber)) return false;
        DecimalNumber that = (DecimalNumber) o;
        return decimalNumber == that.decimalNumber;
    }
}
