/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return constructTree(grid, 0, n-1, 0, n-1);
    }

    public Node constructTree(int[][] grid, int r0, int r1, int c0, int c1) {
        boolean one = false;
        boolean zero = false;

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
            return new Node(true, true);
        }
        if(!one && zero) {
            return new Node(false, true);
        }

        Node node = new Node(true, false);

        node.topLeft = constructTree(grid, r0, (r0+r1)/2, c0, (c0+c1)/2);
        node.topRight = constructTree(grid, r0, (r0+r1)/2, ((c0+c1)/2)+1, c1);
        node.bottomLeft = constructTree(grid, ((r0+r1)/2)+1, r1, c0, (c0+c1)/2);
        node.bottomRight = constructTree(grid, ((r0+r1)/2)+1, r1, ((c0+c1)/2)+1, c1);

        return node;
    }
}