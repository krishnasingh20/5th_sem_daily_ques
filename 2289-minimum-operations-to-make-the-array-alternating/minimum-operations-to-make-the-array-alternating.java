class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[1]-a[1]);
        for(int i = 0; i < n; i += 2) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        for(int key: map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
        }
        int[] a1 = pq.poll();
        int[] a2 = pq.isEmpty()?new int[]{}:pq.poll();
        map.clear();
        pq.clear();
        for(int i = 1; i < n; i += 2) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        for(int key: map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
        }
        int[] b1 = pq.poll();
        int[] b2 = pq.isEmpty()?new int[]{}:pq.poll();
        int len1 = n/2 + (n % 2);
        int len2 = n/2;
        if(a1[0] != b1[0]) {
            return (len1-a1[1]) + (len2-b1[1]);
        }
        else{
            if(a2.length != 0 && b2.length != 0) {
                int opr1 = (len1-a1[1]) + (len2-b2[1]);
                int opr2 = (len1-a2[1]) + (len2-b1[1]);
                return Math.min(opr1, opr2);
            }
            else if(a2.length == 0 && b2.length != 0) {
                int opr1 = (len1-a1[1]) + (len2-b2[1]);
                int opr2 = len1 + (len2-b1[1]);
                return Math.min(opr1, opr2);
            }
            else if(a2.length != 0 && b2.length == 0) {
                int opr1 = (len1 - a1[1]) + len2;
                int opr2 = (len1-a2[1]) + (len2-b1[1]);
                return Math.min(opr1, opr2);
            }
            else {
                return Math.min(len1, len2);
            }
        }
    }
}