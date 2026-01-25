class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long x = 1;
        long ans = 0;
        for(int i = 0; i < nums.length && k > 0; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            if(nums[i] == x) {
                x++;
                continue;
            }
            long d = nums[i] - x;
            if(d >= k) {
                long n1 = ((x+k-1)*(x+k))/2;
                long n2 = ((x-1)*x)/2;
                ans += (n1 - n2);
                k = 0;
            }
            else {
                long n1 = ((nums[i]-1)*(long)nums[i])/2;
                long n2 = ((x-1)*x)/2;
                k -= d;
                ans += n1 - n2;
            }
            x = nums[i]+1;
        }
        if(k > 0) {
            long n1 = (x+k-1)*(x+k)/2;
            long n2 = ((x-1)*x)/2;
            ans += (n1 - n2);
        }
        return ans;
    }
}