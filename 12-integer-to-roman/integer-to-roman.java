class Solution {
    public String intToRoman(int num) {
        TreeMap<Integer, Character> map = new TreeMap<>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
        StringBuilder ans = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int a = 0;
        while(num > 0) {
            int val = num % 10;
            int value = (int)Math.pow(10, a) * val;
            a++;
            num /= 10;
            while(value > 0) {
                if(val == 4 || val == 9) {
                    for(int key: map.keySet()) {
                        if(key >= value) {
                            int diff = key - value;
                            sb.append(map.get(diff));
                            sb.append(map.get(key));
                            break;
                        }
                    }
                    value = 0;
                }
                else {
                    int x = 0;
                    for(int key: map.keySet()) {
                        if(key > value) {
                            break;
                        }
                        x = key;
                    }
                    sb.append(map.get(x));
                    value -= x;
                    int temp = value;
                    while(temp > 0) {
                        val = temp % 10;
                        temp /= 10;
                    }
                }
            }
            sb.reverse();
            ans.append(sb.toString());
            sb.setLength(0);
        }
        return ans.reverse().toString();
    }
}