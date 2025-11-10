class Solution {
    public int maxDiff(int num) {
        int len = 0;
        int n = num;
        while(n > 0) {
            len++;
            n /= 10;
        }
        n = num;
        int[] a = new int[len];
        int[] b = new int[len];
        len -= 1;
        while(n > 0) {
            int rem = n % 10;
            a[len] = rem;
            b[len--] = rem;
            n /= 10;
        }
        int i = 0;
        while(i < a.length && a[i] == 9) {
            i++;
        }
        if(i != a.length) {
            int val = a[i];
            i = 0;
            while(i < a.length) {
                if(a[i] == val) {
                    a[i] = 9;
                }
                i++;
            }
        }
        i = 0;
        while(i < b.length && b[i] <= 1) {
            i++;
        }
        if(i != b.length) {
            int val = b[i];
            int c = 0;
            if(i == 0) {
                c = 1;
            }
            else {
                c = 0;
            }
            i = 0;
            while(i < b.length) {
                if(b[i] == val) {
                    b[i] = c;
                }
                i++;
            }
        }
        long num1 = 0;
        for(i = 0; i < a.length; i++) {
            num1 = num1 * 10 + a[i];
        }
        long num2 = 0;
        for(i = 0; i < b.length; i++) {
            num2 = num2 * 10 + b[i];
        }
        return (int)(num1 - num2);
    }
}