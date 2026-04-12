class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        int n = nums.length;
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] map1 = new int[max+1];
        int[] map2 = new int[max+1];

        long ans = 0;
        int si1 = 0;
        int si2 = 0;
        int ei = 0;
        int cnt = 0;
        int dist = 0;

        while(ei < n) {
            if(map1[nums[ei]]++ == 0) {
                dist++;
            }
            if(++map2[nums[ei]] == m) {
                cnt++;
            }

            while(dist > k) {
                if(--map1[nums[si1]] == 0) {
                    dist--;
                }
                si1++;
            }

            while(cnt >= k) {
                if(map2[nums[si2]]-- == m) {
                    cnt--;
                }
                si2++;
            }

            if(si2 > si1) {
                ans += (si2 - si1);
            }
            ei++;
        }

        return ans;
    }
}