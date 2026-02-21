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
    TreeNode* recoverFromPreorder(string traversal) {
        vector<int> v;
        convert(traversal, v);
        int i = 1;
        int n = v.size();
        TreeNode *root = new TreeNode(v[0]);
        stack<TreeNode*> st;
        map<TreeNode*, int> mp;
        mp[root] = 0;
        st.push(root);
        while(i < n) {
            while(mp[st.top()] >= v[i]) {
                st.pop();
            }
            TreeNode *nn = new TreeNode(v[i+1]);
            TreeNode* curr = st.top();
            if(curr->left == nullptr) {
                curr->left = nn;
            }
            else if(curr->right == nullptr) {
                curr->right = nn;
            }
            mp[nn] = v[i];
            st.push(nn);
            i += 2;
        }
        return root;
    }
    void convert(string s, vector<int>& v) {
        int i = 0;
        int d = 0;
        int dashes = 0;
        int n = s.length();
        while(i < n) {
            if(s[i] == '-') {
                if(d > 0) {
                    v.push_back(d);
                    d = 0;
                }
                dashes++;
            }
            else {
                if(dashes > 0) {
                    v.push_back(dashes);
                    dashes = 0;
                }
                d = d*10 + (s[i]-'0');
            }
            i++;
        }
        v.push_back(d);
    }
};