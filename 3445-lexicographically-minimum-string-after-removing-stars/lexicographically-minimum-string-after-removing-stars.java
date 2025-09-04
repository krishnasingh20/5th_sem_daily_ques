class Solution {
    public String clearStars(String s) {
        char[] ch = s.toCharArray();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Pair o1, Pair o2) {
                //because we need lexicographically samllest resulting string
                if(o1.ch == o2.ch) {
                    return o2.idx - o1.idx;
                }
                return o1.ch - o2.ch;
            }
        });
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == '*') {
                Pair p = pq.poll();
                ch[p.idx] = 'X';
                ch[i] = 'X';
            }
            else {
                pq.add(new Pair(ch[i], i));
            }
        }
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] != 'X') {
                str.append(ch[i]);
            }
        }
        return str.toString();
    }
    class Pair {
        char ch;
        int idx;
        Pair(char ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        }
    }
}