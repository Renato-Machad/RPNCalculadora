public class DecimalNumber extends GeneralNumber{

    private int decimalNumber;
    private BinaryNumber binaryNumber;

    public DecimalNumber(int decimalNumber){
        this.decimalNumber = decimalNumber;
    }

    @Override
    public  GeneralNumber integerToString(int value) {
        return null;
    }

    @Override
    public int StringToInteger() {
        int number = Integer.parseInt(String.valueOf(binaryNumber),2);
        return number;
    }

}
