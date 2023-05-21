package syo4;

import java.util.Scanner;

public class func_sy04 {
    public func_sy04() throws Exception {
        CircleSqQueue Q1 = new CircleSqQueue(100);
        LinkQueue Q2 = new LinkQueue();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入队列的长度");
        int n = sc.nextInt();
        System.out.println("请输入各元素值");
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            Q1.offer(data);
            Q2.offer(data);
        }
        System.out.println("展示循环顺序队列");
        Q1.display();
        System.out.println();
        System.out.println("展示链队列");
        Q2.display();
        System.out.println();
        System.out.println("请输入带入队的元素");

        int x = sc.nextInt();
        Q1.offer(x);
        System.out.println("展示循环顺序队列");
        Q1.display();
        System.out.println();
        Q2.offer(x);
        System.out.println("展示链队列");
        Q2.display();
        System.out.println();

        Object t1 = Q1.poll();
        Object t2 = Q2.poll();

        if (t1 != null && t2 != null) {
            System.out.println("删除的循环队列的队首元素是" + " " + t1);
            System.out.println("删除的链队列的队首元素是" + " " + t2);

            System.out.println("展示循环顺序队列");
            Q1.display();
            System.out.println();
            System.out.println("展示链队列");
            Q2.display();

        }

    }
}
