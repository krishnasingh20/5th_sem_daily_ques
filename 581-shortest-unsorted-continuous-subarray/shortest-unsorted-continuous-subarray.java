class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int idx1 = -1;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] > nums[j]) {
                    idx1 = i;
                    break;
                } 
            }
            if(idx1 != -1) {
                break;
            }
        }

        if(idx1 == -1) {
            return 0;
        }

        int idx2 = -1;
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[j] > nums[i]) {
                    idx2 = i;
                    break;
                }
            }
            if(idx2 != -1) {
                break;
            }
        }

        return idx2 - idx1 + 1;
    }
}