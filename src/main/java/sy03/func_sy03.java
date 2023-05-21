package sy03;

import java.util.Scanner;

public class func_sy03 {
    public func_sy03() throws Exception {
        SqStack Sq = new SqStack(100);
        LinkStack Sl = new LinkStack();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入栈的长度");
        int n = sc.nextInt();
        System.out.println("请输入各元素值");
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            Sq.push(x);
            Sl.push(x);
        }
        System.out.println("建立的顺序栈中的元素序列为（栈顶到栈底）");
        Sq.display();
        System.out.println("\n建立的链栈中的元素序列为（栈顶到栈底）");
        Sl.display();
        System.out.println("请输入待插入元素e");
        int e = sc.nextInt();
        Sq.push(e);
        Sl.push(e);
        System.out.println("建立的顺序栈中的元素序列为（栈顶到栈底）");
        Sq.display();
        System.out.println("\n建立的链栈中的元素序列为（栈顶到栈底）");
        Sl.display();
        System.out.println("删除栈顶元素之后 顺序栈的元素序列");
        Sq.pop();
        Sq.display();
        System.out.println("\n删除栈顶元素之后 链栈的元素序列");
        Sl.pop();
        Sl.display();

    }
}
