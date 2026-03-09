class Solution {
public:
    int minimumIndex(vector<int>& capacity, int itemSize) {
        int idx = -1;
        int max = INT_MAX;
        for(int i = capacity.size()-1; i >= 0; i--) {
            if(capacity[i] >= itemSize) {
                if(capacity[i] <= max) {
                    max = capacity[i];
                    idx = i;
                }
            }
        }
        return idx;
    }
};