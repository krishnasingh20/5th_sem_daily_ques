struct Comparator {
    static bool cmp1(vector<int>& a, vector<int>& b) {
        if(a[0] == b[0]) {
            return a[1] < b[1];
        }
        return a[0] < b[0];
    }

    static bool cmp2(pair<int, int>& a, pair<int , int>& b) {
        return a.first < b.first;
    }

    struct cmp3 {
        bool operator()(auto &a, auto &b) const {
            return a[1] > b[1];
        }
    };
};

class Solution {
public:
    vector<int> fullBloomFlowers(vector<vector<int>>& flowers, vector<int>& people) {
        int n = flowers.size();
        int m = people.size();

        sort(flowers.begin(), flowers.end(), Comparator::cmp1);

        vector<pair<int, int>> arr;

        for(int i = 0; i < m; i++) {
            arr.push_back({people[i], i});
        }

        sort(arr.begin(), arr.end(), Comparator::cmp2);

        priority_queue<vector<int>, vector<vector<int>>, Comparator::cmp3> pq;
        vector<int> ans(m);
        int j = 0;

        for(int i = 0; i < m; i++) {
            while(j < n && flowers[j][0] <= arr[i].first) {
                pq.push(flowers[j]);
                j++;
            }

            while(!pq.empty() && pq.top()[1] < arr[i].first) {
                pq.pop();
            }

            ans[arr[i].second] = pq.size();
        }

        return ans;
    }
};