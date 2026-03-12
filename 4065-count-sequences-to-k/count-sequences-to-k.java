class Solution {
    public int countSequences(int[] nums, long k) {
        return count(nums, 0, 1, 1, k);
    }

    HashMap<String, Integer> dp = new HashMap<>();

    private int count(int[] nums, int i, long val, long div, long k) {
        if(i == nums.length) {
            if(k*div == val) {
                return 1;
            }
            return 0;
        }

        String key = i+"/"+val+"/"+div+"/"+k;

        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        int ans = 0;

        ans += count(nums, i+1, val*nums[i], div, k);//divide
        ans += count(nums, i+1, val, div*nums[i], k);//multiply
        ans += count(nums, i+1, val, div, k);//unchanged

        dp.put(key, ans);
        
        return ans;
    }
}