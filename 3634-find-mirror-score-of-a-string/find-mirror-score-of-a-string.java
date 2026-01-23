class Solution {
    public long calculateScore(String s) {
        return mirrorScore(s);
    }
    public long mirrorScore(String s) {
        int n = s.length();
        List<Integer>[] arr = new ArrayList[26];
        for(int i = 0; i < 26; i++) {
            arr[i] = new ArrayList<>();
        }
        long score = 0;
        for(int i = 0; i < n; i++) {
            int x = s.charAt(i)-'a';
            char corr = (char)((25-x)+'a');
            if(!arr[corr - 'a'].isEmpty()) {
                List<Integer> ll = arr[corr-'a'];
                int j = ll.removeLast();
                score += (i-j);
            }
            else {
                arr[x].add(i);
            }
        }
        return score;
    }
}