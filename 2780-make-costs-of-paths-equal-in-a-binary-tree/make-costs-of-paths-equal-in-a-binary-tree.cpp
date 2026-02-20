class Solution {
public:
    int sum = 0;
    int ans = 0;
    int minIncrements(int n, vector<int>& cost) {
        dfs(n, 1, cost, 0);
        ans += minInc(n, 1, cost, 0);
        return ans;
    }
    int minInc(int n, int root, vector<int>& cost, int curr) {
        if(2*root > n) {
            curr += cost[root-1];
            return sum-curr;
        }
        int left = minInc(n, 2*root, cost, curr+cost[root-1]);
        int right = minInc(n, 2*root+1, cost, curr+cost[root-1]);
        ans += abs(left-right);
        return min(left, right);
    }
    void dfs(int n, int root, vector<int>& cost, int curr) {
        if(root > n) {
            sum = max(sum, curr);
            return;
        }
        dfs(n, root*2, cost, curr+cost[root-1]);
        dfs(n, root*2+1, cost, curr+cost[root-1]);
    }
};