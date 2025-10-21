class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        List<Integer> ll = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])) {
                ll.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int[] ans = new int[ll.size()];
        for(int i = 0; i < ll.size(); i++) {
            ans[i] = ll.get(i);
        }
        return ans;
    }
}