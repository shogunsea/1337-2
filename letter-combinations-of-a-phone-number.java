// Given a digit string, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below.



// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// Note:
// Although the above answer is in lexicographical order, your answer could be in any order you want.

public class Solution {
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();

        if(digits == null || digits.length() == 0){
            list.add(digits);
            return list;
        }

        StringBuilder sb = new StringBuilder();

        int start = 0;
        while(digits.charAt(start) == '1'){
            start++;
        }

        dfs(digits, list, sb, start);

        return list;
    }

    public static void dfs(String digits, List<String> list, StringBuilder sb, int index){
        if(index == digits.length()){
            String temp = sb.toString();
            list.add(temp);
            return;
        }

        char[] chars = mapping(digits.charAt(index) - '0');

        for(int i = 0; i < chars.length; i++){
            sb.append(chars[i]);
            dfs(digits, list, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static char[] mapping(int n){
        char[] chars;

        switch(n){
            case 0:
                chars = new char[] {' '};
                break;
            case 1:
                chars = new char[] {};
                break;
            case 2:
                chars = new char[] {'a', 'b', 'c'};
                break;
            case 3:
                chars = new char[] {'d', 'e', 'f'};
                break;
            case 4:
                chars = new char[] {'g', 'h', 'i'};
                break;
            case 5:
                chars = new char[] {'j', 'k', 'i'};
                break;
            case 6:
                chars = new char[] {'m', 'n', 'o'};
                break;
            case 7:
                chars = new char[] {'p', 'q', 'r', 's'};
                break;
            case 8:
                chars = new char[] {'t', 'u', 'v'};
                break;
            case 9:
                chars = new char[] {'w', 'v', 'x', 'y', 'z'};
                break;
            default:
                chars = new char[] {};
        }

        return chars;
    }
}


public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        int len = digits.length();

        if (len == 0) {
            res.add("");
            return res;
        }

        StringBuilder sb = new StringBuilder();
        Map<Integer, char[]> map = buildMap();
        dfsHelper(res, sb, map, digits, 0);

        return res;
    }

    public void dfsHelper(List<String> res, StringBuilder sb, Map<Integer, char[]> map, String digits, int index) {
        if (index == digits.length()) {
            // found a valid match.
            res.add(sb.toString());
            return;
        }

        int num = digits.charAt(index) - '0';
        char[] candidates = map.get(num);

        for (int i = 0; i < candidates.length; i++) {
            sb.append(candidates[i]);
            dfsHelper(res, sb, map, digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public Map<Integer, char[]> buildMap() {
        Map<Integer, char[]> map = new HashMap<Integer, char[]>();
        map.put(2, "abc".toCharArray());
        map.put(3, "def".toCharArray());
        map.put(4, "ghi".toCharArray());
        map.put(5, "jkl".toCharArray());
        map.put(6, "mno".toCharArray());
        map.put(7, "pqrs".toCharArray());
        map.put(8, "tuv".toCharArray());
        map.put(9, "wxyz".toCharArray());
        return map;
    }
}