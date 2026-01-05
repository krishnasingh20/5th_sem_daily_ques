class Solution {
    public int minimumNumbers(int num, int k) {
        if(num == 0) {
            return 0;
        }
        int rem = num%10;
        if(rem == k) {
            return 1;
        }
        if(((rem & 1) == 1 && (k & 1) == 0) || (rem != 0 && k == 0)) {
            return -1;
        }
        int c = 1;
        int sum = k;
        while(sum%10 != rem && sum <= num) {
            sum += k;
            c++;
        }
        if(sum > num) {
            return -1;
        }
        // num -= sum;
        // if(num % 10 != 0) {
        //     return -1;
        // }
        return c;
    }
}