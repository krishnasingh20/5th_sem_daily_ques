struct Compare {
    static bool sortArr1(vector<int>& a, vector<int>& b) {
        if(a[0] == b[0]) {
            return a[1] < b[1];
        }
        return a[0] < b[0];
    }
    static bool sortArr2(pair<int, int>& a, pair<int, int>& b) {
        if(a.first == b.first) {
            return a.second < b.second;
        }
        return a.first < b.first;
    }
    struct cmp {
        bool operator()(vector<int>& a, vector<int>& b) const {
            if(a[2] == b[2]) {
                return a[1] < b[1];
            }
            return a[2] > b[2];
        }
    };
};

class Solution {
public:
    vector<int> minInterval(vector<vector<int>>& intervals, vector<int>& queries) {
        int n = intervals.size();

        vector<vector<int>> arr(n, vector<int>(3));

        for(int i = 0; i < n; i++) {
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
            arr[i][2] = arr[i][1] - arr[i][0] + 1;
        }

        sort(arr.begin(), arr.end(), Compare::sortArr1);

        int q = queries.size();

        vector<pair<int, int>> query;

        for(int i = 0; i < q; i++) {
            query.push_back({queries[i], i});
        }

        sort(query.begin(), query.end(), Compare::sortArr2);

        priority_queue<vector<int>, vector<vector<int>>, Compare::cmp> pq;
        vector<int> ans(q, -1);
        int j = 0;

        for(int i = 0; i < q; i++) {
            while(j < n && arr[j][0] <= query[i].first) {
                pq.push(arr[j]);
                j++;
            }
            while(!pq.empty() && pq.top()[1] < query[i].first) {
                pq.pop();
            }
            if(!pq.empty()) {
                ans[query[i].second] = pq.top()[2];
            }
        }

        return ans;
    }
};