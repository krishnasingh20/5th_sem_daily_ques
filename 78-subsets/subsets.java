class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subset(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
    public void subset(int[] nums, int i, List<Integer> ll, List<List<Integer>> ans) {
        if(i == nums.length) {
            ans.add(new ArrayList<>(ll));
            return;
        }
        subset(nums, i+1, ll, ans);
        ll.add(nums[i]);
        subset(nums, i+1, ll, ans);
        ll.remove(ll.size()-1);
    }
}