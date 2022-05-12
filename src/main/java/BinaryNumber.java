public class BinaryNumber extends GeneralNumber {

    private String binaryNumber;

    public BinaryNumber(String value) {
        this.binaryNumber = value;

    public BinaryNumber(String binaryNumber){
        this.binaryNumber = binaryNumber;
    }

    @Override
    public GeneralNumber integerToString(int value) {
        String binaryString = Integer.toBinaryString(value);
        BinaryNumber binaryNumber = new BinaryNumber(binaryString);
        return binaryNumber;
    }

    @Override
    public int StringToInteger(String value) {
        return 0;
    }

    @Override
    public int getValueDecimal(GeneralNumber value) {
        return value.StringToInteger(String.valueOf(value));
    }

    @Override
    public String toString() {
        return "BinaryNumber{" +
                "binaryNumber='" + binaryNumber + '\'' +
                '}';
    }
}
