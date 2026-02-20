/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> closestNodes(TreeNode* root, vector<int>& queries) {
        vector<int> v;
        inorder(root, v);
        int q = queries.size();
        vector<vector<int>> ans;
        for(int i = 0; i < q; i++) {
            int lb = lowerBound(v, queries[i]);
            int ub = upperBound(v, queries[i]);
            ans.push_back({lb, ub});
        }
        return ans;
    }
    void inorder(TreeNode* root, vector<int>& v) {
        if(root == nullptr) {
            return;
        }
        inorder(root->left, v);
        v.push_back(root->val);
        inorder(root->right, v);
    }
    int lowerBound(vector<int>& v, int val) {
        int idx = -1;
        int low = 0;
        int high = v.size()-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(v[mid] <= val) {
                idx = v[mid];
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return idx;
    }
    int upperBound(vector<int>& v, int val) {
        int idx = -1;
        int low = 0;
        int high = v.size()-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(v[mid] >= val) {
                idx = v[mid];
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return idx;
    }
};