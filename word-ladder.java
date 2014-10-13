public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        Queue<Integer> steps = new LinkedList<Integer>();
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        visited.add(start);
        queue.add(start);
        steps.add(1);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int step = steps.poll();

            char[] chars = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char c = chars[i];
                for (char a = 'a'; a <= 'z'; a++) {
                    if (a == c) {
                        continue;
                    }

                    chars[i] = a;
                    String newWord = new String(chars);
                    if (dict.contains(newWord) && !visited.contains(newWord)) {
                        if (newWord.equals(end)) {
                            return step + 1;
                        }

                        visited.add(newWord);
                        steps.add(step + 1);
                        queue.add(newWord);
                    }
                }
                chars[i] = c;
            }
        }

        return 0;
    }
}


public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        queue.add(end);
        visited.add(end);
        int len = start.length();
        boolean reachedStart = false;
        // use bfs to build a graph, that maps each sting to possible alterations.
        while (!queue.isEmpty()) {
            String oldWord = queue.poll();
            char[] chars = oldWord.toCharArray();
            for (int i = 0; i < len; i++) {
                char c = chars[i];
                for (char a = 'a'; a <= 'z'; a++) {
                    if (a == c) {
                        continue;
                    }
                    chars[i] = a;
                    String newWord = new String(chars);
                    if (dict.contains(newWord) && !visited.contains(newWord)) {
                        visited.add(newWord);
                        if (newWord.equals(start)) {
                            reachedStart = true;
                        }
                        if (!graph.containsKey(newWord)) {
                            graph.put(newWord, new HashSet<String>());
                        }
                        graph.get(newWord).add(oldWord);
                        queue.add(newWord);
                    }
                }
                chars[i] = c;
            }

            if (reachedStart) {
                break;
            }
        }

        if (!reachedStart) {
            return 0;
        }

        int minLen = 1;
        String runner = start;

        while (!runner.equals(end)) {
            minLen++;
            for (String s : graph.get(runner)) {
                runner = s;
                break;
            }
        }

        return minLen;
    }
}