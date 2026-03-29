class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Integer> indegree = new HashMap<>();
      Map<Character, Set<Character>> adj = new HashMap<>();

        for(String word : words) {
            for(char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }


        for(int i = 0; i < words.length - 1;i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            int minLen = Math.min(w1.length(), w2.length());
            if(w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }
            for(int j = 0; j < minLen;j++) {

                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if(c1 != c2) {
                    if(!adj.get(c1).contains(c2)) {
                        adj.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();

        for(char c : indegree.keySet()) {
            if(indegree.get(c) == 0) {
                q.offer(c);
            }
        }

        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()) {
            char c = q.poll();
            res.append(c);
            for(char neighbor : adj.get(c)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if(indegree.get(neighbor) == 0) {
                    q.offer(neighbor);
                }
            }
        }

        if(res.length() != indegree.size()) {
            return "";
        }

        return res.toString();

    }
}
