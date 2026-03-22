class Solution {
public:
    void swap(int i, int idx, vector<int>& suffix) {
        while(idx > i) {
            suffix[idx] = suffix[idx-1];
            idx--;
        }
    }

    int minSwaps(vector<vector<int>>& grid) {
        int n = grid.size();

        vector<int> suffix(n);

        for(int i = 0; i < n; i++) {
            int idx = -1;
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    idx = j;
                }
            }
            suffix[i] = n-idx-1;
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {
            int req = n - i - 1;
            int idx = -1;
            for(int j = i; j < n; j++) {
                if(suffix[j] >= req) {
                    idx = j;
                    break;
                }
            }
            if(idx == -1) {
                return -1;
            }
            ans += (idx - i);
            swap(i, idx, suffix);
        }

        return ans;
    }
};