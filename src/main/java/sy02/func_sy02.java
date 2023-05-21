package sy02;

import java.util.Scanner;

public class func_sy02 {
    public static void creat(LinkList L) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入链表中的各个元素值<输入“结束”即为结束>");
        for (; ; ) {
            String x = scanner.next();
            if (x.equals("结束")) {
                break;
            }
            L.insert(L.length(), x);
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws Exception {
//        Scanner scanner = new Scanner(System.in);
//        LinkList L = new LinkList();
//        func_sy02.creat(L);
//        System.out.println("建立的单链表为：");
//        L.display();
//        System.out.println("请输入待插入的位置");
//        int index = scanner.nextInt() - 1;
//        System.out.println("请输入待插入的元素");
//        String string = scanner.next();
//        L.insert(index, string);
//        System.out.println("插入之后的链表为：");
//        L.display();
//        System.out.println("请输入待删除的元素");
//        L.remove(L.indexOf(scanner.next()));
//        System.out.println("删除之后的链表为：");
//        L.display();
//        System.out.println("输入想查找第几个元素");
//        int i = scanner.nextInt();
//        String s = L.get(i).toString();
//        System.out.println("这个单链表第" + i + "个元素为" + s);
//
//    }
//
//}
