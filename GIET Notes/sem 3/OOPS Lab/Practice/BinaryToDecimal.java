public class BinaryToDecimal {
    public static void main(String[] args) {
        int decimalValue = 0;
        int binaryValue = 1101; 

        int base = 0;

        while(binaryValue != 0){
            decimalValue += ((binaryValue%10)*Math.pow(2,base++));
            binaryValue = binaryValue / 10;
        }
        System.out.println(decimalValue);
    }
}
