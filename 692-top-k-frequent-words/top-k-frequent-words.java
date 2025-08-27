class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s: words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<pair> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(pair p1, pair p2) {
                if(p1.val != p2.val) {
                    return p1.val - p2.val;
                }
                else {
                    return p2.key.compareTo(p1.key);
                }
            }
        });
        for(String key: map.keySet()) {
            pair p = new pair();
            p.key = key;
            p.val = map.get(key);
            if(pq.size() < k) {
                pq.add(p);
            }
            else {
                if(pq.peek().val < p.val) {
                    pq.poll();
                    pq.add(p);
                }
                else if(pq.peek().val == p.val) {
                    if(pq.peek().key.compareTo(p.key) > 0) {
                        pq.poll();
                        pq.add(p);
                    }
                }
            }
        }
        List<String> ll = new ArrayList<>();
        while(!pq.isEmpty()) {
            ll.add(pq.poll().key);
        }
        Collections.reverse(ll);
        return ll;
    }
    class pair {
        String key;
        int val;
    }
}