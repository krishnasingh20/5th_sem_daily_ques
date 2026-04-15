class Solution {
public:
    int maxProduct(string s) {
        int n = s.length();
        int len = (1 << n)-1;
        vector<int> arr;

        for(int i = 1; i <= len; i++) {
            int mask = i;
            if(isPalindrome(mask, n, s)) {
                arr.push_back(mask);
            }
        }

        int ans = 0;

        for(int i = 0; i < arr.size(); i++) {
            int c1 = setBitCount(arr[i]);
            for(int j = i+1; j < arr.size(); j++) {
                if((arr[i] & arr[j]) == 0) {
                    int c2 = setBitCount(arr[j]);
                    ans = max(ans, c1*c2);
                }
            }
        }

        return ans;
    }

    bool isPalindrome(int mask, int n, string &s) {
        int i = 0;
        int j = n-1;

        while((mask & (1 << i)) == 0) {
            i++;
        }

        while((mask & (1 << j)) == 0) {
            j--;
        }

        while(i < j) {

            if(s[i] != s[j]) {
                return false;
            }

            i++;
            j--;

            while((mask & (1 << i)) == 0) {
                i++;
            }
            while((mask & (1 << j)) == 0) {
                j--;
            }
        }

        return true;
    }

    int setBitCount(int n) {
        int c = 0;
        while(n > 0) {
            c++;
            n = (n & (n-1));
        }
        return c;
    }
};