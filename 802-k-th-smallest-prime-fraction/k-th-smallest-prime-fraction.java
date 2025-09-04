class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                double a = (double)arr[i]/arr[j];
                if(pq.size() < k) {
                    pq.add(new double[]{a, (double)arr[i], (double)arr[j]});
                }
                else if(pq.peek()[0] > a) {
                    pq.poll();
                    pq.add(new double[]{a, (double)arr[i], (double)arr[j]});
                }
            }
        }
        double[] ans = pq.poll();
        return new int[]{(int)ans[1], (int)ans[2]};
    }
}