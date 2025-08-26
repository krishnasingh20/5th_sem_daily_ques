class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double diaLength = 0.0;
        int ans = 0;
        for(int[] dimen:dimensions) {
            double temp = Math.sqrt((dimen[0]*dimen[0] + dimen[1]*dimen[1]));
            if(temp > diaLength) {
                ans = dimen[0]*dimen[1];
                diaLength = temp;
            }
            else if(temp == diaLength) {
                if(dimen[0]*dimen[1] > ans) {
                    ans = dimen[0]*dimen[1];
                }
            }
        }
        return ans;
    }
}