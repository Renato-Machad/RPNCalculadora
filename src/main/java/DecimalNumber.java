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
    public int StringToInteger(String value) {
        int number = Integer.parseInt(String.valueOf(binaryNumber),2);
        return number;
    }

    @Override
    public int getValueDecimal(GeneralNumber value) {
        return value.StringToInteger(String.valueOf(value));
    }

    @Override
    public GeneralNumber converterStackIntoInt(int value) {
        GeneralNumber valueGeneral = new BinaryNumber(value);
        return valueGeneral;
    }

}
