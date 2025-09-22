class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
            max = Math.max(max, map.get(num));
        }
        int ans = 0;
        for(int key: map.keySet()) {
            if(map.get(key) == max) {
                ans += max;
            }
        }
        return ans;
    }
}