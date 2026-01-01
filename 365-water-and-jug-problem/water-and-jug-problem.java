class Solution {
    HashSet<String> visit;
    public boolean canMeasureWater(int x, int y, int target) {
        visit = new HashSet<>();
        return dfs(0, 0, x, y, target);
    }
    public boolean dfs(int currX, int currY, int x, int y, int target) {
        if(currX+currY == target) {
            return true;
        }
        String key = currX+"/"+currY;
        if(visit.contains(key)) {
            return false;
        }
        visit.add(key);
        // case-a
        boolean a1 = dfs(x, currY, x, y, target);
        boolean a2 = dfs(currX, y, x, y, target);
        if(a1 || a2) {
            return true;
        }
        // case-b
        boolean b1 = dfs(0, currY, x, y, target);
        boolean b2 = dfs(currX, 0, x, y, target);
        if(b1 || b2) {
            return true;
        }
        // case-c
        //(i)- pour from currX to currY
        int req1 = y - currY;
        int temp1 = Math.min(req1, currX);
        boolean c1 = dfs(currX-temp1, currY+temp1, x, y, target);
        // (ii)-pour form currY to currX
        int req2 = x - currX;
        int temp2 = Math.min(req2, currY);
        boolean c2 = dfs(currX+temp2, currY, x, y, target);
        if(c1 || c2) {
            return true;
        }
        return false;
    }
}