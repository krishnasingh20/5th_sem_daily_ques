class Solution {
public:
    int minGenerations(vector<vector<int>>& points, vector<int>& t) {
        vector<vector<vector<bool>>> visited(7, vector<vector<bool>>(7, vector<bool>(7, false)));
        for(vector<int>& p: points) {
            if(p[0] == t[0] && p[1] == t[1] && p[2] == t[2]) {
                return 0;
            }
            visited[p[0]][p[1]][p[2]] = true;
        }
        for(int k = 1; k <= 15; k++) {
            int size = points.size();
            for(int j = 0; j < size; j++) {
                vector<int> p = points[j];
                if(p[0] == t[0] && p[1] == t[1] && p[2] == t[2]) {
                    return k-1;
                }
                for(int i = j+1; i < size; i++) {
                    vector<int> p1 = points[i];
                    int a = (p[0] + p1[0])/2;
                    int b = (p[1] + p1[1])/2;
                    int c = (p[2] + p1[2])/2;
                    if(!visited[a][b][c]) {
                        vector<int> arr;
                        arr.push_back(a);
                        arr.push_back(b);
                        arr.push_back(c);
                        points.push_back(arr);
                        visited[a][b][c] = true;
                    }
                }
            }
        }
        return -1;
    }
};