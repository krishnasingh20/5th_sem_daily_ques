class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int type = 0;
        int ei = 0;
        int si = 0;
        int n = fruits.length;
        int ans = 0;
        while(ei < n) {
            if(map.getOrDefault(fruits[ei], 0) == 0) {
                type++;
            }
            map.put(fruits[ei], map.getOrDefault(fruits[ei], 0) + 1);
            while(type > 2) {
                map.put(fruits[si], map.get(fruits[si]) - 1);
                if(map.get(fruits[si]) == 0) {
                    type--;
                }
                si++;
            }
            ans = Math.max(ans, ei - si + 1);
            ei++;
        }
        return ans;
    }
}