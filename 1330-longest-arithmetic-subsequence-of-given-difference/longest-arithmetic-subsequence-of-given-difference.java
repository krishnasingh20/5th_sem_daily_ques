class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 1;
        map.put(arr[0], 1);
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int prev = arr[i]-difference;
            Integer val1 = map.get(arr[i]);
            Integer val2 = map.get(prev);
            if(val1 == null) {
                map.put(arr[i], 1);
                val1 = 1;
            }
            if(val2 != null) {
                ans = Math.max(ans, Math.max(val2+1, val1));
                map.put(arr[i], Math.max(val2+1, val1));
            }
            ans = Math.max(ans, val1);
        }
        return ans;
    }
}