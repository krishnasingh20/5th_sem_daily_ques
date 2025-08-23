class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int num: nums) {
            if(map.containsKey(num-1)) {
                map.put(num, false);
            }
            else {
                map.put(num, true);
            }
            if(map.containsKey(num+1)) {
                map.put(num+1, false);
            }
        }
        int ans = 0;
        for(int key: map.keySet()) {
            if(map.get(key)) {
                int count = 0;
                while(map.containsKey(key)) {
                    count++;
                    key++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}