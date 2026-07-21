class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        List<Integer> arr = new ArrayList<>();
        int curr = 1;
        int one = 1;
        if(s.charAt(0) == '0') {
            curr = -1;
            one = 0;
            arr.add(1);
        }
        int n = s.length();

        for(int i = 1; i < n; i++) {
            int c = s.charAt(i) == '0' ? -1 : 1;

            if(c == 1) {
                one++;
            }

            if(s.charAt(i) != s.charAt(i-1)) {
                arr.add(curr);
                curr = 0;
            }
            curr += c;
        }

        if(curr < 0) {
            arr.add(curr);
            arr.add(1);
        }
        else {
            arr.add(curr+1);
        }

        int ans = one;

        for(int i = 0; i <= arr.size() - 5; i++) {
            if(arr.get(i) < 0) {
                continue;
            }

            if(arr.get(i+1) < 0 && arr.get(i+2) > 0 && arr.get(i+3) < 0 && arr.get(i+4) > 0) {
                int temp = -arr.get(i+1) + -arr.get(i+3);
                ans = Math.max(ans, temp + one);
            }
        }

        return ans;
    }
}