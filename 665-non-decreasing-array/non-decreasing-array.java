class Solution {
    public boolean checkPossibility(int[] nums) {
        int count1 = 0;
        int n = nums.length;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }
        for(int i = 1; i < n; i++) {
            if(nums[i] < nums[i-1]) {
                count1++;
                nums[i] = nums[i-1];
            }
        }
        int count2 = 0;
        for(int i = n-2; i >= 0; i--) {
            if(arr[i] > arr[i+1]) {
                count2++;
                arr[i] = arr[i+1];
            }
        }
        count1 = Math.min(count1, count2);
        return count1 > 1?false:true;
    }
}