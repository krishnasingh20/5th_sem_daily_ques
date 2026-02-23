class Solution {
public:
    vector<int> platesBetweenCandles(string s, vector<vector<int>>& queries) {
        int n = s.length();
        vector<int> plate(n);
        vector<int> candle;
        int star = 0;
        for(int i = 0; i < n; i++) {
            if(s[i] == '*') {
                star++;
            }
            else {
                candle.push_back(i);
            }
            plate[i] = star;
        }
        int q = queries.size();
        vector<int> ans(q);
        for(int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int lb = lowerBound(candle, l);
            int ub = upperBound(candle, r);
            if(lb >= l && lb <= r && r >= l && ub <= r) {
                int count = plate[ub] - plate[lb];
                ans[i] = count;
            }
        }
        return ans;
    }
    int lowerBound(vector<int>& candle, int target) {
        int idx = -1;
        int low = 0;
        int high = candle.size()-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(candle[mid] >= target) {
                idx = candle[mid];
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return idx;
    }
    int upperBound(vector<int>& candle, int target) {
        int idx = -1;
        int low = 0;
        int high = candle.size()-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(candle[mid] <= target) {
                idx = candle[mid];
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return idx;
    }
};