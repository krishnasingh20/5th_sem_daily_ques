class Solution {
    public int countSpecialNumbers(int n) {
        return count(String.valueOf(n), 0, 1, 1, new boolean[10])-1;//-1 for case when it will count 0 also but needed in range [1, n].
    }
    private int count(String s, int idx, int tight, int lz, boolean[] visited) {
        if(idx == s.length()) {
            return 1;
        }
        int lb = 0;
        int ub = tight==1?(s.charAt(idx)-'0'):9;
        int ans = 0;
        for(int digit = lb; digit <= ub; digit++) {
            if(lz == 0 && visited[digit]) {
                continue;
            }
            int newTight = (tight==1 && digit==ub)?1:0;
            int newLz = (lz==1 && digit == 0)?1:0;
            if(digit == 0 && lz == 0) {
                visited[digit] = true;
            }
            else if(digit > 0) {
                visited[digit] = true;
            }
            ans += count(s, idx+1, newTight, newLz, visited);
            visited[digit] = false;
        }
        return ans;
    }
}