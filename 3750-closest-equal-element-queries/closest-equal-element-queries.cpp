class Solution {
public:
    vector<int> solveQueries(vector<int>& nums, vector<int>& queries) {
        int n = nums.size();

        unordered_map<int, vector<int>> map;

        for(int i = 0; i < n; i++) {
            if(map.count(nums[i])) {
                map[nums[i]].push_back(i);
            }
            else {
                vector<int> a = {i};
                map[nums[i]] = a;
            }
        }

        int q = queries.size();
        vector<int> ans(q);

        for(int i = 0; i < q; i++) {
            int num = nums[queries[i]];
            auto &arr = map[num];

            if(arr.size() == 1) {
                ans[i] = -1;
                continue;
            }

            int idx = search(arr, queries[i]);

            if(idx == 0) {
                ans[i] = min((arr[idx+1] - queries[i]), (queries[i]+(n-arr[arr.size()-1])));
            }
            else if(idx == arr.size()-1) {
                ans[i] = min((queries[i] - arr[idx-1]), ((n-queries[i])+arr[0]));
            }
            else {
                ans[i] = min((queries[i]-arr[idx-1]), (arr[idx+1] - queries[i]));
            }
        }

        return ans;
    }

    int search(auto &arr, int target) {
        int low = 0;
        int high = arr.size()-1;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(arr[mid] == target) {
                return mid;
            }
            else if(arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
};