class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> mp;
        for(int i = 0; i < nums.size(); i++) {
            int curr = target - nums[i];
            if(mp.count(curr)) {
                vector<int> v = {mp[curr], i};
                return v;
            }
            mp[nums[i]] = i;
        }
        vector<int> v = {-1, -1};
        return v;
    }
};