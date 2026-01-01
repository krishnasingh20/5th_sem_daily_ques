class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int[] inDegree = new int[n+2];
        for(int[] edge: edges) {
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }
        for(int i = 1; i < inDegree.length; i++) {
            if(inDegree[i] == n) {
                return i;
            }
        }
        return -1;
    }
}