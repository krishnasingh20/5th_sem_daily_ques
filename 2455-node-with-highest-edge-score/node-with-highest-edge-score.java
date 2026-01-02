class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] score = new long[n];
        for(int i = 0; i < n; i++) {
            score[edges[i]] += i;
        }
        long max = -1;
        int node = -1;
        for(int i = 0; i < n; i++) {
            if(score[i] > max) {
                max = score[i];
                node = i;
            }
        }
        return node;
    }
}