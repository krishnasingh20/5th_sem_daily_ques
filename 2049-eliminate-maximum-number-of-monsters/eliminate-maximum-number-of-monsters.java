class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] arr = new double[n];
        for(int i = 0; i < n; i++) {
            arr[i] = (dist[i]*1.0)/speed[i];
        }
        Arrays.sort(arr);
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] <= i) {
                break;
            }
            ans++;
        }
        return ans;
    }
}