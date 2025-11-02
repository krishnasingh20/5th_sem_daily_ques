class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int val = nums[0];
        int i = 0;
        List<Integer> ll = new ArrayList<>();
        while(i < nums.length) {
            if(nums[i] != val) {
                ll.add(val);
                val++;
                continue;
            }
            val++;
            i++;
        }
        return ll;
    }
}