package sy03;

public class Ackerman {
}

class StackElem {
    public int mval;
    public int nval;

    public StackElem(int m, int n) {
        this.mval = m;
        this.nval = n;
    }
}

class Stack {
    private StackElem[] st;
    private int top;

    //构造栈函数
    public Stack(int maxsize) {
        top = -1;
        st = new StackElem[maxsize];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public StackElem getTop() throws Exception {
        if (!isEmpty())
            return st[top];
        else
            throw new Exception("栈空");
    }

    public void setTop(int m, int n) throws Exception {
        if (!isEmpty()) {
            st[top].mval = m;
            st[top].nval = n;
        } else
            throw new Exception("栈空");
    }

    public void push(StackElem o) throws Exception {
        if (top == st.length)
            throw new Exception("栈满");
        else
            st[++top] = o;
    }

    public StackElem pop() throws Exception {
        if (top == -1)
            throw new Exception("栈空");
        else return st[top--];
    }

    public int length() {
        return top + 1;
    }
}

//class Solution {
//    public ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode next = cur.next;
//            pre = cur.next;
//            cur = next;
//        }
//        return pre;
//    }
}