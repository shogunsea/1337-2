// Evaluate the value of an arithmetic expression in Reverse Polish Notation.

// Valid operators are +, -, *, /. Each operand may be an integer or another expression.

// Some examples:
//   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

public class Solution {
    public static int evalRPN(String[] tokens) {
        int len = tokens.length;

        if(len == 0){
            return 0;
        }

        Stack<Integer> st = new Stack<Integer>();

        for(String s : tokens){
            if(!isOperator(s)){
                st.push(Integer.parseInt(s));
            }else{
                int right = st.pop();
                int left = st.pop();
                int result = calc(right, left, s);
                st.push(result);
            }
        }

        return st.pop();
    }

    public static boolean isOperator(String s){
        if(s.length() > 1){
            return false;
        }
        char c = s.charAt(0);
        if(c == '+' || c == '-' || c == '*' || c == '/' ){
            return true;
        }

        return false;
    }

    public static int calc(int right, int left, String s){
        char c = s.charAt(0);
        switch(c){
            case '+' : return right + left;
            case '-' : return left - right;
            case '*' : return left * right;
            case '/' : return left / right;
        }
        return 0;
    }
}
