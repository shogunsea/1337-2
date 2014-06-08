// Given an integer, convert it to a roman numeral.
//
// Input is guaranteed to be within the range from 1 to 3999.
//
public class Solution {
    public static String intToRoman(int num) {
        if( num == 0){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int weight = (int)Math.log10(num);

        while(num > 0){
            int power =(int) Math.pow(10, weight);
            int currentBit =  num / power;
            num = num - power * currentBit;
            append(sb, currentBit, weight);
            weight--;
        }

        return sb.toString();
    }

    public static void append(StringBuilder sb, int bit, int weight){
        if(weight == 3){
            while(bit-- > 0){
                sb.append('M');
            }
        }else if(weight == 2){
            buildRoman(sb, "M", "D", "C", bit);
        }else if(weight == 1){
            buildRoman(sb, "C", "L", "X", bit);
        }else if(weight == 0){
            buildRoman(sb, "X", "V", "I", bit);
        }
    }

    public static void buildRoman(StringBuilder sb, String ten, String five, String one, int bit){
        if(bit == 9){
            sb.append(one + ten);
        }else if(bit >= 5 ){
            sb.append(five);
            while(bit - 5 > 0){
                sb.append(one);
                bit--;
            }
        }else if(bit == 4){
            sb.append(one + five);
        }else{
            while(bit > 0){
                sb.append(one);
                bit--;
            }
        }
    }
}
