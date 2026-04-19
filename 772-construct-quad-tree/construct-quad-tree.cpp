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
    Node* construct(vector<vector<int>>& grid) {
        int n = grid.size();
        return constructTree(grid, 0, n-1, 0, n-1);
    }

    Node* constructTree(vector<vector<int>>& grid, int r0, int r1, int c0, int c1) {
        bool one = false;
        bool zero = false;

        for(int i = r0; i <= r1; i++) {
            for(int j = c0; j <= c1; j++) {
                if(grid[i][j] == 1) {
                    one = true;
                }
                else {
                    zero = true;
                }

                if(one && zero) {
                    break;
                }
            }
            if(one && zero) {
                break;
            }
        }

        if(one && !zero) {
            Node* node = new Node(true, true);
            return node;
        }
        if(!one && zero) {
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