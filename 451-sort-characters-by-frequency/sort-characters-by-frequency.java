class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        for(char ch: s.toCharArray()) {
            freq[ch]++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i = 0; i < 128; i++) {
            if(freq[i] > 0) {
                pq.add(new int[]{i, freq[i]});
            }
        }
        StringBuilder str = new StringBuilder();
        while(!pq.isEmpty()) {
            int[] val = pq.poll();
            char ch = (char)val[0];
            for(int i = 0; i < val[1]; i++) {
                str.append(ch);
            }
        }
        return str.toString();
    }
}