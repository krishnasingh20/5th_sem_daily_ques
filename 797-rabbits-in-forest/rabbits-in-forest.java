class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < answers.length; i++) {
            map.put(answers[i], map.getOrDefault(answers[i], 0)+1);
        }
        int ans = 0;
        for(int key: map.keySet()) {
            int value = map.get(key);
            if(key == 0) {
                ans += value;
            }
            else if(value > key) {
                ans += (value/(key+1))*(key+1);
                int rem = value % (key+1);
                if(rem > 0) {
                    ans += (key+1);
                }
            }
            else {
                ans += (key+1);
            }
        }
        return ans;
    }
}