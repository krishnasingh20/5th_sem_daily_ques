class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean[] weakTeam = new boolean[n];
        for(int[] edge: edges) {
            weakTeam[edge[1]] = true;
        }
        int idx = -1;
        for(int i = 0; i < n; i++) {
            if(!weakTeam[i]) {
                if(idx != -1) {
                    return -1;
                }
                idx = i;
            }
        }
        return idx;
    }
}