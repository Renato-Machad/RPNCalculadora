public class DecimalNumber extends GeneralNumber {

    private int decimalNumber;

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
        int number = Integer.parseInt(value);
        return number;
    }

    @Override
    public int getValueDecimal(GeneralNumber value) {
        return this.decimalNumber;
    }

    @Override
    public String toString() {
        return "DecimalNumber:" + decimalNumber ;
    }
}
