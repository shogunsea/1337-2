// Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

// Only one letter can be changed at a time
// Each intermediate word must exist in the dictionary
// For example,

// Given:
// start = "hit"
// end = "cog"
// dict = ["hot","dot","dog","lot","log"]
// As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// return its length 5.

// Note:
// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.


public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        Set<String> visited = new HashSet<String>();
        Queue<String> words = new LinkedList<String>();
        Queue<Integer> steps = new LinkedList<Integer>();

        visited.add(start);
        words.add(start);
        steps.add(1);

        while(!words.isEmpty()){
        	String word = words.poll();
        	int step = steps.poll();
        	if(word.equals(end)){
        		return step;
        	}

        	for(int i = 0; i < word.length(); i++){
        		char[] chars = word.toCharArray();
        		for(char c = 'a'; c <= 'z'; c++){
        			if(c == chars[i]) continue;
        			chars[i] = c;
        			String tempString = new String(chars);
        			if(dict.contains(tempString) && !visited.contains(tempString)){
        				visited.add(tempString);
        				words.add(tempString);
        				steps.add(step + 1);
        			}
        		}
        	}
        }
        return 0;
    }
}