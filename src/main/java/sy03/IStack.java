package sy03;

public interface IStack {
    public void clear();//栈的置空操作

    public boolean isEmpty(); //栈的判空操作

    public int length(); //求栈的长度操作

    public Object peek(); //取栈顶元素的操作

    public void push(Object x) throws Exception; //入栈操作

    public Object pop(); //出栈操作

    public void display(); //输出所有元素
}