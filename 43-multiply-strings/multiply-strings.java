class Solution {
    public String multiply(String num1, String num2) {
        if(num1.length() == 1) {
            if(num1.charAt(0) == '0') {
                return "0";
            }
        }
        if(num2.length() == 1) {
            if(num2.charAt(0) == '0') {
                return "0";
            }
        }
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        int z = 0;
        for(int i = ch1.length - 1; i >= 0; i--) {
            int a = ch1[i] - '0';
            int carry = 0;
            int z1 = z;
            while(z1 > 0) {
                sb2.append('0');
                z1--;
            }
            for(int j = ch2.length - 1; j >= 0; j--) {
                int b = ch2[j] - '0';
                int p = a*b + carry;
                sb2.append((p%10));
                carry = p/10;
            }
            if(carry > 0) {
                sb2.append(carry);
            }
            if(sb3.length() > 0) {
                int k = 0;
                int l = 0;
                int cy = 0;
                while(k < sb2.length() && l < sb3.length()) {
                    int x = sb2.charAt(k)-'0';
                    int y = sb3.charAt(l)-'0';
                    int sum = x+y+cy;
                    sb1.append((sum % 10));
                    cy = sum/10;
                    k++;
                    l++;
                }
                while(k < sb2.length()) {
                    int x = sb2.charAt(k)-'0';
                    int sum = x + cy;
                    sb1.append((sum % 10));
                    cy = sum / 10;
                    k++;
                }
                while(l < sb3.length()) {
                    int x = sb3.charAt(l)-'0';
                    int sum = x + cy;
                    sb1.append((sum % 10));
                    cy = sum / 10;
                    l++;
                }
                if(cy > 0) {
                    sb1.append(cy);
                }
                sb3.setLength(0);
                sb3.append(sb1.toString());
                sb1.setLength(0);
                sb2.setLength(0);
            }
            else {
                sb3.append(sb2.toString());
                sb2.setLength(0);
            }
            z++;
        }
        return sb3.reverse().toString();
    }
}