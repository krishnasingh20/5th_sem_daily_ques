class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ei = 0;
        int si = 0;
        int ans = Integer.MAX_VALUE;
        while(ei < cards.length) {
            map.put(cards[ei], map.getOrDefault(cards[ei], 0) + 1);
            while(map.get(cards[ei]) >= 2) {
                ans = Math.min(ans, (ei-si+1));
                map.put(cards[si], map.get(cards[si]) - 1);
                si++;
            }
            ei++;
        }
        return ans == Integer.MAX_VALUE?-1:ans;
    }
}