class Solution {
public:
    vector<int> solveQueries(vector<int>& nums, vector<int>& queries) {
        unordered_map<int, int> map1;
        int n = nums.size();

        for(int i = 0; i < n; i++) {
            map1[nums[i]] = i;
        }

        unordered_map<int, int> map2;
        vector<int> arr(n, INT_MAX);

        for(int i = 0; i < n; i++) {
            if(map2.count(nums[i])) {
                arr[i] = i-map2[nums[i]];
            }
            if(map1[nums[i]] != i) {
                if(map1[nums[i]] > i) {
                    arr[i] = min(arr[i], i+(n-map1[nums[i]]));
                }
                else {
                    arr[i] = min(arr[i], i-map1[nums[i]]);
                }
            }
            map2[nums[i]] = i;
        }

        for(int i = n-1; i >= 0; i--) {
            map1[nums[i]] = i;
        }

        map2.clear();

        for(int i = n-1; i >= 0; i--) {
            if(map2.count(nums[i])) {
                arr[i] = min(arr[i], abs(map2[nums[i]]-i));
            }
            if(map1[nums[i]] != i) {
                if(map1[nums[i]] < i) {
                    arr[i] = min(arr[i], map1[nums[i]] + (n-i));
                }
                else {
                    arr[i] = min(arr[i], map1[nums[i]]-i);
                }
            }
            map2[nums[i]] = i;
            if(arr[i] == INT_MAX) {
                arr[i] = -1;
            }
        }

        int q = queries.size();
        vector<int> ans(q);

        for(int i = 0; i < q; i++) {
            ans[i] = arr[queries[i]];
        }

        return ans;
    }
};