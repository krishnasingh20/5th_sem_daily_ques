class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        int ans = Integer.MAX_VALUE;
        for(List<Integer> ll: map.values()) {
            if(ll.size() < 3) {
                continue;
            }
            for(int i = 0; i <= ll.size()-3; i++) {
                int a = ll.get(i);
                int b = ll.get(i+1);
                int c = ll.get(i+2);
                ans = Math.min(ans, (b-a)+(c-b)+(c-a));
            }
        }
        return ans == Integer.MAX_VALUE?-1:ans;
    }
}