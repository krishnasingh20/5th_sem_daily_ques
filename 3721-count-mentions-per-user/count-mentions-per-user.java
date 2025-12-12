class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        Collections.sort(events, (a, b)-> {
            int a1 = Integer.parseInt(a.get(1));
            int b1 = Integer.parseInt(b.get(1));
            if(a1 == b1) {
                if(a.get(0).charAt(0) == 'O') {
                    return -1;
                }
                return 1;
            }
            return Integer.compare(a1, b1);
        });
        int[] mentions = new int[numberOfUsers];
        int[] state = new int[numberOfUsers];
        int all = 0;
        for(List<String> ll: events) {
            int time = Integer.parseInt(ll.get(1));
            if(ll.get(0).charAt(0) == 'M') {
                char c = ll.get(2).charAt(0);
                if(c == 'A') {
                    all++;
                }
                else if(c == 'H') {
                    for(int i = 0; i < numberOfUsers; i++) {
                        if(state[i] <= time) {
                            mentions[i]++;
                        }
                    }
                }
                else {
                    String[] str = ll.get(2).split(" ");
                    for(String s: str) {
                        int idx = Integer.parseInt(s.substring(2));
                        mentions[idx]++;
                    }
                }
            }
            else {
                int idx = Integer.parseInt(ll.get(2));
                state[idx] = time + 60;
            }
        }
        if(all == 0) {
            return mentions;
        }
        for(int i = 0; i < numberOfUsers; i++) {
            mentions[i] += all;
        }
        return mentions;
    }
}