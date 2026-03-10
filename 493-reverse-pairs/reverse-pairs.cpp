class Fenwick {
public:
    int n;
    vector<int> bit;

    Fenwick(int n) {
        this->n = n;
        bit.assign(n+1, 0);
    }

    void update(int i, int val) {
        while(i <= n) {
            bit[i] += val;
            i += (i & -i);
        }
    }

    int query(int i) {
        int sum = 0;
        while(i > 0) {
            sum += bit[i];
            i -= (i & -i);
        }
        return sum;
    }
};

class Solution {
public:
    int reversePairs(vector<int>& nums) {
        
        int n = nums.size();

        vector<int> temp = nums;
        vector<pair<long long, int>> compress;
        unordered_map<long long, int> map;

        sort(temp.begin(), temp.end());

        int idx = 1;
        compress.push_back({(long long)temp[0], idx});
        map[(long long)temp[0]] = 1;

        for(int i = 1; i < n; i++) {
            pair<long long, int> p = compress[idx-1];

            if(p.first != (long long)temp[i]) {
                compress.push_back({(long long)temp[i], ++idx});
                map[(long long)temp[i]] = idx;
            }
        }

        Fenwick f(idx);
        int ans = 0;

        for(int i = 0; i < n; i++) {
            long long curr = (long long)2 * nums[i];
            int id = binarySearch(compress, curr);
            if(id == -1) {
                ans += i;
            }
            else {
                ans += (i - f.query(id));
            }

            id = map[(long long)nums[i]];
            f.update(id, 1);
        }

        return ans;
    }
    
    int binarySearch(vector<pair<long long, int>>& compress, long long val) {
        int id = -1;
        int low = 0;
        int high = compress.size()-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(compress[mid].first <= val) {
                id = compress[mid].second;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return id;
    }
};