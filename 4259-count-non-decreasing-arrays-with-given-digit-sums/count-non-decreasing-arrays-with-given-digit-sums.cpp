class Solution {
public:
    int countArrays(vector<int>& digitSum) {
        int n = digitSum.size();
        int mod = 1000000007;
        if(digitSum[0] > 31) {
            return 0;
        }
        vector<vector<int>> arr(51);

        for(int i = 0; i <= 5000; i++) {
            int num = i;
            int sum = 0;

            while(num > 0) {
                sum +=(num % 10);
                num /= 10;
            }

            arr[sum].push_back(i);
        }

        vector<int> dp(5001);
        for(int a: arr[digitSum[0]]) {
            dp[a] = 1;
        }

        for(int i = 1; i < n; i++) {
            vector<int> dp1(5001);
            vector<int> &a = arr[digitSum[i]];

            int j = 0;
            int k = 0;
            int sum = 0;

            while(k < 5001 && j < a.size()) {
                if(a[j] < k) {
                    dp1[a[j]] = sum % mod;
                    j++;
                }
                sum = (sum + dp[k]) % mod;
                k++;
            }

            while(j < a.size()) {
                dp1[a[j]] = sum;
                j++;
            }

            dp = dp1;
        }

        int ans = 0;
        
        for(int i = 0; i < 5001; i++) {
            ans = (ans + dp[i]) % mod;
        }

        return (int)ans;
    }
};