class Solution {
    public int numOfSubarrays(int[] arr) {
        int evenRem = 1;
        int oddRem = 0;
        long ans = 0;
        long prefixSum = 0;
        for(int a: arr) {
            prefixSum += a;
            if((prefixSum & 1) == 1) {
                ans += evenRem;
                oddRem++;
            }
            else {
                ans += oddRem;
                evenRem++;
            }
        }
        return (int)(ans % 1000000007);
    }
}