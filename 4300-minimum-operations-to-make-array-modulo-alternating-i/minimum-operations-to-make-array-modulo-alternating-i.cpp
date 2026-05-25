class Solution {
public:
    int minOperations(vector<int>& nums, int k) {

        if(nums.size() == 1) {
            return 0;
        }

        int n = nums.size();
        vector<int> ans1(k, INT_MAX);
        vector<int> ans2(k, INT_MAX);

        for(int x = 0; x < k; x++) {
            int curr_odd = 0;
            int curr_even = 0;
            for(int i = 0; i < n; i++) {
                if((i & 1)) {
                    int num = nums[i] % k;
                    int curr1 = 0;
                    while(num != x) {
                        curr1++;
                        num = (num + 1) % k;
                    }
                    num = nums[i] % k;
                    int curr2 = 0;
                    while(num != x) {
                        curr2++;
                        num = (num - 1 + k) % k;
                    }
                    curr_odd += min(curr1, curr2);
                }
                else {
                    int num = nums[i] % k;
                    int curr1 = 0;
                    while(num != x) {
                        curr1++;
                        num = (num + 1) % k;
                    }
                    num = nums[i] % k;
                    int curr2 = 0;
                    while(num != x) {
                        curr2++;
                        num = (num - 1 + k) % k;
                    }
                    curr_even += min(curr1, curr2);
                }
            }
            ans1[x] = min(ans1[x], curr_even);
            ans2[x] = min(ans2[x], curr_odd);
        }
        
        int ans = INT_MAX;
        
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < k; j++) {
                if(i == j) {
                    continue;
                }
                ans = min(ans, ans1[i]+ans2[j]);
            }
        }

        return ans;
    }
};