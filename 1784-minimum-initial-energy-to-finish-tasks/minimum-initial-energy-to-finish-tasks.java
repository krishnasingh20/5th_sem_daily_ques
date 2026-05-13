class Solution {
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        int[][] arr = new int[n][3];

        for(int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = tasks[i][1] - arr[i][0];
        }

        Arrays.sort(arr, (a, b)-> {
            if(a[2] == b[2]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(b[2], a[2]);
        });

        int ans = arr[0][1];
        int curr = arr[0][2];

        for(int i = 1; i < n; i++) {
            if(curr >= arr[i][1]) {
                curr -= arr[i][0];
            }
            else {
                ans += (arr[i][1] - curr);
                curr = arr[i][2];
            }
        }

        return ans;
    }
}