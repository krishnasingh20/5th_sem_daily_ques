class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        int n = firstList.length;
        int m = secondList.length;
        List<int[]> ll = new ArrayList<>();
        while(i < n && j < m) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            int[] a = new int[2];
            a[0] = start;
            a[1] = end;
            if(start <= end) {
                ll.add(a);
            }
            if(firstList[i][1] < secondList[j][1]) {
                i++;
            }
            else {
                j++;
            }
        }
        int[][] ans = new int[ll.size()][2];
        for(i = 0; i < ll.size(); i++) {
            ans[i] = ll.get(i);
        }
        return ans;
    }
}