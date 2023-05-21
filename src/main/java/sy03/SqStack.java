package sy03;

// 顺序栈 顺序存储方式
public class SqStack implements IStack {
    private Object[] stackElem;
    private int top;

    public SqStack(int maxSize) {
        top = 0;
        stackElem = new Object[maxSize];
    }

    //清空
    @Override
    public void clear() {
        top = 0;
    }

    //判空
    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    //显示长度
    @Override
    public int length() {
        return top;
    }

    //显示栈顶元素
    @Override
    public Object peek() {
        if (!isEmpty())
            return stackElem[top - 1];
        else
            return null;
    }

    //压栈
    @Override
    public void push(Object x) throws Exception {
        if (top == stackElem.length) //栈满
            throw new Exception("栈已满");
        else
            stackElem[top++] = x;
    }

    //出栈
    @Override
    public Object pop() {
        if (isEmpty())
            return null;
        else
            return stackElem[--top];
    }
    //遍历

    @Override
    public void display() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.print(stackElem[i].toString() + " "); //输出
        }
    }
}