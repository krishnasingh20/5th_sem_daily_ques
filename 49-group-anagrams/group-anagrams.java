class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            String key = GetKey(strs[i]);
            System.out.println(key);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        for(String key: map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
    int[] freq = new int[26];
    public String GetKey(String s) {
        //best way to generate unique key for different anagram
        for(char ch:s.toCharArray()) {
            freq[ch-'a']++;
        }
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            str.append(freq[i]+"/");
        }
        Arrays.fill(freq, 0);
        return str.toString();
    }
}