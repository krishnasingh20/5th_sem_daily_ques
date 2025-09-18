class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length) {
            return false;
        }
        boolean[] flag = new boolean[26];
        HashMap<String, Character> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                if(map.get(arr[i]) != pattern.charAt(i)) {
                    return false;
                }
            }
            else if(flag[pattern.charAt(i)-'a'] == true) {
                return false;
            }
            else {
                map.put(arr[i], pattern.charAt(i));
                flag[pattern.charAt(i)-'a'] = true;
            }
        }
        return true;
    }
}