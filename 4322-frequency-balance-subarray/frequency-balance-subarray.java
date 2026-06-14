class Solution {
    public int getLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int ans = 0;

        for(int i = 0; i < n; i++) {

            for(int j = i; j < n; j++) {

                int val = map1.getOrDefault(nums[j], 0) + 1;
                map1.put(nums[j], val);

                if(val == 1) {
                    map2.put(1, map2.getOrDefault(1, 0)+1);
                }
                else {
                    int val1 = map2.get(val-1);
                    if(val1 == 1) {
                        map2.remove(val-1);
                    }
                    else {
                        map2.put(val-1, val1-1);
                    }
                    map2.put(val, map2.getOrDefault(val, 0)+1);
                }

                if(map1.size() == 1) {
                    ans = Math.max(ans, (j - i + 1));
                }
                else if(map2.size() == 2 && (map2.containsKey(2*val) || ((val & 1) == 0 && map2.containsKey(val/2)))) {
                    ans = Math.max(ans, (j - i + 1));
                }
            }

            map1.clear();
            map2.clear();
        }

        return ans;
    }
}