class Solution {
public:
    bool isDigitorialPermutation(int n) {
        long long f = 0;
        int num = n;
        vector<int> freq(10);
        while(num > 0) {
            int rem = num % 10;
            freq[rem]++;
            f += fact(rem);
            num /= 10;
        }
        string s = to_string(f);
        for(int i = 0; i < s.length(); i++) {
            int x = s[i]-'0';
            if(freq[x] == 0) {
                return false;
            }
            freq[x]--;
        }
        for(int i = 0; i < 10; i++) {
            if(freq[i] > 0) {
                return false;
            }
        }
        return true;
    }
    int fact(int n) {
        if(n == 0) {
            return 1;
        }
        return n*fact(n-1);
    }
};