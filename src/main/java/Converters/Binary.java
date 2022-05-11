package Converters;

public interface Binary {

    public static String integerToBinary(int number) {
        String binaryString = Integer.toBinaryString(number);
        return binaryString;
    }

    public static int binaryToInteger (String binaryNumber){
        int number = Integer.parseInt(binaryNumber,2);
        return number;
    }
}
