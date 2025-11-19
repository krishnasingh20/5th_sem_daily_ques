class Solution {
    public int findFinalValue(int[] nums, int o) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        while(set.contains(o)) {
            o *= 2;
        }
        return o;
    }
}