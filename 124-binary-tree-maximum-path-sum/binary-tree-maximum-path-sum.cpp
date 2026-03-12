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
    int ans = INT_MIN;

    int maxPathSum(TreeNode* root) {
        dfs(root);
        
        return ans;
    }
    
    int dfs(TreeNode* root) {
        if(root == nullptr) {
            return -10000;
        }

        int l = dfs(root->left);
        int r = dfs(root->right);

        ans = max(ans, root->val);
        ans = max(ans, root->val+l);
        ans = max(ans, root->val+r);
        ans = max(ans, root->val+l+r);

        int curr = root->val;
        curr = max(curr, root->val+l);
        curr = max(curr, root->val+r);

        return curr;
    }
};