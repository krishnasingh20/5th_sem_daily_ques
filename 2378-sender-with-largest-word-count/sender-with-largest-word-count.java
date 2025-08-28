class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        int max = -1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < senders.length; i++) {
            int count = 1;
            for(char ch: messages[i].toCharArray()) {
                if(ch == ' ') {
                    count++;
                }
            }
            map.put(senders[i], map.getOrDefault(senders[i], 0) + count);
            max = Math.max(max, map.get(senders[i]));
        }
        String ans = "";
        for(String key: map.keySet()) {
            if(map.get(key) == max) {
                if(ans.compareTo(key) < 0) {
                    ans = key;
                }
            }
        }
        return ans;
    }
}