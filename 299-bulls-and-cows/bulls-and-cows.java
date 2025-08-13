class Solution {
    public String getHint(String secret, String guess) {
        int[] freq = new int[10];
        int x = 0;
        int y = 0;
        int n = secret.length();
        for(int i = 0; i < n; i++) {
            if(secret.charAt(i) != guess.charAt(i)) {
                freq[secret.charAt(i)-'0']++;
            }
        }

        for(int i = 0; i < n; i++) {
            char ch1 = secret.charAt(i);
            char ch2 = guess.charAt(i);
            if(ch1 == ch2) {
                x++;
            }
            else if(ch1 != ch2) {
                if(freq[ch2 - '0'] > 0) {
                    y++;
                    freq[ch2-'0']--;
                }
            }
        }
        return x+"A"+y+"B";
    }
}