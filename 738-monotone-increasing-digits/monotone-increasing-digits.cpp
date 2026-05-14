class Solution {
public:
    int monotoneIncreasingDigits(int n) {
        vector<int> digit;
        int num = n;

        while(num > 0) {
            int rem = num % 10;
            digit.push_back(rem);
            num /= 10;
        }

        reverse(digit.begin(), digit.end());

        int j = digit.size();
        int i = digit.size()-2;
        
        while(i >= 0) {
            if(digit[i] > digit[i+1]) {
                j = i+1;
                digit[i]--;
            }
            i--;
        }

        int ans = 0;
        i = 0;

        while(i < j) {
            ans = (ans * 10) + digit[i];
            i++;
        }

        while(j < digit.size()) {
            ans = (ans * 10) + 9;
            j++;
        }

        return ans;
    }
};