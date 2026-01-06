class Solution {
    public int minimumNumbers(int num, int k) {
        int rem = num%10;
        if(num == 0) {
            return 0;
        }
        if(rem == k) {
            return 1;
        }
        if((rem & 1) == 1 && (k & 1) == 0) {
            return -1;
        }
        boolean[] seen = new boolean[10];//for checking the repetion of number 
        int c = 1;
        int sum = k;
        seen[k] = true;
        while(sum%10 != rem) {
            sum += k;
            c++;
            if(seen[sum%10]) {
                return -1;
            }
            seen[sum%10] = true;
        }
        if(sum > num) {
            return -1;
        }
        return c;
    }
}