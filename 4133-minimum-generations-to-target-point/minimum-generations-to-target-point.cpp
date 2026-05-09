class Solution {
public:
    int minGenerations(vector<vector<int>>& p, vector<int>& t) {
        vector<vector<vector<bool>>> visited(7, vector<vector<bool>>(7, vector<bool>(7, false)));
        for(vector<int>& p1: p) {
            if(p1[0] == t[0] && p1[1] == t[1] && p1[2] == t[2]) {
                return 0;
            }
            visited[p1[0]][p1[1]][p1[2]] = true;
        }
        for(int k = 1; k <= 15; k++) {
            int size = p.size();
            for(int j = 0; j < size; j++) {
                if(p[j][0] == t[0] && p[j][1] == t[1] && p[j][2] == t[2]) {
                    return k-1;
                }
                for(int i = j+1; i < size; i++) {
                    int a = (p[j][0] + p[i][0])/2;
                    int b = (p[j][1] + p[i][1])/2;
                    int c = (p[j][2] + p[i][2])/2;
                    if(!visited[a][b][c]) {
                        vector<int> arr;
                        arr.push_back(a);
                        arr.push_back(b);
                        arr.push_back(c);
                        p.push_back(arr);
                        visited[a][b][c] = true;
                    }
                }
            }
        }
        return -1;
    }
};