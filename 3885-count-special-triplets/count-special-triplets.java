class Solution {
    public int specialTriplets(int[] nums) {
        HashMap<Long, long[]> map = new HashMap<>();
        long ans = 0;
        for(int i = 0; i < nums.length; i++) {
            long num = nums[i];
            if(map.containsKey((num/2)) && num == 2*(num/2)) {
                ans += map.get((num/2))[1];
            }
            if(!map.containsKey(num)) {
                map.put(num, new long[2]);
            }
            long[] a = map.get(num);
            if(map.containsKey(2*num)) {
                long val = map.get(2*num)[0];
                a[1] += val;
            }
            a[0] += 1;
        }
        return (int)(ans % 1000000007);
    }
}