class Solution {
    public long[] distance(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i])) {
                List<Integer> ll = new ArrayList<>();
                ll.add(i);
                map.put(arr[i], ll);
            }
            else {
                map.get(arr[i]).add(i);
            }
        }
        long[] ans = new long[arr.length];
        for(List<Integer> ll: map.values()) {
            int n = ll.size();
            long leftSum = 0;
            long rightSum = 0;
            for(int l: ll) {
                rightSum += l;
            }
            for(int i = 0; i < n; i++) {
                long val = (i*(long)ll.get(i)) - leftSum;
                val += (rightSum - (ll.get(i)*(long)(n-i)));
                leftSum += ll.get(i);
                rightSum -= ll.get(i);
                ans[ll.get(i)] = val;
            }
        }
        return ans;
    }
}