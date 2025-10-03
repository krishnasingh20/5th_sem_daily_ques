class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        combination(candidates, target, 0, ans, ll);
        return ans;
    }
    public void combination(int[] candidates, int target, int idx, List<List<Integer>> ans, List<Integer> ll) {
        if(target == 0) {
            ans.add(new ArrayList<>(ll));
            return;
        }
        for(int i = idx; i < candidates.length; i++) {
            if(i > idx && candidates[i] == candidates[i-1]) {
                continue;
            }
            if(candidates[i] <= target) {
                ll.add(candidates[i]);
                combination(candidates, target - candidates[i], i+1, ans, ll);
                ll.remove(ll.size()-1);
            }
        }
    }
}