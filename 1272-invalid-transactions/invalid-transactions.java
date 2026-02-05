class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            String[] str = transactions[i].split(",");
            int time1 = Integer.parseInt(str[1]);
            for(int j = i+1; j < n; j++) {
                String[] str1 = transactions[j].split(",");
                if(str[0].equals(str1[0])) {
                    int time2 = Integer.parseInt(str1[1]);
                    if(Math.abs(time1 - time2) <= 60 && !str[3].equals(str1[3])) {
                        set.add(j);
                        set.add(i);
                    }
                }
            }
            if(Integer.parseInt(str[2]) > 1000) {
                set.add(i);
            }
        }
        List<String> ans = new ArrayList<>();
        for(int idx: set) {
            ans.add(transactions[idx]);
        }
        return ans;
    }
}