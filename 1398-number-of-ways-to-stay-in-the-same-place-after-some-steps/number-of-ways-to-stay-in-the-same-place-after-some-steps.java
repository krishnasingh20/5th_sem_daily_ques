class Solution {
    static int mod = 1000000007;
    public int numWays(int steps, int arrLen) {
        HashMap<String, Long> map = new HashMap<>();
        return (int)(numWay(steps, 0, 0, arrLen, map) % mod);
    }
    public long numWay(int steps, int currStep, int i, int arrLen, HashMap<String, Long> map) {
        if(currStep == steps) {
            if(i == 0) {
                return 1;
            }
            return 0;
        }
        if(i < 0 || i >= arrLen) {
            return 0;
        }
        String key = i+"/"+currStep;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        long stay = numWay(steps, currStep+1, i, arrLen, map);
        long left = numWay(steps, currStep+1, i-1, arrLen, map);
        long right = numWay(steps, currStep+1, i+1, arrLen, map);
        map.put(key, (stay+left+right) % mod);
        return (stay+left+right) % mod;
    }
}