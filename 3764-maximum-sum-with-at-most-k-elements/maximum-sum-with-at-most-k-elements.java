class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = grid[0].length - 1; j >= grid[0].length - limits[i]; j--) {
                pq.add(grid[i][j]);
            } 
        }
        long sum = 0;
        int i = 1;
        while(i++ <= k) {
            sum += pq.poll();
        }
        return sum;
    }
}