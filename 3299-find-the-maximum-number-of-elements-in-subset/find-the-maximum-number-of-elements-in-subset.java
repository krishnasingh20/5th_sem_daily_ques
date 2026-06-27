class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> map = new HashMap<>();
        int n = nums.length;
        long limit = 0;

        for (int i = 0; i < n; i++) {
            long num = nums[i];
            limit = Math.max(limit, num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;

        for (long key : map.keySet()) {
            long x = key;
            int curr = 1;

            if (x == 1) {
                curr = map.get(x);
                if ((curr & 1) == 0) {
                    curr--;
                }
                ans = Math.max(ans, curr);
                continue;
            }

            while (x * x <= limit && map.containsKey(x * x) && map.get(x) > 1) {
                curr += 2;
                x = x * x;
            }

            ans = Math.max(ans, curr);
        }

        return ans;
    }
}