class Solution {
public:
    int maximumElementAfterDecrementingAndRearranging(vector<int>& arr) {
        sort(arr.begin(), arr.end());
        int n = arr.size();
        int ans = arr[0] = 1;

        for(int i = 1; i < n; i++) {
            if(arr[i] - arr[i-1] > 1) {
                arr[i] -= (arr[i]-arr[i-1] - 1);
            }
            ans = max(ans, arr[i]);
        }

        return ans;
    }
};