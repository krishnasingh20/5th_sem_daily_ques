class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++) {
            map.putIfAbsent(nums2[i], i);
        }
        for(int i = 0; i < nums1.length; i++) {
            int idx = map.get(nums1[i]);
            boolean present = false;
            for(int j = idx+1; j < nums2.length; j++) {
                if(nums2[j] > nums1[i]) {
                    nums1[i] = nums2[j];
                    present = true;
                    break;
                }
            }
            if(!present) {
                nums1[i] = -1;
            }
        }
        return nums1;
    }
}