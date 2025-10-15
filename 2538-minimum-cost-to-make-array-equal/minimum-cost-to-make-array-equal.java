class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        long total = 0;
        for(int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = cost[i];
            total += cost[i];
        }
        Arrays.sort(arr, (a, b)-> a[0]-b[0]);
        long ans = 0;
        long curr = 0;
        int idx = -1;
        for(int i = 0; i < n; i++) {
            curr += arr[i][1];
            if(2 * curr >= total) {
                idx = i;
                break;
            }
        }
        int x = arr[idx][0];
        for(int i = 0; i < n; i++) {
            ans += (int)Math.abs(arr[i][0] - x)*(long)arr[i][1];
        }
        return ans;
    }
}

// weighted median concept to find the equlibrium point where the current cost is greater then equal to half of the total cost , so at that point give us the minimum operation cost to make array element equal