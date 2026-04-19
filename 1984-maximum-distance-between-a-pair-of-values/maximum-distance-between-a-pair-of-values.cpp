class Solution {
public:
    int maxDistance(vector<int>& nums1, vector<int>& nums2) {
        int ans = 0;
        int n = nums1.size();
        int m = nums2.size();
        int i = 0;

        for(int j = 0; j < m; j++) {
            
            while(i < n && nums1[i] > nums2[j]) {
                i++;
            }

            if(i == n) {
                break;
            }
            if(i <= j) {
                ans = max(ans, (j-i));
            }
        }

        return ans;
    }
};