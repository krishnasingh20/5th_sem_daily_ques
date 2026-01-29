class Solution {
    public int tupleSameProduct(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int k = 0;
                int l = n-1;
                while(k < i && l > j) {
                    if(nums[k]*nums[l] == nums[i]*nums[j]) {
                        ans += 8;
                        k++;
                        l--;
                    }
                    else if(nums[k]*nums[l] > nums[i]*nums[j]) {
                        l--;
                    }
                    else {
                        k++;
                    }
                }
            }
        }
        return ans;
    }
}