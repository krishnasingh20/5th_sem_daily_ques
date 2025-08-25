class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int ans = 0;
        for(int i = 0; i < n - 2; i++) {
            if(colors[i] == 0 && colors[i+1] == 1 && colors[i+2] == 0) {
                ans++;
            }
            else if(colors[i] == 1 && colors[i+1] == 0 && colors[i+2] == 1) {
                ans++;
            }
        }
        if(colors[n-2] == 0 && colors[n-1] == 1 && colors[0] == 0) {
            ans++;
        }
        else if(colors[n-2] == 1 && colors[n-1] == 0 && colors[0] == 1) {
            ans++;
        }
        if(colors[n-1] == 1 && colors[0] == 0 && colors[1] == 1) {
            ans++;
        }
        else if(colors[n-1] == 0 && colors[0] == 1 && colors[1] == 0) {
            ans++;
        }
        return ans;
    }
}