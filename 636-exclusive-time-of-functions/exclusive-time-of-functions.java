class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<int[]> st = new Stack<>();
        int end = 0;
        for(String s: logs) {
            String[] str = s.split(":");
            int id = Integer.parseInt(str[0]);
            boolean start = (str[1].charAt(0) == 's')?true:false;
            int time = Integer.parseInt(str[2]);
            if(start) {
                if(!st.isEmpty()) {
                    ans[st.peek()[0]] += time - end;
                }
                st.push(new int[]{id, time});
                end = time;
            }
            else {
                ans[st.peek()[0]] += (time - end + 1);
                end = time + 1;
                st.pop();
            }
        }
        return ans;
    }
}