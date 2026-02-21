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
 struct Pair {
    int val;
    int count;
    int maxPath;
    Pair(int val, int count, int maxPath) {
        this->val = val;
        this->count = count;
        this->maxPath = maxPath;
    }
 };
class Solution {
public:
    int longestUnivaluePath(TreeNode* root) {
        return univaluePath(root)->maxPath;
    }
    Pair* univaluePath(TreeNode* root) {
        if(root == nullptr) {
            return new Pair(-1001, 0, 0);
        }
        Pair* lp = univaluePath(root->left);
        Pair* rp = univaluePath(root->right);
        Pair* sp = new Pair(root->val, 1, 0);
        if(lp->val == root->val && rp->val == root->val) {
            sp->maxPath = max(max(lp->maxPath, rp->maxPath), lp->count+rp->count);
            sp->count = max(lp->count, rp->count)+1;
        }
        else if(lp->val == root->val) {
            sp->maxPath = max(lp->count, max(lp->maxPath, rp->maxPath));
            sp->count = lp->count+1;
        }
        else if(rp->val == root->val) {
            sp->maxPath = max(rp->count, max(lp->maxPath, rp->maxPath));
            sp->count = rp->count+1;
        }
        else {
            sp->maxPath = max(lp->maxPath, rp->maxPath);
        }
        return sp;
    }
};