class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] temp = nums.clone();
        Arrays.sort(temp);
        HashMap<Integer, Integer> compress = new HashMap<>();
        int idx = 1;
        for(int i = 0; i < n; i++) {
            if(!compress.containsKey(temp[i])) {
                compress.put(temp[i], idx++);
            }
        }
        Fenwick ft = new Fenwick(idx-1);
        List<Integer> ans = new ArrayList<>();
        for(int i = n-1; i >= 0; i--) {
            int id = compress.get(nums[i]);
            ans.add(ft.query(id-1));
            ft.update(id, 1);
        }
        Collections.reverse(ans);
        return ans;
    }
    class Fenwick {
        int n;
        int[] bit;
        public Fenwick(int n) {
            this.n = n;
            bit = new int[n+1];
        }
        public void update(int i, int val) {
            while(i <= n) {
                bit[i] += val;
                i += (i & -i);
            }
        }
        public int query(int i) {
            int sum = 0;
            while(i > 0) {
                sum += bit[i];
                i -= (i & -i);
            }
            return sum;
        }
    }
}