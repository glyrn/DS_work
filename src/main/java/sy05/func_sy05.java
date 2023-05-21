package sy05;

import java.util.Scanner;

public class func_sy05 {
    public func_sy05() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入二叉树的表明了空子树的先跟遍历序列");
        String str = scanner.next();
        BiTree T = new BiTree(str);
        while (true) {
            System.out.println("---------------------------------------------------");
            System.out.println("1 -- 先跟遍历     2 -- 中跟遍历         3 -- 后根遍历");
            System.out.println("4 -- 统计结点个数  5 -- 统计叶节点个数    6 -- 退出");
            System.out.println("---------------------------------------------------");
            System.out.println("请选择输入<1 - 6>");
            int i = scanner.nextInt();
            switch (i) {
                case 1:
                    System.out.print("先跟序列为：");
                    T.preRootTraverse(T.getRoot());
                    System.out.println();
                    break;
                case 2:
                    System.out.print("中跟序列为：");
                    T.inRootTraverse(T.getRoot());
                    System.out.println();
                    break;
                case 3:
                    System.out.print("后跟序列为：");
                    T.postRootTraverse(T.getRoot());
                    System.out.println();
                    break;
                case 4:
                    System.out.println("二叉树的结点个数为：" + T.countNode(T.getRoot()));
                    break;
                case 5:
                    System.out.println("二叉树的叶结点个数为：" + T.countLeafNode(T.getRoot()));
                    break;
                case 6:
                    return;
                default:
                    break;
            }
        }
    }
}
