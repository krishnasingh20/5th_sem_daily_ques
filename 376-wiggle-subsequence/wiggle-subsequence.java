class Solution {
    public int wiggleMaxLength(int[] nums) {
        HashMap<String, Integer> dp = new HashMap<>();
        return wiggle(nums, 0, 0, -1, dp);
    }
    public int wiggle(int[] arr, int i, int state, int prev, HashMap<String, Integer> dp) {
        if(i == arr.length) {
            return 0;
        }
        String key = i+"/"+state+"/"+prev;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }
        int ans = 0;
        // pick
        if(prev != -1) {
            if(arr[prev] - arr[i] > 0) {
                if(state == 0 || state == 1) {
                    int a = 1 + wiggle(arr, i+1, 2, i, dp);
                    ans = Math.max(ans, a);
                }
            }
            else if(arr[prev] - arr[i] < 0) {
                if(state == 0 || state == 2) {
                    int a = 1 + wiggle(arr, i+1, 1, i, dp);
                    ans = Math.max(ans, a);
                }
            }
        }
        else {
            int b = 1 + wiggle(arr, i+1, 0, i, dp);
            ans = Math.max(ans, b);
        }
        // no pick
        int c = wiggle(arr, i+1, state, prev, dp);
        ans = Math.max(ans, c);
        dp.put(key, ans);
        return ans;
    }
}