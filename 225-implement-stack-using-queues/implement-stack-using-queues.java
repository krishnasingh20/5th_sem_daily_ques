import java.util.*;
class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        int size = q1.size();
        while(size > 1) {
            q2.add(q1.poll());
            size--;
        }
        int rv = q1.poll();
        q1 = q2;
        q2 = new LinkedList<>();
        return rv;
    }
    
    public int top() {
        while(q1.size() > 1) {
            q2.add(q1.poll());
        }
        int rv = q1.poll();
        q2.add(rv);
        q1 = q2;
        q2 = new LinkedList<>();
        return rv;
    }
    
    public boolean empty() {
        return q1.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */