class Solution {
    int[] dp;
    public String stoneGameIII(int[] stoneValue) {

        dp = new int[stoneValue.length];
        Arrays.fill(dp, -1);

        int stoneA = stone(stoneValue, 0);

        int totalSum = 0;
        for(int s: stoneValue) {
            totalSum += s;
        }

        if(stoneA == totalSum - stoneA) {
            return "Tie";
        }

        return stoneA > (totalSum - stoneA) ? "Alice" : "Bob";
    }
    public int stone(int[] arr, int i) {
        if(i >= arr.length) {
            return 0;
        }

        if(i == arr.length-1) {
            return arr[i];
        }

        if(dp[i] != -1) {
            return dp[i];
        }

        int a = arr[i] + Math.min(stone(arr, i+2), Math.min(stone(arr, i+3), stone(arr, i+4)));
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;

        if(i+1 < arr.length) {
            b = arr[i] + arr[i+1] + Math.min(stone(arr, i+3), Math.min(stone(arr, i+4), stone(arr, i+5)));
        }

        if(i+2 < arr.length) {
            c = arr[i] + arr[i+1] + arr[i+2] + Math.min(stone(arr, i+4), Math.min(stone(arr, i+5), stone(arr, i+6)));
        }

        return dp[i] = Math.max(a, Math.max(b, c));
    }
}