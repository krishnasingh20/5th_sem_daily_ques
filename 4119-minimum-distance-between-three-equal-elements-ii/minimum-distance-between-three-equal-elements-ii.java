class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        int[][] arr = new int[n+1][2];

        for(int[] a: arr) {
            Arrays.fill(a, -1);
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            if(arr[nums[i]][0] == -1) {
                arr[nums[i]][0] = arr[nums[i]][1];
                arr[nums[i]][1] = i;
            }
            else {
                int dist = (arr[nums[i]][1] - arr[nums[i]][0]) + (i - arr[nums[i]][1]) + (i - arr[nums[i]][0]);
                ans = Math.min(ans, dist);
                arr[nums[i]][0] = arr[nums[i]][1];
                arr[nums[i]][1] = i;
            }
        }

        return ans==Integer.MAX_VALUE?-1:ans;
    }
}