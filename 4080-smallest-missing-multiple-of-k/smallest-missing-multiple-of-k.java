class Solution {
    public int missingMultiple(int[] nums, int k) {
        int ans = k;
        int mul = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        while(set.contains(ans*mul)) {
            mul++;
        }
        return ans*mul;
    }
}