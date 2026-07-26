class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        int n = series1.length;
        int m = series2.length;
        List<List<Integer>> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < n && j < m) {
            List<Integer> ll = new ArrayList<>();
            if(series1[i][0] == series2[j][0]) {
                ll.add(series1[i][0]);
                ll.add(series1[i][1] + series2[j][1]);
                i++;
                j++;
            }
            else if(series1[i][0] < series2[j][0]) {
                ll.add(series1[i][0]);
                ll.add(series1[i][1]+series2[j][1]);
                i++;
            }
            else {
                ll.add(series2[j][0]);
                ll.add(series1[i][1]+series2[j][1]);
                j++;
            }
            ans.add(ll);
        }

        while(i < n) {
            List<Integer> ll = new ArrayList<>();
            ll.add(series1[i][0]);
            ll.add(series1[i][1]);
            ans.add(ll);
            i++;
        }

        while(j < m) {
            List<Integer> ll = new ArrayList<>();
            ll.add(series2[j][0]);
            ll.add(series2[j][1]);
            ans.add(ll);
            j++;
        }

        return ans;
    }
}