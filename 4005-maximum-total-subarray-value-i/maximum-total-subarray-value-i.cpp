class Solution {
public:
    long long maxTotalValue(vector<int>& nums, int k) {
        int minn = INT_MAX;
        int maxx = INT_MIN;

        for(int num: nums) {
            minn = min(minn, num);
            maxx = max(maxx, num);
        }

        return (long long)(maxx-minn)*k;
    }
};