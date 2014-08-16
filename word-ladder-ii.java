public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	List<List<String>> result = new ArrayList<List<String>>();
    	if(dict == null || dict.size() == 0) return result;

    	HashMap<String, Set<String>> graph = new HashMap<String, Set<String>>();

    	buildGraphBFS(graph, start, end, dict);

    	List<String> tempList = new ArrayList<String>();

    	if(graph.containsKey(start)){
    		tempList.add(start);
    	}

    	getPathsDFS(graph, start, dict, result, tempList);

    	return result;
    }

    private void buildGraphBFS(HashMap<String, Set<String>> graph, String sink, String source, Set<String> dict){
    	Set<String> previous = null;
    	Set<String> current = new HashSet<String>();
    	current.add(source);
    	boolean reachedSink = false;

    	while(!current.isEmpty()){
    		Set<String> newLevel = new HashSet<String>();

    		for(String word : current){
    			char[] chars = word.toCharArray();
    			for(int i = 0; i < chars.length; i++){
    				char c = chars[i];
    				for(char rep = 'a'; rep <= 'z'; rep++){
    					if(rep == c) continue;
    					chars[i] = rep;

    					String newWord = new String(chars);

    					if(newWord.equals(sink)) reachedSink = true;

    					if(!newWord.equals(sink)&&!dict.contains(newWord) || current.contains(newWord) || previous != null && previous.contains(newWord)){
    						continue;
    					}

    					if(!graph.containsKey(newWord)){
    						graph.put(newWord, new HashSet<String>());
    					}

    					newLevel.add(newWord);
    					graph.get(newWord).add(word);
    				}
    				chars[i] = c;
    			}
    		}

    		if(newLevel.isEmpty()) break;

    		previous = current;
    		current = newLevel;
    	}

    	if(!reachedSink){
    		graph.clear();
    	}
    }

    //getPathsDFS(graph, start, end, dict, result, tempList);
    private void getPathsDFS(HashMap<String, Set<String>> graph, String nextWord, Set<String> dict, List<List<String>> result, List<String> tempList){
    	if(!graph.containsKey(nextWord)){
    		if(tempList.size() != 0){
    			result.add(new ArrayList<String>(tempList));
    		}
    		return;
    	}

    	for(String word : graph.get(nextWord)){
    		tempList.add(word);
    		getPathsDFS(graph, word, dict, result, tempList);
    		tempList.remove(tempList.size() - 1);
    	}
    }
}