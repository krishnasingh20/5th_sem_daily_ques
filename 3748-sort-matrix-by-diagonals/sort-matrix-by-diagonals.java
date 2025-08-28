class Solution {
    public int[][] sortMatrix(int[][] grid) {
        List<Integer> ll = new ArrayList<>();
        int n = grid.length;
        int m = grid.length;
        for(int i = 1; i < m; i++) {
            int col = i;
            int row = 0;
            while(row < n && col < m) {
                ll.add(grid[row][col]);
                row++;
                col++;
            }
            Collections.sort(ll);
            row = 0;
            col = i;
            int j = 0;
            while(row < n && col < m) {
                grid[row][col] = ll.get(j++);
                row++;
                col++;
            }
            ll.clear();
        }
        for(int i = 0; i < n; i++) {
            int row = i;
            int col = 0;
            while(row < n && col < m) {
                ll.add(grid[row][col]);
                row++;
                col++;
            }
            Collections.sort(ll);
            row = i;
            col = 0;
            int j = ll.size()-1;
            while(row < n && col < m) {
                grid[row][col] = ll.get(j--);
                row++;
                col++;
            }
            ll.clear();
        }
        return grid;
    }
}