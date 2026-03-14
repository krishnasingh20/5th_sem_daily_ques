class Solution {
public:
    long long minNumberOfSeconds(int mH, vector<int>& wT) {

        long long low = 1;
        long long high = 0;

        for(int &t: wT) {
            high = max(high, (long long)t);
        }
        high = (((long long)mH*(mH+1))/2) * high;

        long long ans = 0;

        while(low <= high) {

            long long mid = low + (high - low)/2;
            
            if(possible(wT, mH, mid)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans;
    }

    bool possible(vector<int>& wT, int mH, long long T) {

        long long total = 0;

        for(int &t: wT) {
            long long D = 1 + (8*T)/t;
            long long x = (-1 + (long long)sqrt(D))/2;
            total += x;
        }

        return total >= mH;
    }
};