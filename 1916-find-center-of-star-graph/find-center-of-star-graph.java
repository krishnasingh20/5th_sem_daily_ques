class Solution {
    public int findCenter(int[][] edges) {
        int[] inDegree = new int[edges.length+2];
        for(int[] edge: edges) {
            inDegree[edge[1]]++;
            inDegree[edge[0]]++;
        }
        for(int i = 1; i < inDegree.length; i++) {
            if(inDegree[i] == edges.length) {
                return i;
            }
        }
        return -1;
    }
}