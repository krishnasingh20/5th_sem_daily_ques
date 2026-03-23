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
    int ans = 0;
    int minCameraCover(TreeNode* root) {
        if(minCamera(root) == 3) {
            ans++;
        }
        return ans;
    }

    int minCamera(TreeNode* root) {
        if(root == nullptr) {
            return 2;
        }

        int l = minCamera(root->left);
        int r = minCamera(root->right);

        if(l == 3 || r == 3) {
            ans++;
            return 1;
        }
        else if(l == 1 || r == 1) {
            return 2;
        }
        else {
            return 3;
        }
    }
};