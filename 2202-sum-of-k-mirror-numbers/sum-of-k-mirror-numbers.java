class Solution {
    StringBuilder str = new StringBuilder();
    public long kMirror(int k, int n) {
        long l = 1;
        long sum = 0;
        // StringBuilder str = new StringBuilder();
        while(n > 0) {
            long half = (l+1)/2;
            long min = (long)Math.pow(10, half-1);
            long max = (long)Math.pow(10, half)-1;
            for(long num = min; num <= max; num++) {
                str.setLength(0);
                long num1 = 0;
                if((l & 1) == 1) {
                    str.append(num);
                    String s = str.toString();
                    str.reverse();
                    s = s+str.substring(1);
                    num1 = Long.parseLong(s);
                }
                else {
                    str.append(num);
                    String s = str.toString();
                    str.reverse();
                    s = s+str.toString();
                    num1 = Long.parseLong(s);
                }
                String temp = baseK(num1, k);
                if(isPalindrome(temp)) {
                    sum += num1;
                    n--;
                }
                str.setLength(0);
                if(n == 0) {
                    break;
                }
            }
            l++;
        }
        return sum;
    }
    public String baseK(long num, int k) {
        str.setLength(0);
        while(num > 0) {
            str.append(num % k);
            num /= k;
        }
        String s = str.reverse().toString();
        str.setLength(0);
        return s;
    }
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}