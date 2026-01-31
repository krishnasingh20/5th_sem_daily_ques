class Solution {
    int ans = Integer.MAX_VALUE;
    public int findMinimumTime(List<Integer> strength, int k) {
        minTime(strength, 0, k, 1, 0);
        return ans;
    }
    public void minTime(List<Integer> strength, int c, int k, int x, int time) {
        if(c == strength.size()) {
            ans = Math.min(ans, time);
            return;
        }
        for(int i = 0; i < strength.size(); i++) {
            if(strength.get(i) != -1) {
                int eng = strength.get(i);
                strength.set(i, -1);
                int val = 0;
                if(eng > x) {
                    val = eng/x;
                    if(eng % x != 0) {
                        val++;
                    }
                }
                else {
                    val = 1;
                }
                minTime(strength, c+1, k, x+k, time+val);
                strength.set(i, eng);
            }
        }
    }
}