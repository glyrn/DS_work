package sy03;

public class ackCCL {
    public static int ack(int m, int n) throws Exception {
        StackElem e = new StackElem(m, n);
        Stack s = new Stack(100);
        s.push(e);
        do {
            while (s.getTop().mval != 0) {
                while (s.getTop().nval != 0) {
                    e = new StackElem(s.getTop().mval, s.getTop().nval);
                    s.push(e);
                }
            }
            if (!s.isEmpty()) {
                e = s.pop();
                s.setTop(s.getTop().mval - 1, e.nval + 1);
            }
        } while (s.length() != 1 || s.getTop().mval != 0);
        return s.getTop().nval + 1;
    }
}
