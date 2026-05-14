class Solution {
    public int maximumJumps(int[] nums, int target) {
        return maxJump(nums, target);
    }
    private int maxJump(int[] nums, int target) {
        int n = nums.length;
        int[] move = new int[n];
        Arrays.fill(move, Integer.MIN_VALUE);
        move[0] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()) {
            int rv = q.poll();
            for(int i = rv + 1; i < n; i++) {
                if(nums[i] - nums[rv] >= -target && nums[i] - nums[rv] <= target) {
                    int curr = move[rv] + 1;
                    if(curr > move[i]) {
                        q.add(i);
                        move[i] = curr;
                    }
                }
            }
        }
        return move[n-1] == Integer.MIN_VALUE ? -1 : move[n-1];
    }
}