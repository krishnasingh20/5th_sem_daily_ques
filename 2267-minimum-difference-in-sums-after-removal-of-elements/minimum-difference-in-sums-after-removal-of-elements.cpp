class Solution {
public:
    long long minimumDifference(vector<int>& nums) {
        int m = nums.size();
        int n = m/3;
        vector<long long> arr1;

        long long sum = 0;
        priority_queue<int> pq1;

        for(int i = 0; i < n; i++) {
            sum += nums[i];
            pq1.push(nums[i]);
        }

        arr1.push_back(sum);

        for(int i = n; i < 2*n; i++) {
            pq1.push(nums[i]);
            int val = pq1.top();
            pq1.pop();
            sum += nums[i];
            sum -= val;
            arr1.push_back(sum);
        }

        sum = 0;
        vector<long long> arr2;
        priority_queue<int, vector<int>, greater<int>> pq2;

        for(int i = m-1; i >= 2*n; i--) {
            sum += nums[i];
            pq2.push(nums[i]);
        }

        arr2.push_back(sum);

        for(int i = 2*n-1; i >= n; i--) {
            pq2.push(nums[i]);
            int val = pq2.top();
            pq2.pop();
            sum += nums[i];
            sum -= val;
            arr2.push_back(sum);
        }

        reverse(arr2.begin(), arr2.end());

        long long ans = LONG_MAX;

        for(int i = 0; i <= n; i++) {
            long long curr = arr1[i] - arr2[i];
            ans = min(ans, curr);
        }

        return ans;
    }
};