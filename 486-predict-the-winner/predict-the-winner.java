class Solution {
    public boolean predictTheWinner(int[] nums) {
        
        int scoreA = maxScore(nums, 0, nums.length-1);

        int totalSum = 0;
        for(int num: nums) {
            totalSum += num;
        }

        return scoreA >= totalSum - scoreA;
    }

    public int maxScore(int[] nums, int i, int j) {
        if(i > j) {
            return 0;
        }

        if(i == j) {
            return nums[i];
        }

        int a = nums[i] + Math.min(maxScore(nums, i+2, j), maxScore(nums, i+1, j-1));
        int b = nums[j] + Math.min(maxScore(nums, i+1, j-1), maxScore(nums, i, j-2));

        return Math.max(a, b);
    }
}