class Solution {
    public double angleClock(int hour, int minutes) {
        double temp1 = (minutes / 60.0) * 30;
        double temp2 = (hour % 12) * 30;
        double temp3 = minutes * 6;
        double ans = Math.abs(temp3 - (temp1 + temp2));

        return Math.min(360.0 - ans, ans);
    }
}