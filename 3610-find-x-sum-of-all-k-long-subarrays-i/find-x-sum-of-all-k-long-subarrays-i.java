class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int[] freq = new int[51];
        for(int i = 0; i < k; i++) {
            freq[nums[i]]++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1] == b[1]? a[0]-b[0]:a[1]-b[1]);
        for(int i = 0; i < freq.length; i++) {
            if(freq[i] > 0) {
                if(pq.size() < x) {
                    pq.add(new int[]{i, freq[i]});
                }
                else {
                    if(pq.peek()[1] < freq[i]) {
                        pq.poll();
                        pq.add(new int[]{i, freq[i]});
                    }
                    else if(pq.peek()[1] == freq[i] && pq.peek()[0] < i) {
                        pq.poll();
                        pq.add(new int[]{i, freq[i]});
                    }
                }
            }
        }
        int[] ans = new int[nums.length - k + 1];
        int idx = 0;
        while(!pq.isEmpty()) {
            ans[idx] += pq.peek()[0]*pq.poll()[1];
        }
        idx++;
        for(int i = k; i < nums.length; i++) {
            freq[nums[i]]++;
            freq[nums[i-k]]--;
            pq = new PriorityQueue<>((a, b)->a[1] == b[1]? a[0]-b[0]:a[1]-b[1]);
            for(int j = 0; j < freq.length; j++) {
                if(freq[j] > 0) {
                    if(pq.size() < x) {
                        pq.add(new int[]{j, freq[j]});
                    }
                    else {
                        if(pq.peek()[1] < freq[j]) {
                            pq.poll();
                            pq.add(new int[]{j, freq[j]});
                        }
                        else if(pq.peek()[1] == freq[j] && pq.peek()[0] < j) {
                            pq.poll();
                            pq.add(new int[]{j, freq[j]});
                        }
                    }
                }
            }
            while(!pq.isEmpty()) {
                ans[idx] += pq.peek()[0] * pq.poll()[1];
            }
            idx++;
        }
        return ans;
    }
}