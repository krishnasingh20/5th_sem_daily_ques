class Solution {
    public int maximumLength(String s) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int c1 = 1;
        int n = s.length();
        for(int i = 1; i < n; i++) {
            if(s.charAt(i) != s.charAt(i-1)) {
                int c = s.charAt(i-1)-'a';
                if(map.containsKey(c)) {
                    map.get(c).add(c1);
                }
                else {
                    List<Integer> ll = new ArrayList<>();
                    ll.add(c1);
                    map.put(c, ll);
                }
                c1 = 1;
            }
            else {
                c1++;
            }
        }
        int c = s.charAt(n-1)-'a';
        if(map.containsKey(c)) {
            map.get(c).add(c1);
        }
        else {
            List<Integer> ll = new ArrayList<>();
            ll.add(c1);
            map.put(c, ll);
        }
        int ans = Integer.MIN_VALUE;
        for(int key: map.keySet()) {
            List<Integer> ll = map.get(key);
            Collections.sort(ll);
            int n1 = ll.size();
            if(n1 >= 3) {
                ans = Math.max(ans, Math.min(Math.min(ll.get(n1-1), ll.get(n1-2)), ll.get(n1-3)));
            }
            if(n1 >= 2) {
                ans = Math.max(ans, Math.min(ll.get(n1-1)-1, ll.get(n1-2)));
            }
            ans = Math.max(ans, ll.get(n1-1)-2);
        }
        return ans <= 0?-1:ans;
    }
}