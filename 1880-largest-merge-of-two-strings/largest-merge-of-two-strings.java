class Solution {
    public String largestMerge(String word1, String word2) {
        int i = 0;
        int j = 0;
        int n = word1.length();
        int m = word2.length();
        StringBuilder ans = new StringBuilder();
        while(i < n && j < m) {
            if(word1.charAt(i) > word2.charAt(j)) {
                ans.append(word1.charAt(i));
                i++;
            }
            else if(word1.charAt(i) < word2.charAt(j)) {
                ans.append(word2.charAt(j));
                j++;
            }
            else {
                int a = i;
                int b = j;
                boolean flag1 = false;
                while(a < n && b < m) {
                    if(word1.charAt(a) == word2.charAt(b)) {
                        a++;
                        b++;
                        continue;
                    }
                    else if(word1.charAt(a) > word2.charAt(b)) {
                        flag1 = true;
                        break;
                    }
                    break;
                }
                if(flag1 || (a == n && b == m) || (a < n && b == m)) {
                    ans.append(word1.charAt(i));
                    i++;
                }
                else {
                    ans.append(word2.charAt(j));
                    j++;
                }
            }
        }

        while(i < n) {
            ans.append(word1.charAt(i));
            i++;
        }
        while(j < m) {
            ans.append(word2.charAt(j));
            j++;
        }
        return ans.toString();
    }
}