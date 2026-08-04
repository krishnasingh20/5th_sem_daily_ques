class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int maxx = 0;
        int min = 101;

        for(int num: nums) {
            maxx = Math.max(maxx, num);
            min = Math.min(min, num);
        }

        boolean[] visit = new boolean[maxx+1];

        for(int num: nums) {
            visit[num] = true;
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = min; i <= maxx; i++) {
            if(!visit[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}