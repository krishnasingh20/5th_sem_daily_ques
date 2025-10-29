class Solution {
    public boolean queryString(String s, int n) {
        int c = count(n);
        if(c > s.length()) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= c; i++) {
            for(int j = 0; j <= s.length()-i; j++) {
                int a = i - 1;
                int val = 0;
                for(int k = j; k < j+i; k++) {
                    int x = s.charAt(k)-'0';
                    val = val + (int)Math.pow(2, a)*x;
                    a--;
                }
                if(val <= n && val >= 1) {
                    set.add(val);
                }
            }
        }
        
        return set.size()==n;
    }
    public int count(int n) {
        int c = 0;
        while(n > 0) {
            c++;
            n /= 2;
        }
        return c;
    }
}