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
        bool operator()(pair<int, int>& a, pair<int, int>& b) const {
            if(a.second == b.second) {
                return a.first < b.first;
            }
            return a.second > b.second;
        }
    };
};

class Solution {
public:
    vector<int> minInterval(vector<vector<int>>& intervals, vector<int>& queries) {
        int n = intervals.size();

        sort(intervals.begin(), intervals.end(), Compare::sortArr1);

        int q = queries.size();

        vector<pair<int, int>> query;

        for(int i = 0; i < q; i++) {
            query.push_back({queries[i], i});
        }

        sort(query.begin(), query.end(), Compare::sortArr2);

        priority_queue<pair<int, int>, vector<pair<int, int>>, Compare::cmp> pq;
        vector<int> ans(q, -1);
        int j = 0;

        for(int i = 0; i < q; i++) {
            while(j < n && intervals[j][0] <= query[i].first) {
                pq.push({intervals[j][1], intervals[j][1]-intervals[j][0]+1});
                j++;
            }
            while(!pq.empty() && pq.top().first < query[i].first) {
                pq.pop();
            }
            if(!pq.empty()) {
                ans[query[i].second] = pq.top().second;
            }
        }

        return ans;
    }
};