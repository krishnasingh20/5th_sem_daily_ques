class NumArray {
    int[] tree;
    int n;
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.tree = new int[4*n];
        build(nums, 1, 0, n-1);
    }
    void build(int[] arr, int idx, int start, int end) {
        if(start == end) {
            tree[idx] = arr[start];
            return;
        }
        int mid = (start + end)/2;
        build(arr, 2*idx, start, mid);
        build(arr, 2*idx+1, mid+1, end);
        tree[idx] = tree[2*idx]+tree[2*idx+1];
    }
    void update(int idx, int start, int end, int pos, int val) {
        if(start == end) {
            tree[idx] = val;
            return;
        }
        int mid = (start+end)/2;
        if(pos <= mid) {
            update(2*idx, start, mid, pos, val);
        }
        else {
            update(2*idx+1, mid+1, end, pos, val);
        }
        tree[idx] = tree[2*idx] + tree[2*idx+1];
    }
    int query(int idx, int start, int end, int ql, int qr) {
        if(qr < start || ql > end) {
            return 0;
        }
        if(ql <= start && end <= qr) {
            return tree[idx];
        }
        int mid = (start+end)/2;
        return query(2*idx, start, mid, ql, qr) + query(2*idx+1, mid+1, end, ql, qr);
    }
    public void update(int index, int val) {
        update(1, 0, n-1, index, val);
    }
    
    public int sumRange(int left, int right) {
        return query(1, 0, n-1, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */