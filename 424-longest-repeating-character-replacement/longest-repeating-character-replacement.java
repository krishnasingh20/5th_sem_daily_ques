class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int ei = 0;
        int si = 0;
        int n = s.length();
        int ans = 0;
        while(ei < n) {
            freq[s.charAt(ei)-'A']++;
            while((ei-si+1)-max(freq) > k) {
                freq[s.charAt(si)-'A']--;
                si++;
            }
            ans = Math.max(ans, (ei-si+1));
            ei++;
        }
        return ans;
    }
    // i used these because every time in my window i will store one with max frequency and other will include in k operation to maximize my answer
    public int max(int[] freq) {
        int ans = 0;
        for(int i = 0; i < 26; i++) {
            ans = Math.max(ans, freq[i]);
        }
        return ans;
    }

    // or

    // public int characterReplacement(String s, int k) {
    //     int ans=0;
    //     for(char ch='A';ch<='Z';ch++){
    //         ans=Math.max(ans,maxlen(s,ch,k));
    //     }
    //     return ans;
    // }
    // public static int maxlen(String s,char ch,int k){
    //     int start=0;
    //     int end=0;
    //     int flip=0;
    //     int ans=0;
    //     while(end<s.length()){
    //         if(s.charAt(end)!=ch){
    //             flip++;
    //         }
    //         while(flip>k){
    //             if(s.charAt(start)!=ch){
    //                 flip--;
    //             }
    //             start++;
    //         }
    //         ans=Math.max(ans,end-start+1);
    //         end++;
    //     }
    //     return ans;
    // }
}

