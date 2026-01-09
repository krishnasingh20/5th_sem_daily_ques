class Solution {
    HashMap<String, Integer> map;
    public int ladderLength(String start, String end, List<String> wordList) {
        map = new HashMap<>();
        int n = wordList.size();
        for(int i = 0; i < n; i++) {
            map.put(wordList.get(i), i);
        }
        int len = n;
        if(!map.containsKey(start)) {
            map.put(start, n);
            len++;
        }
        int[] steps = new int[len];
        Arrays.fill(steps, Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 1));
        Integer idx2 = map.get(end);
        if(idx2 == null) {
            return 0;
        }
        int idx1 = map.get(start);
        steps[idx1] = 1;
        while(!q.isEmpty()) {
            Pair rv = q.poll();
            idx1 = map.get(rv.s);
            if(idx1 == idx2) {
                return rv.step;
            }
            for(String s: wordList) {
                idx1 = map.get(s);
                if(steps[idx1] <= rv.step+1 || diff(rv.s, s) > 1 ) {
                    continue;
                }
                steps[idx1] = rv.step+1;
                q.add(new Pair(s, rv.step+1));
            }
        }
        return 0;
    }
    public int diff(String s1, String s2) {
        int i = 0;
        int n = s1.length();
        int c = 0;
        while(i < n) {
            if(s1.charAt(i) != s2.charAt(i)) {
                c++;
            }
            i++;
        }
        return c;
    }
    class Pair{
        String s;
        int step;
        Pair(String s, int step) {
            this.s = s;
            this.step = step;
        }
    }
}