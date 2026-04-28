class Solution {
    public int minOperations(int[][] grid, int x) {
        
        int[] arr = new int[grid.length * grid[0].length];
        int a = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                arr[a++] = grid[i][j];
            }
        }

        Arrays.sort(arr);
        int idx = arr.length / 2;
        int num = arr[idx];
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i] - num) % x != 0) {
                return -1;
            } else {
                ans += (Math.abs(arr[i] - num) / x);
            }
        }

        return ans;
    }
}