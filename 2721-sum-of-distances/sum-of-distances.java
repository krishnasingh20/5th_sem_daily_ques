class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer, List<Long>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                List<Long> ll = new ArrayList<>();
                ll.add((long)i);
                map.put(nums[i], ll);
            }
            else {
                List<Long> ll = map.get(nums[i]);
                ll.add((long)i+ll.get(ll.size()-1));
            }
        }
        long[] ans = new long[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]).size() == 1) {
                ans[i] = 0;
            }
            else {
                List<Long> ll = map.get(nums[i]);
                int idx = binarySearch(ll, 0, ll.size()-1, i);
                long val = 0;
                if(idx == 0) {
                    val += (ll.get(ll.size()-1) - ll.get(idx)) - (i*(ll.size()-1));
                }
                else {
                    val += ((long)i*idx - ll.get(idx - 1));
                    val += (ll.get(ll.size() - 1) - ll.get(idx)) - ((long)i*(ll.size() - (idx+1)));
                }
                ans[i] = val;
            }
        }
        return ans;
    }
    public int binarySearch(List<Long> ll, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(mid == 0) {
                if(ll.get(mid) == target) {
                    return mid;
                }
                else if(ll.get(mid) < target) {
                    low = mid +  1;
                }
                else {
                    high = mid - 1;
                }
            }
            else if(ll.get(mid)-ll.get(mid - 1) == target) {
                return mid;
            }
            else if(ll.get(mid)-ll.get(mid-1) > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}