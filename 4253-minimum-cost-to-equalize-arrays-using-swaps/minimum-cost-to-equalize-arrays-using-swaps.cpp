class Solution {
public:
    int minCost(vector<int>& nums1, vector<int>& nums2) {
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());

        bool flag = false;
        int n = nums1.size();

        for(int i = 0; i < n; i++) {
            if(nums1[i] != nums2[i]) {
                flag = true;
                break;
            }
        }

        if(!flag) {
            return 0;
        }

        int mx = max(nums1[n-1], nums2[n-1]);
        vector<int> freq1(mx+1);
        vector<int> freq2(mx+1);

        for(int i = 0; i < n; i++) {
            freq1[nums1[i]]++;
            freq2[nums2[i]]++;
        }

        int swap1 = 0;
        int swap2 = 0;

        for(int i = 1; i <= mx; i++) {
            if((freq1[i] + freq2[i]) % 2 != 0) {
                return -1;
            }
            int total = (freq1[i]+freq2[i])/2;;
            swap1 += abs(total - freq1[i]);
            swap2 += abs(total - freq2[i]);
        }

        return swap1/2;
    }
};