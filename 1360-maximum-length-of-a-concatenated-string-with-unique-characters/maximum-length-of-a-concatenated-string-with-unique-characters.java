class Solution {
    public int maxLength(List<String> arr) {
        return maxLen(arr, 0, 0);
    }
    private int maxLen(List<String> arr, int i, int mask) {
        if(i == arr.size()) {
            return 0;
        }
        int ans = 0;
        boolean flag = false;
        int newMask = 0;
        for(int j = 0; j < arr.get(i).length(); j++) {
            int x = arr.get(i).charAt(j)-'a';
            if((mask & (1<<x)) != 0 || (newMask & (1<<x)) != 0) {
                flag = true;
                break;
            }
            newMask |= (1<<x);
        }
        if(!flag) {
            int a = arr.get(i).length() + maxLen(arr, i+1, (mask | newMask));
            ans = Math.max(ans, a);
        }
        int b = maxLen(arr, i+1, mask);
        return Math.max(ans, b);
    }
}