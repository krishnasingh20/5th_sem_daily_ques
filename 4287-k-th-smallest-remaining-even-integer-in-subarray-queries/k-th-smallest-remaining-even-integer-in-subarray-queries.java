class Solution {
    public int[] kthRemainingInteger(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        TreeSet<Long> set = new TreeSet<>();
        HashMap<Long, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            if((nums[i] & 1) == 0) {
                prefix[i+1] = 1;
                set.add((long)nums[i]);
                map.put((long)nums[i], i);
            }
            prefix[i+1] += prefix[i];
        }

        int m = queries.length;
        int[] ans = new int[m];

        for(int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int k = queries[i][2];

            long low = 0;
            long high = 3000000000L;
            long temp = 0;

            while(low <= high) {
                long mid = low + (high - low)/2;

                Long val = mid > nums[r]?set.floor((long)nums[r]):set.floor(mid);
                long curr = 0;

                if(val != null) {

                    int idx = map.get(val);

                    if(idx >= l && idx <= r) {
                        curr = prefix[idx+1] - prefix[l];
                    }

                }

                long total = mid/2;
                long count = total - curr;

                if(count >= k) {
                    temp = mid;
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }

            if((temp & 1) == 1) {
                temp--;
            }

            ans[i] = (int)temp;
        }

        return ans;
    }
}