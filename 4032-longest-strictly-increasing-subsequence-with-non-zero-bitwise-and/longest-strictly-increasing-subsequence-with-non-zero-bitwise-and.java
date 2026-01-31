class Solution {
    public int longestSubsequence(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 31; i++) {
            List<Integer> lis = new ArrayList<>();
            for(int num: nums) {
                if((num & (1<<i)) != 0) {
                    if(lis.size() == 0 || lis.get(lis.size()-1) < num) {
                        lis.add(num);
                    }
                    else {
                        int idx = binarySearch(lis, num);
                        lis.set(idx, num);
                    }
                }
                ans = Math.max(ans, lis.size());
            }
        }
        return ans;
    }
    private int binarySearch(List<Integer> lis, int target) {
        int idx = 0;
        int low = 0;
        int high = lis.size()-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(lis.get(mid) >= target) {
                idx = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return idx;
    }
}