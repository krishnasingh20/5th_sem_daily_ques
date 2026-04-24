class Solution {
public:
    int snakesAndLadders(vector<vector<int>>& board) {
        
        int n = board.size();
        unordered_map<int, int> map;
        int val = 1;
        bool flag = true;

        for (int i = n-1; i >= 0; i--) {
            if (flag) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != -1) {
                        map[val] = board[i][j];
                    }
                    val++;
                }
            }
            else {
                for (int j = n-1; j >= 0; j--) {
                    if (board[i][j] != -1) {
                        map[val] = board[i][j];
                    }
                    val++;
                }
            }
            
            flag = !flag;
        }

        vector<int> step((n*n)+1, INT_MAX);
        queue<int> q;
        q.push(1);
        step[1] = 0;

        while (!q.empty()) {

            int rv = q.front();
            q.pop();

            for (int i = 1; i <= 6; i++) {

                if (rv+i > n*n) {
                    continue;
                }

                int r = rv+i;
                int curr = step[rv] + 1;

                if (map.count(r)) {
                    r = map[r];
                }
                
                if(step[r] > curr) {
                    step[r] = curr;
                    q.push(r);
                }
            }
        }

        return step[n*n]==INT_MAX?-1:step[n*n];
    }
};