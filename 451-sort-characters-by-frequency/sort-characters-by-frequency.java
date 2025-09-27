class Solution {
    public String frequencySort(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.val - o1.val;
            }
        });
        int[] freq = new int[128];
        for(char c: s.toCharArray()) {
            freq[c]++;
        }
        for(int i = 0; i < 128; i++) {
            if(freq[i] > 0) {
                pq.add(new Pair((char)i, freq[i]));
            }
        }
        StringBuilder str = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int len = p.val;
            while(len > 0) {
                str.append(p.ch);
                len--;
            }
        }
        return str.toString();
    }
    class Pair {
        char ch;
        int val;
        Pair(char ch, int val) {
            this.ch = ch;
            this.val = val;
        }
    }
}