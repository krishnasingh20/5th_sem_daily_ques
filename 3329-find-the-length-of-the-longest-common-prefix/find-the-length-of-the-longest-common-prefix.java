class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < arr1.length; i++) {
            String s = Integer.toString(arr1[i]);
            int j = 0;
            while(j < s.length()) {
                set.add(s.substring(0, j+1));
                j++;
            }
        }
        int ans = 0;
        for(int i = 0; i < arr2.length; i++) {
            String s = Integer.toString(arr2[i]);
            int j = 0;
            while(j < s.length()) {
                if(set.contains(s.substring(0,j+1))) {
                    ans = Math.max(ans, j+1);
                }
                j++;
            }
        }
        return ans;
    }
}