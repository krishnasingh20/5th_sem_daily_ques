class Solution {
public:
    int minCost(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int, int> map;
        int n = nums1.size();

        for(int i = 0; i < n; i++) {
            map[nums1[i]]++;
            map[nums2[i]]--;
        }
        int swap = 0;

        for(auto &p: map) {
            if(abs(p.second) % 2 != 0) {
                return -1;
            }
            swap += (abs(p.second))/2;
        }

        return swap/2;
    }
};