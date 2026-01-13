class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1;
            int right = n-1;
            while(left < right) {
                if(nums[i]+nums[left]+nums[right] == 0) {
                    List<Integer> ll = new ArrayList<>();
                    ll.add(nums[i]);
                    ll.add(nums[left]);
                    ll.add(nums[right]);
                    ans.add(ll);
                    while(left+1 < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while(right-1 > left && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(nums[i]+nums[left]+nums[right] > 0) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return ans;
    }
}