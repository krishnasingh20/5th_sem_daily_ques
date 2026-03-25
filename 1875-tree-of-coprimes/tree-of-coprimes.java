class Solution {
    List<List<Integer>> adj;
    boolean[] visited;
    int[] ans;
    int[][] arr;
    int n;
    public int[] getCoprimes(int[] nums, int[][] edges) {
        n = nums.length;

        arr = new int[51][2];
        ans = new int[n];
        visited = new boolean[n];

        for(int[] a: arr) {
            a[0] = -1;
        }

        adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] e: edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        dfs(0, 0, nums);

        for(int i = 0; i < n; i++) {
            if(ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }

        return ans;
    }

    private void dfs(int src, int dis, int[] nums) {

        int ans1 = -1;
        int dis1 = Integer.MAX_VALUE;
        for(int i = 1; i < 51; i++) {
            if(arr[i][0] != -1) {
                if(GCD(nums[src], i) == 1) {
                    if(dis - arr[i][1] < dis1) {
                        dis1 = dis - arr[i][1];
                        ans1 = arr[i][0];
                    }
                }
            }
        }
        ans[src] = ans1;

        int temp1 = arr[nums[src]][0];
        int temp2 = arr[nums[src]][1];
        arr[nums[src]][0] = src;
        arr[nums[src]][1] = dis;
        visited[src] = true;

        for(int nbrs: adj.get(src)) {
            if(!visited[nbrs]) {
                dfs(nbrs, dis+1, nums);
            }
        }

        arr[nums[src]][0] = temp1;
        arr[nums[src]][1] = temp2;
    }

    private int GCD(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}