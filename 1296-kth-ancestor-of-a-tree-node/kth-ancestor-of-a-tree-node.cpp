class TreeAncestor {
public:
    vector<vector<int>> ancestor;
    int rows;
    int cols;

    TreeAncestor(int n, vector<int>& parent) {
        rows = n;
        cols = log2(n) + 1;
        ancestor.resize(n, vector<int>(cols, -1));

        // building the ancestor table
        // 1-fill the oth column first-immediate parent(ancestor)
        for(int node = 0; node < n; node++) {
            ancestor[node][0] = parent[node];
        }

        for(int j = 1; j < cols; j++) {
            for(int node = 0; node < n; node++) {

                if(ancestor[node][j-1] != -1) {
                    ancestor[node][j] = ancestor[ancestor[node][j-1]][j-1];
                }
            }
        }
    }
    
    int getKthAncestor(int node, int k) {

        for(int j = 0; j < cols; j++) {

            if(k & (1 << j)) {//jth bit of k is set so we will take 2^j jump
                node = ancestor[node][j];

                if(node == -1) {
                    return -1;
                }
            }
        }

        return node;
    }
};

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor* obj = new TreeAncestor(n, parent);
 * int param_1 = obj->getKthAncestor(node,k);
 */