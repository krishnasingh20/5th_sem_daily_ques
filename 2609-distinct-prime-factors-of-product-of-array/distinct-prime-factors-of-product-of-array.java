class Solution {
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for(int j = 2; j * j <= num; j++) {
                if(num % j == 0) {
                    set.add(j);
                    while(num % j == 0) {
                        num /= j;
                    }
                }
            }
            if(num > 1) {
                set.add(num);
            }
        }
        return set.size();
    }
}