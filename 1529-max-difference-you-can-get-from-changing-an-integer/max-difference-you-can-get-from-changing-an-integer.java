class Solution {
    public int maxDiff(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        int i = 0;
        while(i < sb.length() && sb.charAt(i) == '9') {
            i++;
        }
        if(i != sb.length()) {
            char c = sb.charAt(i);
            i = 0;
            while(i < sb.length()) {
                if(sb.charAt(i) == c) {
                    sb.setCharAt(i, '9');
                }
                i++;
            }
        }
        long num1 = Long.parseLong(sb.toString());
        sb.setLength(0);
        sb.append(num);
        i = 0;
        while(i < sb.length() && sb.charAt(i) <= '1') {
            i++;
        }
        if(i != sb.length()) {
            char ch = sb.charAt(i);
            char c = '0';
            if(i == 0) {
                c = '1';
            }
            else {
                c = '0';
            }
            i = 0;
            while(i < sb.length()) {
                if(sb.charAt(i) == ch) {
                    sb.setCharAt(i, c);
                }
                i++;
            }
        }
        long num2 = Long.parseLong(sb.toString());
        return (int)(num1 - num2);
    }
}