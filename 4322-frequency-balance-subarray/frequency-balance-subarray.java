class Solution {
    public int getLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        int[] map2 = new int[1001];
        int ans = 0;

        for(int i = 0; i < n; i++) {

            int cnt = 0;

            for(int j = i; j < n; j++) {

                int val = map1.getOrDefault(nums[j], 0) + 1;
                map1.put(nums[j], val);

                if(val == 1) {
                    map2[1] += 1;
                    if(map2[1] == 1) {
                        cnt++;
                    }
                }
                else {
                    int val1 = map2[val-1];
                    if(val1 == 1) {
                        map2[val-1] = 0;
                        cnt--;
                    }
                    else {
                        map2[val-1] = val1 - 1;
                    }
                    map2[val] += 1;
                    if(map2[val] == 1) {
                        cnt++;
                    }
                }

                if(map1.size() == 1) {
                    ans = Math.max(ans, (j - i + 1));
                }
                else if(cnt == 2 && ((val <= 500 && map2[2*val] > 0) || ((val & 1) == 0 && map2[val/2] > 0))) {
                    ans = Math.max(ans, (j - i + 1));
                }
            }

            map1.clear();
            Arrays.fill(map2, 0);
        }

        return ans;
    }
}