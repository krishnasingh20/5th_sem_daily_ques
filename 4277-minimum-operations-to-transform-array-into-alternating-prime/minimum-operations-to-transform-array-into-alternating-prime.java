class Solution {

    List<Integer> prime = new ArrayList<>();
    boolean[] isPrime = new boolean[100004];

    public int minOperations(int[] nums) {
        precompute();

        int n = nums.length;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            if((i & 1) == 1) {
                if(isPrime[nums[i]]) {
                    if(nums[i] == 2) {
                        ans++;
                    }
                    ans++;
                }
            }
            else {
                if(!isPrime[nums[i]]) {
                    int val = UpperBound(nums[i]);
                    ans += val - nums[i];
                }
            }
        }

        return ans;
    }

    private int UpperBound(int target) {
        int low = 0;
        int high = prime.size();
        int idx = -1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(prime.get(mid) > target) {
                idx = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return prime.get(idx);
    }

    private void precompute() {
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i * i <= 100003; i++) {
            if(isPrime[i]) {
                for(int j = i*i; j <= 100003; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for(int i = 2; i <= 100003; i++) {
            if(isPrime[i]) {
                prime.add(i);
            }
        } 
    }
}