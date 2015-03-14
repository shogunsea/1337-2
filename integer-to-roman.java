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




public class Solution {
    private static class RomanDigit{
        char digit;
        char mid;
        char max;
        int val;
        RomanDigit(int weight, int val){
            this.val = val;
            switch(weight){
                case 1:
                    this.digit = 'I';
                    this.mid = 'V';
                    this.max = 'X';
                    break;
                case 10:
                    this.digit = 'X';
                    this.mid = 'L';
                    this.max = 'C';
                    break;
                case 100:
                    this.digit = 'C';
                    this.mid = 'D';
                    this.max = 'M';
                    break;
                case 1000:
                    this.digit = 'M';
                    break;
                default:
                    this.digit = ' ';
                    break;
            }
        }

        public  String getString(){
            StringBuilder sb = new StringBuilder();
            // build the string here
            if(this.val == 4){
                sb.append(this.digit);
                sb.append(this.mid);
            }else if(this.val == 9){
                sb.append(this.digit);
                sb.append(this.max);
            }else if(this.val == 5){
                sb.append(this.mid);
            }else if(this.val < 5){
                for(int i = 0; i < this.val; i++){
                    sb.append(this.digit);
                }
            }else if(this.val > 5){
                sb.append(this.mid);
                for(int i = 0; i < this.val - 5; i++){
                    sb.append(this.digit);
                }
            }
            return sb.toString();
        }
    }
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int digits = 0;
        int counter = num;
        while(counter > 0){
            counter /= 10;
            digits++;
        }

        while(digits != 0){
            int weight = (int) Math.pow(10, digits - 1);
            int val = num / weight;
            num -= (val * weight);
            RomanDigit rd = new RomanDigit(weight, val);
            sb.append(rd.getString());
            digits--;
        }

        return sb.toString();
    }
    
    // mappping from int to roman
    // 1     I
    // 2     II
    // 3     III
    // 4     IV
    // 5     V
    // 6     VI
    // 7     VII
    // 8     VIII
    // 9     IX
    // 10    X
    // 40    XL
    // 50    L
    // 90    XC
    // 100   C
    // 400   CD
    // 500   D
    // 900   CM
    // 1000  M
}


public class Solution {
    public String intToRoman(int num) {
        Map<Integer, Character> map = buildMap();
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            int pow = (int) Math.log10(num);
            int base = (int) Math.pow(10, pow);
            int count = num / base;

            if (count == 4) {
                int nextBase = base * 5;
                char first = map.get(base);
                char second = map.get(nextBase);
                sb.append(first);
                sb.append(second);
            } else if (count == 9) {
                int nextBase = base * 10;
                char first = map.get(base);
                char second = map.get(nextBase);
                sb.append(first);
                sb.append(second);
            } else {
                int five = count / 5;
                int one = count % 5;
                char oneChar = map.get(base);
            
                if (five == 1) {
                    char fiveChar = map.get(base * 5);
                    sb.append(fiveChar);
                }       

                for (int i = 0; i < one; i++) {
                    sb.append(oneChar);
                }       
            }

            num = num - base * count;
        }

        return sb.toString();
    }

    public Map<Integer, Character> buildMap() {
        Map<Integer, Character> map = new HashMap<Integer, Character>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');

        return map;
    }
}