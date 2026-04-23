class Solution {
public:
    long long countSubarrays(vector<int>& nums, int minK, int maxK) {
        
        int minn = -1; //it will hold nearest index to ith index which is equal to minK
        int max = -1; //it will hold nearest index to ith index which is equal to maxK
        int start = -1; //it will represent the boundary after which every element are greater then equal to minK and less then equal to maxK for calculating numder of subarrays

        int n = nums.size();
        long long ans = 0;

        for (int i = 0; i < n; i++) {
            
            if(nums[i] < minK || nums[i] > maxK) {
                start = i;
                minn = max = -1;
                continue;
            }

            if(nums[i] == minK) {
                minn = i;
            }

            if(nums[i] == maxK) {
                max = i;
            }

            if(minn != -1 && max != -1) {
                int end = min(minn, max);
                ans += (end  - start);
            }
        }

        return ans;
    }
};