public class DecimalNumber extends GeneralNumber {

    private int decimalNumber;
    private BinaryNumber binaryNumber;

    public DecimalNumber(int decimalNumber) {
        this.decimalNumber = decimalNumber;
    }

    @Override
    public GeneralNumber integerToString(int value) {
        GeneralNumber decimalNumber = new DecimalNumber(value);
        return decimalNumber;
    }

    @Override
    public int StringToInteger(String value) {
        int number = Integer.parseInt(String.valueOf(binaryNumber), 2);
        return number;
    }

    @Override
    public int getValueDecimal(GeneralNumber value) {
        return value.StringToInteger(String.valueOf(value));
    }

    @Override
    public String toString() {
        return "DecimalNumber{" +
                "decimalNumber=" + decimalNumber +
                ", binaryNumber=" + binaryNumber +
                '}';
    }
}
