struct Comparator {
    static bool cmp(vector<int>& a, vector<int>& b) {
        return a[1] < b[1];
    }
};

class Solution {
public:
    int intersectionSizeTwo(vector<vector<int>>& intervals) {

        sort(intervals.begin(), intervals.end(), Comparator::cmp);

        int n = intervals.size();
        int a = intervals[0][1]-1;
        int b = intervals[0][1];
        int size = 2;

        for(int i = 0; i < n; i++) {
            if(intervals[i][0] > b) {
                size += 2;
                a = intervals[i][1]-1;
                b = intervals[i][1];
            }
            else if(intervals[i][0] > a) {
                size++;
                if(intervals[i][1] == b) {
                    a = intervals[i][1]-1;
                }
                else {
                    a = b;
                    b = intervals[i][1];
                }
            }
        }
        
        return size;
    }
};