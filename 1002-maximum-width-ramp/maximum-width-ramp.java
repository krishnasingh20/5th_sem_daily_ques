class Solution {
    public int maxWidthRamp(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer key = map.floorKey(num);

            System.out.println(key);

            if(key != null) {
                ans = Math.max(ans, i - map.get(key));
            }
            else {
                map.put(num, i);
            }
        }

        return ans;
    }
}