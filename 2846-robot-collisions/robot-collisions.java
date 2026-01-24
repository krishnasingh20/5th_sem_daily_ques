class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int[][] pos = new int[n][2];
        for(int i = 0; i < n; i++) {
            pos[i][0] = positions[i];
            pos[i][1] = i;
        }
        Arrays.sort(pos, (a, b)->Integer.compare(a[0], b[0]));
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            boolean flag = false;
            int idx = pos[i][1];
            while(!st.isEmpty() && directions.charAt(st.peek()) == 'R' && directions.charAt(idx) == 'L') {
                if(healths[st.peek()] == healths[idx]) {
                    healths[st.pop()] = -1;
                    healths[idx] = -1;
                    flag = true;
                    break;
                }
                else if(healths[st.peek()] < healths[idx]) {
                    healths[st.peek()] = -1;
                    st.pop();
                    healths[idx]--;
                }
                else {
                    healths[st.peek()]--;
                    healths[idx] = -1;
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                st.push(idx);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(healths[i] != -1) {
                ans.add(healths[i]);
            }
        }
        return ans;
    }
}