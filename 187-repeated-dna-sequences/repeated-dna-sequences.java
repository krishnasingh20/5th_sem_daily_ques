class Solution {
    static final long MOD = 1000000007;
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() <= 10) {
            return new ArrayList<>();
        }

        List<String> ans = new ArrayList<>();
        HashMap<Long, HashMap<String, Integer>> map = new HashMap<>();
        long base = 31;
        int n = s.length();

        for(int i = 0; i <= n-10; i++) {
            long p = 1;
            long hash = (s.charAt(i)-'A')+1;

            for(int j = i+1; j < i+10; j++) {
                p = (p * base) % MOD;
                hash = (hash + ((p * (s.charAt(j)-'A')+1) % MOD)) % MOD;
            }

            map.putIfAbsent(hash, new HashMap<>());
            String s1 = s.substring(i, i+10);

            if(map.get(hash).getOrDefault(s1, -1) == 1) {
                ans.add(s1);
            }
            map.get(hash).put(s1, map.get(hash).getOrDefault(s1, 0)+1);
        }

        return ans;
    }
}