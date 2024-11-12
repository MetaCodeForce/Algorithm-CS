
// Runtime 0 ms Beats 100.00% 
// Memory 41.14 MB Beats 67.75%
import java.util.*;

class MyStack {

    private Queue<Integer> qu;

    public MyStack() {
        qu = new LinkedList<>();
    }

    // ** 큐 2개 버전
    public void push(int x) {
        Queue<Integer> newQ = new LinkedList<>();
        newQ.offer(x);

        int size = qu.size();
        for (int i = 0; i < size; i++) {
            newQ.offer(qu.poll());
        }

        qu = newQ;
    }

    // ** 큐 1개 버전
    public void push1(int x) {
        qu.offer(x);

        for (int i = 0; i < qu.size() - 1; i++) {
            qu.offer(qu.poll());
        }
    }

    public int pop() {
        return qu.poll();
    }

    public int top() {
        return qu.peek();
    }

    public boolean empty() {
        return qu.isEmpty();
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