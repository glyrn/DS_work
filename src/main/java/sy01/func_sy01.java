package sy01;

import java.util.Scanner;

public class func_sy01 {
    public func_sy01() throws Exception {

/*
        SqList sqList = new SqList(5);
        //执行插入操作，对表的初始化
        sqList.insert(0, 'a');
        sqList.insert(1, 'b');
        sqList.insert(2, 'c');
        sqList.insert(3, 'd');
        sqList.insert(4, 'e');

        //sqList.insert(5, 'f');
        //执行预览线性表操作
        sqList.display();

        //执行表的查询索引元素操作
        System.out.println(sqList.get(1));

        //执行表的查询元素索引操作
        System.out.println(sqList.indexOf('d'));

        //执行表的删除操作
        sqList.remove(1);
        sqList.insert(1,'b');
        sqList.display();
 */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入顺序表的长度：");
        int n = scanner.nextInt();
        SqList sqList = new SqList(n);

        System.out.println("请输入顺序表中的各个元素的值");
        for (int i = 0; i < n; i++) {
            sqList.insert(i, scanner.next());
        }

        System.out.println("下面将展示顺序表：");
        System.out.println("--------------------------------");
        sqList.display();
        System.out.println("--------------------------------");

        System.out.println("请输入待删除的元素");
        sqList.remove(sqList.indexOf(scanner.next()));
        System.out.println("--------------------------------");
        sqList.display();
        System.out.println("--------------------------------");


        System.out.println("请输入待插入的位置");
        n = scanner.nextInt();
        System.out.println("请输入待插入元素");
        sqList.insert(n, scanner.next());

        System.out.println("下面将展示顺序表：");
        System.out.println("--------------------------------");
        sqList.display();
        System.out.println("--------------------------------");

        System.out.println("请输入待查询的元素：");
        int n1 = sqList.indexOf(scanner.next());
        if (n1 != -1) {
            System.out.println("该元素位于线性表的第" + (n1 + 1) + "个位置");
        } else {
            System.out.println("表中不存在该元素");
        }


    }


}
