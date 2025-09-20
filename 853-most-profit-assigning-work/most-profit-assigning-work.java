class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] arr = new int[profit.length][2];
        for(int i = 0; i < profit.length; i++) {
            arr[i][0] = difficulty[i];
            arr[i][1] = profit[i];
        }
        Arrays.sort(worker);
        Arrays.sort(arr, (a, b)->a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[1]-a[1]);
        int j = 0;
        int ans = 0;
        for(int i = 0; i < worker.length; i++) {
            while(j < arr.length && worker[i] >= arr[j][0]) {
                pq.add(arr[j]);
                j++;
            }
            if(!pq.isEmpty()) {
                ans += pq.peek()[1];
            }
        }
        return ans;
    }
}