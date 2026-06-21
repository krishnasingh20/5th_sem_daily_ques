class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        int maxx = 0;

        for(int c: costs) {
            maxx = max(maxx, c);
        }

        vector<int> count(maxx+1, 0);

        for(int c: costs) {
            count[c]++;
        }

        int ans = 0;

        for(int i = 1; i < maxx+1; i++) {
            if(i > coins) {
                break;
            }
            int x = min(coins/i, count[i]);
            ans += x;
            coins -= x*i;
        }

        return ans;
    }
};