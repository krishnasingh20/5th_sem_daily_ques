class StockSpanner {
    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        if(st.isEmpty()) {
            st.push(new int[]{price, 1});
            return 1;
        }
        int c = 1;
        while(!st.isEmpty() && st.peek()[0] <= price) {
            c += st.pop()[1];
        }
        st.push(new int[]{price, c});
        return c;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */