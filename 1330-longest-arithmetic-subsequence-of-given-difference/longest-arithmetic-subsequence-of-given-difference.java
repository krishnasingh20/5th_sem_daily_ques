class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 1;
        map.put(arr[0], 1);
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int prev = arr[i]-difference;
            int val = 1 + map.getOrDefault(prev, 0);
            map.put(arr[i], val);
            ans = Math.max(ans, val);
        }
        return ans;
    }
}