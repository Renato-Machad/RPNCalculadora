public class BinaryNumber extends GeneralNumber {

    private String binaryNumber;

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
    public int StringToInteger() {
        return 0;
    }
}
