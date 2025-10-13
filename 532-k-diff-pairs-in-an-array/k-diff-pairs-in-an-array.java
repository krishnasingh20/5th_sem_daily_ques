class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            int x1 = nums[i] + k;
            int x2 = nums[i] - k;
            if(set1.contains(x1)) {
                String a = x1+"/"+nums[i];
                String b = nums[i]+"/"+x1;
                if(!set2.contains(a) && !set2.contains(b)) {
                    ans++;
                    set2.add(a);
                    set2.add(b);
                }
            }
            if(set1.contains(x2)) {
                String a = x2+"/"+nums[i];
                String b = nums[i]+"/"+x2;
                if(!set2.contains(a) && !set2.contains(b)) {
                    ans++;
                    set2.add(a);
                    set2.add(b);
                }
            }
            set1.add(nums[i]);
        }
        return ans;
    }
}