class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int rem =  nums[i] % value;
            if(rem < 0) {
                rem += value;
            }
            map.put(rem, map.getOrDefault(rem , 0)+1);
        }
        int ans = 0;
        int rem = ans % value;
        while(map.getOrDefault(rem, 0) > 0) {
            map.put(rem, map.get(rem)-1);
            ans++;
            rem = ans % value;
        }
        return ans;
    }
}