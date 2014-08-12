// Given an absolute path for a file (Unix-style), simplify it.

// For example,
// path = "/home/", => "/home"
// path = "/a/./b/../../c/", => "/c"
// click to show corner cases.

// Corner Cases:
// Did you consider the case where path = "/../"?
// In this case, you should return "/".
// Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
// In this case, you should ignore redundant slashes and return "/home/foo".


public class Solution {
    public String simplifyPath(String path) {
        int len = path.length();

        if(len == 0) return path;

        List<String> list = new ArrayList<String>();

        for(int i = 0; i < len; i++){
        	if(path.charAt(i) == '/') continue;

        	int j = i + 1;

        	while(j < len && path.charAt(j) != '/'){
                j++;
            }
            String tempString = path.substring(i, j);

            j--;
            i = j;
        	list.add(tempString);
        }

        Stack<String> st = new Stack<String>();

        for(String s : list){
        	if(st.isEmpty()){
        		if(s.equals(".") || s.equals("..")) continue;
        		st.push(s);
        	}else if(s.equals(".")){
        		continue;
        	}else if(s.equals("..")){
        		st.pop();
        	}else{
        		st.push(s);
        	}
        }

        if(st.isEmpty()){
        	return "/";
        }

        StringBuilder sb = new StringBuilder();

        for(String s : st){
        	sb.append("/" + s);
        }

        return sb.toString();
    }
}










