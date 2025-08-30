class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ll = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]==b[1]?b[0]-a[0]:b[1]-a[1]);
        for(int i = 0; i < arr.length; i++) {
            if(pq.size() < k) {
                pq.add(new int[]{arr[i], Math.abs(arr[i]-x)});
            }
            else if(pq.peek()[1] == Math.abs(arr[i]-x)) {
                if(pq.peek()[0] > arr[i]) {
                    pq.poll();
                    pq.add(new int[]{arr[i], Math.abs(arr[i]-x)});
                }
            }
            else if(pq.peek()[1] > Math.abs(arr[i]-x)) {
                pq.poll();
                pq.add(new int[]{arr[i], Math.abs(arr[i]-x)});
            }
        }
        while(!pq.isEmpty()) {
            ll.add(pq.poll()[0]);
        }
        Collections.sort(ll);
        return ll;
    }
}