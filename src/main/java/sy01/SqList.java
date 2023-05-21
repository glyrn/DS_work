package sy01;

public class SqList implements Ilist {

    private Object[] listElem;//线性表的实际占有空间
    //private student[] listElem;
    private int curlen;//线性表的实际长度

    //线性表的构造函数
    public SqList(int maxSize) {
        curlen = 0;//将线性表的初始长度设为0
        listElem = new Object[maxSize];//初始化线性表的占用空间
    }

    public int getCurlen() {
        return curlen;
    }

    public Object[] getListElem() {
        return listElem;
    }

    @Override
    public void clear() {
        curlen = 0; //设置线性表的当前长度为0
    }

    @Override
    public boolean isEmpty() {
        return curlen == 0;
    }

    @Override
    public int length() {
        return curlen;
    }

    @Override
    public Object get(int i) throws Exception {
        if (i < 0 || i > curlen - 1)
            throw new Exception("第" + i + "个元素不存在");
        return listElem[i];
    }

    //插入算法 将数据填到第i个位置，并将之后的数据全部往后移一个
    @Override
    public void insert(int i, Object x) throws Exception {
        if (curlen == listElem.length)
            throw new Exception("顺序表已经满了");
        if (i < 0 || i > curlen)//因为在线性表的最后一个元素 的索引是curlen-1，可以在curlen - 1处再次添加元素
            throw new Exception("插入位置不合法");
        for (int j = curlen; j > i; j--) {
            listElem[j] = listElem[j - 1];
        }
        listElem[i] = x;
        curlen++;
    }

    //删除函数
    @Override
    public void remove(int i) throws Exception {
        if (i < 0 || i > curlen - 1)
            throw new Exception("删除的位置不合法");
        for (int j = i; j < curlen - 1; j++) {
            listElem[j] = listElem[j + 1];
        }
        curlen--;
    }

    @Override
    public int indexOf(Object x) {
        int j = 0;
        while (j < curlen && !listElem[j].equals(x)) {
            j++;
        }
        if (j < curlen) {
            return j;
        } else return -1;
    }

    @Override
//    public void display() {
//        System.out.println("下面输出顺序表：");
//        System.out.print("| ");
//        for (int i = 0; i < curlen; i ++) {
//
//            System.out.print( listElem[i] + " | ");
//        }
//        System.out.println();
//    }
    //这个display()函数是单独对于学生信息管理系统的重载函数
    public void display() throws Exception {
        System.out.println("下面输出顺序表：");
        for (int i = 0; i < curlen; i++) {
            student s = (student) get(i);
            displayStu(s);
        }
        System.out.println();
    }

    public void displayStu(student stu) {
        System.out.println("学号：" + stu.stuNum + " 姓名：" + stu.name + " 性别：" + stu.sex
                + " 电话号码：" + stu.telNum + " 地址：" + stu.address);
    }
}
