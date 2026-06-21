class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        int ans = 0;

        sort(costs.begin(), costs.end());

        for(int c: costs) {
            if(c > coins) {
                break;
            }
            ans++;
            coins -= c;
        }
        
        return ans;
    }
};