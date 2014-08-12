// Given a string containing only digits, restore it by returning all possible valid IP address combinations.

// For example:
// Given "25525511135",

// return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

public class Solution {
    public List<String> restoreIpAddresses(String s) {
    	List<String> list = new ArrayList<String>();
    	List<String> tempList = new ArrayList<String>();

    	int len = s.length();

    	if(len == 0) return list;

    	for(int i = 1; i < len && i <= 3; i++){
    		String tempString = s.substring(0, i);
    		if(i >= 2 && tempString.charAt(0) == '0') continue;
    		int tempInt = Integer.parseInt(tempString);
    		if(tempInt >= 0 && tempInt <= 255){
    			tempList.add(tempString);
    			dfs(list, tempList, s, i);
    			tempList.remove(tempList.size() - 1);
    		}
    	}

    	return list;
    }

    public void dfs(List<String> list, List<String> tempList, String s, int index){
    	if(tempList.size() == 4){
    		if(index >= s.length()){
    			list.add(tempList.get(0) + "." + tempList.get(1) + "." + tempList.get(2) + "." + tempList.get(3));
    		}
    		return;
    	}

    	for(int i = 1; i + index <= s.length() && i <= 3; i++){
    		String tempString = s.substring(index, index + i);
    		if(i >= 2 && tempString.charAt(0) == '0') continue;
    		int tempInt = Integer.parseInt(tempString);
    		if(tempInt >= 0 && tempInt <= 255){
    			tempList.add(tempString);
    			dfs(list, tempList, s, index + i);
    			tempList.remove(tempList.size() - 1);
    		}
    	}
    }
}