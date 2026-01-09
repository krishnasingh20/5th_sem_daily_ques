class Solution {
    public int ladderLength(String start, String end, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        if(!words.contains(end)) {
            return 0;
        }
        int l = start.length();
        Queue<String> q = new LinkedList<>();
        q.add(start);
        int step = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                String rv = q.poll();
                if(rv.equals(end)) {
                    return step;
                }
                for(int i = 0; i < l; i++) {
                    for(int j = 0; j < 26; j++) {
                        char c = (char)(j+'a');
                        if(c == rv.charAt(i)) {
                            continue;
                        }
                        String newStr = rv.substring(0, i)+c+rv.substring(i+1);
                        if(words.contains(newStr)) {
                            q.add(newStr);
                            words.remove(newStr);
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }
}