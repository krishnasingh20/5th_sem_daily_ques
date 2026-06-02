class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int[] arr1 = new int[landStartTime.length];
        int[] arr2 = new int[waterStartTime.length];
        for(int i = 0; i < landStartTime.length; i++) {
            arr1[i] = landStartTime[i] + landDuration[i];
        }
        for(int i = 0; i < waterStartTime.length; i++) {
            arr2[i] = waterStartTime[i] + waterDuration[i];
        }
        int ans = Integer.MAX_VALUE;
        for(int i  = 0; i< landStartTime.length; i++) {
            for(int j = 0; j < waterStartTime.length; j++) {
                if(waterStartTime[j] <= arr1[i]) {
                    ans = Math.min(ans, arr1[i] + waterDuration[j]);
                }
                else {
                    ans = Math.min(ans, arr2[j]);
                }
            }
        }
        for(int i  = 0; i< waterStartTime.length; i++) {
            for(int j = 0; j < landStartTime.length; j++) {
                if(landStartTime[j] <= arr2[i]) {
                    ans = Math.min(ans, arr2[i] + landDuration[j]);
                }
                else {
                    ans = Math.min(ans, arr1[j]);
                }
            }
        }
        return ans;
    }
}