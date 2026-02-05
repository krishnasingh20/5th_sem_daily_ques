class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        HashMap<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String[] str = transactions[i].split(",");
            if(!map.containsKey(str[0])) {
                map.put(str[0], new ArrayList<>());
            }
            map.get(str[0]).add(i);
        }
        HashSet<Integer> set = new HashSet<>();
        for(String key: map.keySet()) {
            List<Integer> ll = map.get(key);
            for(int i = 0; i < ll.size(); i++) {
                String[] str = transactions[ll.get(i)].split(",");
                int time1 = Integer.parseInt(str[1]);
                for(int j = i+1; j < ll.size(); j++) {
                    String[] str1 = transactions[ll.get(j)].split(",");
                    if(str[0].equals(str1[0])) {
                        int time2 = Integer.parseInt(str1[1]);
                        if(Math.abs(time1 - time2) <= 60 && !str[3].equals(str1[3])) {
                            set.add(ll.get(j));
                            set.add(ll.get(i));
                        }
                    }
                }
                if(Integer.parseInt(str[2]) > 1000) {
                    set.add(ll.get(i));
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for(int idx: set) {
            ans.add(transactions[idx]);
        }
        return ans;
    }
}