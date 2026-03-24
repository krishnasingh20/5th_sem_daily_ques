class Solution {
public:
    vector<vector<int>> constructProductMatrix(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<int> arr;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr.push_back(grid[i][j]);
            }
        }

        vector<long long> left(n*m);
        left[0] = 1;

        for(int i = 1; i < n*m; i++) {
            left[i] = (left[i-1]*arr[i-1]) % 12345;
        }

        vector<long long> right(n*m);
        right[n*m - 1] = 1;

        for(int i = n*m - 2; i >= 0; i--) {
            right[i] = (right[i+1]*arr[i+1]) % 12345;
        }

        for(int i = 0; i < n*m; i++) {
            left[i] = (left[i]*right[i]) % 12345;
        }

        int idx = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = left[idx++];
            }
        }

        return grid;
    }
};