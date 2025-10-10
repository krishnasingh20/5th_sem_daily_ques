class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> map = new HashMap<>();
        int b = 0;
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                b++;
            }
            else {
                map.put(guess.charAt(i), map.getOrDefault(guess.charAt(i), 0) + 1);
            }
        }
        int a = 0;
        for(int i = 0; i < guess.length(); i++) {
            if(secret.charAt(i) != guess.charAt(i)) {
                if(map.getOrDefault(secret.charAt(i), 0) > 0) {
                    a++;
                    map.put(secret.charAt(i), map.get(secret.charAt(i))-1);
                }
            }
        }
        return b+"A"+a+"B";
    }
}