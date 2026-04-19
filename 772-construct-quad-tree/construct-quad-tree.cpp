/*
// Definition for a QuadTree node.
class Node {
public:
    bool val;
    bool isLeaf;
    Node* topLeft;
    Node* topRight;
    Node* bottomLeft;
    Node* bottomRight;
    
    Node() {
        val = false;
        isLeaf = false;
        topLeft = NULL;
        topRight = NULL;
        bottomLeft = NULL;
        bottomRight = NULL;
    }
    
    Node(bool _val, bool _isLeaf) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = NULL;
        topRight = NULL;
        bottomLeft = NULL;
        bottomRight = NULL;
    }
    
    Node(bool _val, bool _isLeaf, Node* _topLeft, Node* _topRight, Node* _bottomLeft, Node* _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/

class Solution {
public:
    vector<vector<int>> prefix;
    Node* construct(vector<vector<int>>& grid) {
        int n = grid.size();
        prefix.resize(n+1, vector<int>(n+1));

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
               prefix[i+1][j+1] = grid[i][j] + prefix[i][j+1] + prefix[i+1][j] - prefix[i][j];
            }
        }
        
        return constructTree(grid, 0, n-1, 0, n-1);
    }

    Node* constructTree(vector<vector<int>>& grid, int r0, int r1, int c0, int c1) {
        int total = (r1 - r0 + 1)*(c1 - c0 + 1);
        int curr = prefix[r1+1][c1+1] - prefix[r0][c1+1] - prefix[r1+1][c0] + prefix[r0][c0];

        if(curr == total) {
            Node* node = new Node(true, true);
            return node;
        }
        if(curr == 0) {
            Node* node = new Node(false, true);
            return node;
        }

        Node* node = new Node(1, false);

        node->topLeft = constructTree(grid, r0, (r0+r1)/2, c0, (c0+c1)/2);
        node->topRight = constructTree(grid, r0, (r0+r1)/2, ((c0+c1)/2)+1, c1);
        node->bottomLeft = constructTree(grid, ((r0+r1)/2)+1, r1, c0, (c0+c1)/2);
        node->bottomRight = constructTree(grid, ((r0+r1)/2)+1, r1, ((c0+c1)/2)+1, c1);

        return node;
    }
};