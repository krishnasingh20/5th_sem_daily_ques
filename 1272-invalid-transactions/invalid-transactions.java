class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        HashMap<String, List<Integer>> map = new HashMap<>();
        String[][] arr = new String[n][4];
        for(int i = 0; i < n; i++) {
            arr[i] = transactions[i].split(",");
            if(!map.containsKey(arr[i][0])) {
                map.put(arr[i][0], new ArrayList<>());
            }
            map.get(arr[i][0]).add(i);
        }
        HashSet<Integer> set = new HashSet<>();
        for(String key: map.keySet()) {
            List<Integer> ll = map.get(key);
            for(int i = 0; i < ll.size(); i++) {
                int l = ll.get(i);
                int time1 = Integer.parseInt(arr[l][1]);
                for(int j = i+1; j < ll.size(); j++) {
                    int r = ll.get(j);
                    int time2 = Integer.parseInt(arr[r][1]);
                    if(Math.abs(time1 - time2) <= 60 && !arr[l][3].equals(arr[r][3])) {
                        set.add(r);
                        set.add(l);
                    }
                }
                if(Integer.parseInt(arr[l][2]) > 1000) {
                    set.add(l);
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