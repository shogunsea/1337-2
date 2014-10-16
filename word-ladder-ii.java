public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> tempList = new ArrayList<String>();
        Map<String, Set<String>> graph = buildGraph(start, end, dict);
        if (graph == null) {
            return  res;
        }

        tempList.add(start);
        retrievePath(graph, res, tempList, start, end);

        return res;
    }

    public void retrievePath(Map<String, Set<String>> graph, List<List<String>> res, List<String> tempList, String start, String end) {
        for (String s : graph.get(start)) {
            tempList.add(s);
            if (s.equals(end)) {
                res.add(new ArrayList<String>(tempList));
            } else {
                retrievePath(graph, res, tempList, s, end);
            }
            tempList.remove(tempList.size() - 1);
        }
    }


    public Map<String, Set<String>> buildGraph(String sink, String source, Set<String> dict) {
        Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
        // starting from the source, which is the 'end' string, each step change 
        // one character in the string, if its valid dict word and is not dups with
        // previous level, add it to the next level, and create
        // a map from that string to possible strings it can be transformed to.
        Set<String> previous = new HashSet<String>();
        Set<String> current = new HashSet<String>();
        boolean reachedSink = false;
        current.add(source);

        while (!current.isEmpty()) {
            Set<String> nextLevel = new HashSet<String>();
            for (String s : current) {
                char[] ss = s.toCharArray();
                for (int i = 0; i < ss.length; i++) {
                    char c = ss[i];
                    for (char a = 'a'; a <= 'z'; a++) {
                        if (a == c) {
                            continue;
                        }

                        ss[i] = a;
                        String tempString = new String(ss);
                        if (dict.contains(tempString) && !previous.contains(tempString) && !current.contains(tempString)) {
                            // dont check if current contains the string or not here. 
                            nextLevel.add(tempString);
                            if (!graph.containsKey(tempString)) {
                                graph.put(tempString, new HashSet<String>());
                            }
                            // create mapping record.
                            graph.get(tempString).add(s);
                            if (tempString.equals(sink)) {
                                reachedSink = true;
                            }
                        }
                    }
                    // revert char array back
                    ss[i] = c;
                }
            }
            previous = current;
            current = nextLevel;
        }

        if (reachedSink) {
            return graph;
        } else {
            return null;
        }
    }

}