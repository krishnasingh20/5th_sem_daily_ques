class Solution {
    public String processStr(String s) {
        
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        char c = ' ';

        for(int i = 0; i < n; i++) {
            c = s.charAt(i);

            if(Character.isLowerCase(c)) {
                sb.append(c);
            }
            else if(c == '*') {
                if(sb.length() != 0) {
                    sb.deleteCharAt(sb.length()-1);
                }
            }
            else if(c == '#') {
                sb.append(sb.toString());
            }
            else {
                sb.reverse();
            }
        }

        return sb.toString();
    }
}