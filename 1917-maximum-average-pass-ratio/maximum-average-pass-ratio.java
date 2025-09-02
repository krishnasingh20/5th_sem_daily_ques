class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for(int i = 0; i < classes.length; i++) {
            double gain = Gain((double)classes[i][0], (double)classes[i][1]);
            pq.add(new double[]{gain, (double)classes[i][0], (double)classes[i][1]});
        }

        while(extraStudents > 0) {
            double[] temp = pq.remove();
            temp[0] = Gain(temp[1]+1, temp[2]+1);
            temp[1] += 1;
            temp[2] += 1;
            pq.add(temp);
            extraStudents--;
        }

        double ans = 0.0;
        while(!pq.isEmpty()) {
            double[] temp = pq.remove();
            ans += (temp[1] / temp[2]);
        }
        return ans / classes.length;
    }
    public double Gain(double pass, double students) {
        return ((pass+1)/(students+1)) - (pass/students);
    }
}