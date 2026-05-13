struct Comparator {
    static bool cmp(const vector<int>& a, const vector<int>& b) {
        if(a[2] == b[2]) {
            return a[1] < b[1];
        }
        return a[2] > b[2];
    }
};

class Solution {
public:
    int minimumEffort(vector<vector<int>>& tasks) {

        int n = tasks.size();
        vector<vector<int>> arr(n);

        for(int i = 0; i < n; i++) {
            arr[i].push_back(tasks[i][0]);
            arr[i].push_back(tasks[i][1]);
            arr[i].push_back(tasks[i][1] - tasks[i][0]);

        }
        
        sort(arr.begin(), arr.end(), Comparator::cmp);
        int ans = arr[0][1];
        int curr = arr[0][1] - arr[0][0];

        for(int i = 1; i < n; i++) {
            if(curr >= arr[i][1]) {
                curr = curr - arr[i][0];
            }
            else {
                ans += (arr[i][1] - curr);
                curr = arr[i][1] - arr[i][0];
            }
        }

        return ans;
    }
};