class Solution {
    public int trailingZeroes(int n) {
        // 10 = 2*5 and in any number factors, occurance of 2 will always greater then occurance of 5, so we try to find the occcurance of 5 using below formula
        // Math.floor(n/5)+Math.floor(n/25)+Math.floor(n/125)+.........
        // Everytime we are counting in how many number 5 come , 5*5 come, 5*5*5 come,.......
        int ans = 0;
        for(int D = 5; n/D >= 1; D *= 5) {
            ans += n/D;
        }
        return ans;
    }
}