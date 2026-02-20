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

    TreeNode* removeLeaf(TreeNode* root, int target) {
        if(root == nullptr) {
            return nullptr;
        }
        root->left = removeLeaf(root->left, target);
        root->right = removeLeaf(root->right, target);
        if(root->left == nullptr && root->right == nullptr) {
            if(root->val == target) {
                root = nullptr;
            }
        }
        return root;
    }

    TreeNode* removeLeafNodes(TreeNode* root, int target) {
        return removeLeaf(root, target);
    }
};