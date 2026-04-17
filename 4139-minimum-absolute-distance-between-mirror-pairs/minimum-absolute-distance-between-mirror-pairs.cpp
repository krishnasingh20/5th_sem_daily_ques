class Solution {
public:
    int minMirrorPairDistance(vector<int>& nums) {
        int n = nums.size();
        unordered_map<int, int> map;
        int ans = INT_MAX;

        for(int i = 0; i < n; i++) {
            if(map.count(nums[i])) {
                ans = min(ans, (i-map[nums[i]]));
            }

            int rev = reverse(nums[i]);

            map[rev] = i;
        }

        return ans==INT_MAX?-1:ans;
    }

    int reverse(int n) {
        int rev = 0;
        while(n > 0) {
            rev = (rev*10) + (n % 10);
            n /= 10;
        }
        return rev;
    }
};