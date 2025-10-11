class Solution {
    int mod = 1000000007;
    public int numberOfWays(int startPos, int endPos, int k) {
        HashMap<String, Long> map = new HashMap<>();
        return (int)(numWays(startPos, startPos, endPos, k, 0, map) % mod);
    }
    public long numWays(int currPos, int startPos, int endPos, int k, int currStep, HashMap<String, Long> map) {
        if(currStep == k) {
            if(currPos == endPos) {
                return 1;
            }
            return 0;
        }
        String key = currPos+"/"+currStep;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        long left = numWays(currPos - 1, startPos, endPos, k, currStep + 1, map) % mod;
        long right = numWays(currPos + 1, startPos, endPos, k, currStep + 1, map) % mod;
        map.put(key, (left+right) % mod);
        return (left + right) % mod;
    }
}