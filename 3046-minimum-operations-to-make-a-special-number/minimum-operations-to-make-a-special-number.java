class Solution {
    public int minimumOperations(String num) {
        int n = num.length();
        int idx0 = -1;
        int idx5 = -1;

        for(int i = 0; i < n; i++) {
            if(num.charAt(i) == '0') {
                idx0 = i;
            }
            else if(num.charAt(i) == '5') {
                idx5 = i;
            }
        }

        int ans = Integer.MAX_VALUE;
        int idx1 = -1;
        int  idx2 = -1;

        for(int i = idx0 - 1; i >= 0; i--) {
            if(num.charAt(i) == '0') {
                if(idx1 == -1) {
                    idx1 = i;
                }
            }
            else if(num.charAt(i) == '5') {
                if(idx2 == -1) {
                    idx2 = i;
                }
            }

            if(idx1 != -1 && idx2 != -1) {
                break;
            }
        }

        if(idx1 != -1) {
            ans = Math.min(ans, (idx0 - idx1 - 1) + (n - idx0 - 1));
        }
        if(idx2 != -1) {
            ans = Math.min(ans, (idx0 - idx2 - 1) + (n - idx0 - 1));
        }

        idx1 = -1;
        idx2 = -1;

        for(int i = idx5-1; i >= 0; i--) {
            if(num.charAt(i) == '2') {
                if(idx1 == -1) {
                    idx1 = i;
                }
            }
            else if(num.charAt(i) == '7') {
                if(idx2 == -1) {
                    idx2 = i;
                }
            }

            if(idx1 != -1 && idx2 != -1) {
                break;
            }
        }

        if(idx1 != -1) {
            ans = Math.min(ans, (idx0 - idx1 - 1) + (n - idx0 - 1));
        }
        if(idx2 != -1) {
            ans = Math.min(ans, (idx0 - idx2 - 1) + (n - idx0 - 1));
        }

        if(ans == Integer.MAX_VALUE) {
            return idx0 == -1 ? n : n-1;
        }

        return ans;
    }
}