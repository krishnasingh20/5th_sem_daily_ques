class SegmentTree {
public:
    vector<int> seg;
    SegmentTree(int n, vector<int>& arr) {
        seg.resize(4*n);
        build(1, 0, n-1, arr);
    }

    void build(int node, int start, int end, vector<int>& arr) {
        if(start == end) {
            seg[node] = arr[start];
            return;
        }

        int mid = (start + end)/2;

        build(2*node, start, mid, arr);
        build(2*node+1, mid+1, end, arr);

        seg[node] = seg[2*node]+seg[2*node+1];
    }

    void update(int node, int start, int end, int idx, int val) {
        if(start == end) {
            seg[node] = val;
            return;
        }

        int mid = (start + end)/2;

        if(idx <= mid) {
            update(2*node, start, mid, idx, val);
        }
        else {
            update(2*node+1, mid+1, end, idx, val);
        }

        seg[node] = seg[2*node] + seg[2*node+1];
    }

    int query(int node, int start, int end, int ql, int qr) {
        //no overlaping
        if(end < ql || start > qr) {
            return 0;
        }
        // total overlaping
        if(start >= ql && end <= qr) {
            return seg[node];
        }

        // partial overlaping
        int mid = (start + end)/2;

        return query(2*node, start, mid, ql, qr) + query(2*node+1, mid+1, end, ql, qr);
    }
};

class NumArray {
public:
    SegmentTree s;
    int n;

    NumArray(vector<int>& nums) : s(nums.size(), nums) {
        n = nums.size();
    }
    
    void update(int index, int val) {
        s.update(1, 0, n-1, index, val);
    }
    
    int sumRange(int left, int right) {
        return s.query(1, 0, n-1, left, right);
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * obj->update(index,val);
 * int param_2 = obj->sumRange(left,right);
 */