class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        int[][] arr = new int[score.length][2];
        for(int i = 0; i < score.length; i++) {
            arr[i][0] = score[i][k];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a,b)->b[0]-a[0]);
        int[][] ans = new int[score.length][score[0].length];
        for(int i =0; i < score.length; i++) {
            int idx = arr[i][1];
            for(int j = 0; j < score[0].length; j++) {
                ans[i][j] = score[idx][j];
            }
        }
        return ans;
    }
}