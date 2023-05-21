package sy02;

import sy01.Ilist;

import java.util.Scanner;

public class LinkList implements Ilist {
    public Node head;

    public LinkList() {
        head = new Node();
    }

    public LinkList(int n, boolean Order) throws Exception {  //建立一个长度为n的单链表
        this();
        if (Order)
            create1(n);    //尾插法
        else
            create2(n);    //头插法
    }

    //头插法
    public void create2(int n) throws Exception {
        System.out.println("请输入" + n + "个元素");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            insert(0, scanner.next());
        }
    }

    //尾插法
    public void create1(int n) throws Exception {
        System.out.println("请输入" + n + "个元素");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            insert(length(), scanner.next());
        }
    }

    @Override
    //清空列表
    public void clear() {
        head.setData(null);
        head.setNext(null);
    }

    @Override
    //判断带头结点的单链表是否为空
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    @Override
    //求带头结点的单链表的长度
    public int length() {

        Node p = head.getNext();
        int length = 0;

        while (p != null) {
            p = p.getNext();
            length++;
        }

        return length;
    }


    @Override
    public Object get(int i) throws Exception {
        Node p = head;
        int j = 0;
        while (p != null && j < i) {
            p = p.getNext();
            j++;
        }
        if (j > i || p == null)
            throw new Exception("第" + i + "个元素不存在");
        return p.getData();
    }

    @Override
    public void insert(int i, Object x) throws Exception {
        Node p = head;
        int j = -1;
        while (p != null && j < i - 1) {
            p = p.getNext();
            ++j;
        }
        if (j > i - 1 || p == null)
            throw new Exception("插入的位置不合法");
        Node s = new Node(x);
        s.setNext(p.getNext());
        p.setNext(s);
    }

    @Override
    public void remove(int i) throws Exception {
        Node p = head; //初始化指针p，指向头节点
        int j = -1; //计数器
        while (p.getNext() != null && j < i - 1) {
            p = p.getNext();
            ++j;
        }
        if (j > i - 1 || p.getNext() == null)
            throw new Exception("删除位置不合法");
        p.setNext(p.getNext().getNext());
    }

    @Override
    public void display() {
        Node node = head.getNext();
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
        System.out.println();
    }

    @Override
    public int indexOf(Object x) throws Exception {
        Node p = head.getNext();
        int j = 0;
        //开始遍历表
        while (p != null && !p.getData().equals(x)) {
            p = p.getNext();
            j++;
        }
        if (p != null)
            return j;
        else
            throw new Exception("没有找到该元素");
    }
}






















