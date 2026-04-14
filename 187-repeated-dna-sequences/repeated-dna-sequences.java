class Solution {
    static final long MOD = 1000000007;
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() <= 10) {
            return new ArrayList<>();
        }

        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int n = s.length();

        for(int i = 0; i <= n-10; i++) {
            String s1 = s.substring(i, i+10);
            map.put(s1, map.getOrDefault(s1, 0)+1);
            if(map.get(s1) == 2) {
                ans.add(s1);
            }
        }

        return ans;
    }
}