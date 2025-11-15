class NumArray {
    int[] arr;
    Fenwick ft;
    public NumArray(int[] nums) {
        int n = nums.length;
        arr = new int[n];
        ft = new Fenwick(n);

        for(int i = 0; i < n; i++) {
            arr[i] = nums[i];
            ft.update(i+1, nums[i]);
        }
    }
    
    public void update(int index, int val) {
        int delta = val - arr[index];
        arr[index] = val;
        ft.update(index+1, delta);
    }
    
    public int sumRange(int left, int right) {
        return ft.query(right+1) - ft.query(left);
    }
    class Fenwick {
        int n;
        int[] bit;
        Fenwick(int n) {
            this.n = n;
            bit = new int[n+1];
        }
        int lsb(int x) {
            return x & -x;
        }
        void update(int i, int delta) {
            while(i <= n) {
                bit[i] += delta;
                i += lsb(i);
            }
        }
        int query(int i) {
            int sum = 0;
            while(i > 0) {
                sum += bit[i];
                i -= lsb(i);
            }
            return sum;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */