class Solution {

    HashMap<String, Integer> dp;

    public int beautifulNumbers(int l, int r) {

        dp = new HashMap<>();
        String s1 = String.valueOf(r);
        int ans1 = count(s1, 0, 1, 1, 0, 0);

        dp = new HashMap<>();
        String s2 = String.valueOf(l-1);
        int ans2 = count(s2, 0, 1, 1, 0, 0);

        return ans1 - ans2;
    }

    public int count(String s, int i, int t, int lz, long sum, long p) {
        if(i == s.length()) {
            if(p == 0 || (p % sum == 0)) {
                return 1;
            }
            return 0;
        }

        String key = i+"/"+t+"/"+lz+"/"+sum+"/"+p;

        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        int res = 0;
        int lb = 0;
        int ub = (t==1)?(s.charAt(i)-'0'):9;

        for(int d = lb; d <= ub; d++) {
            long newP = (lz==1 && d > 0)?d*1L:p*d;
            int newT = (t==1 && d==ub)?1:0;
            int newLz = (lz==1 && d==0)?1:0;

            res += count(s, i+1, newT, newLz, sum+d, newP);
        }

        dp.put(key, res);

        return res;
    }
}