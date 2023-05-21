//package sy05;
//
//
//
//public class BiTree {
//    private BiTreeNode root;   //树的根节点
//    //标明空子树的先根遍历序列建立一棵二叉树
//
//    public BiTree() {                 //构造一棵空树
//        this.root = null;
//    }
//
//    public BiTree(BiTreeNode root) {    //构造一棵树
//        this.root = root;
//    }
//
//    //由先根遍历和中根遍历序列建立一棵二叉树的算法
//    public BiTree(String preOrder, String inOrder, int preIndex, int count) {}
//
//    //由标明空子树的先根遍历序列创建一棵二叉树的算法
//    private static int index = 0;   //记录preStr的索引值
//    public BiTree(String preStr) {
//        char c = preStr.charAt(index ++);
//        if (c != '#') {
//            root = new BiTreeNode(c);
//            root.set
//        }
//    }
//
//    //先跟遍历二叉树的递归算法
//    public void preRootTraverse(BiTreeNode T) {
//        if (T != null) {
//            System.out.print(T.data);  //访问根节点
//            preRootTraverse(T.lchild);
//            preRootTraverse(T.rchild);
//        }
//    }
//
//    //先根遍历二叉树的非递归算法
//    public void preRootTraverse() {
//        BiTreeNode T = root;
//        if (T != null) {
//            LinkStack S = new LinkStack();
//            S.push(T);
//            //创建栈 把根节点压入栈中
//            while(!S.isEmpty()) {
//                T = (BiTreeNode) S.pop();
//                //弹出栈的第一个元素
//                System.out.print(T.data); //读取根数据
//                while (T != null) { //先遍历左子树
//                    if (T.lchild != null) {
//                        System.out.print(T.lchild.data);
//                    }
//                    if (T.rchild != null) {
//                        //由于需要先遍历左子树 所以右子树需要等所有的左子树遍历完成之后 才轮到右子树 此时右子树先入栈 刚好左子树全部遍历完成之后 最后入栈的右子树刚好最先出栈
//                        S.push(T.rchild);
//                    }
//                    //将指针指向左子树的根，之前遍历的刚好当做根的遍历 此处当做叶子遍历
//                    T = T.lchild;
//                }
//            }
//        }
//    }
//
//    //中根遍历二叉树的递归算法
//    public void inRootTraverse(BiTreeNode T) {
//        if (T != null) {
//            inRootTraverse(T.rchild);
//            System.out.print(T.data);
//            inRootTraverse(T.rchild);
//        }
//    }
//
//    //中根遍历二叉树的非递归算法
//    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    public void inRootTraverse() {//##
//        BiTreeNode T = root;
//        if (T != null) {
//            LinkStack S = new LinkStack(); //构造链栈
//            S.push(T); //根节点入栈
//            while (!S.isEmpty()) {
//                while (S.peek() != null) {  //栈非空的情况下，将栈顶节点的左孩子相继入栈
//                    S.push((((BiTreeNode)S.peek()).lchild));
//                }
//                S.pop();//把最后的一个空节点退栈
//                if (!S.isEmpty()) {
//                    T = (BiTreeNode) S.pop();
//                    System.out.println(T.data);
//                    S.push(T.rchild);
//                }
//            }
//        }
//    }
//
//    //后跟遍历二叉树的递归算法
//    public void postRootTraverse(BiTreeNode T) {
//        if (T != null) {
//            preRootTraverse(T.lchild);
//            preRootTraverse(T.rchild);
//            System.out.print(T.data);
//        }
//    }
//
//    //后根遍历二叉树的非递归算法
//    public void postRootTraverse() {
//        BiTreeNode T = root;
//        if (T != null) {
//            LinkStack S = new LinkStack(); //构造栈链
//            S.push(T); //根节点入栈
//            Boolean flag; //访问标记
//            BiTreeNode p = null; //p指向刚刚被访问的节点
//            while(!S.isEmpty()) {
//                while(S.peek() != null) {
//                    S.push(((BiTreeNode) S.peek()).lchild); //将栈顶的左孩子入栈
//                }
//                S.pop();
//                while (!S.isEmpty()) {
//                    T = (BiTreeNode) S.peek();
//                    if (T.rchild == null || T.rchild == p) {
//                        System.out.print(T.data);
//                        S.pop();
//                        p = T;
//                        flag = true;
//                    }else {
//                        S.push(T.rchild);
//                        flag = false;
//                    }
//                    if (!flag) {
//                        break;
//                    }
//                }
//            }
//
//        }
//    }
//
//    //层次遍历二叉树的非递归算法（从左往右）
//    public void levelTraverse() {
//        BiTreeNode T = root;
//        if (T != null) {
//            LinkQueue L = new LinkQueue();
//            L.offer(L);
//            System.out.print(T.data);
//            if (T.lchild != null) {
//                L.offer(T.lchild);
//            }
//            if (T.rchild != null){
//                L.offer(T.rchild);
//            }
//        }
//    }
//
//    public BiTreeNode getRoot() {
//        return root;
//    }
//
//    public void setRoot(BiTreeNode root) {
//        this.root = root;
//    }
//
//}
//class LinkStack <T> {
//    protected LinkNode<T> top;//声明top指针
//
//    public LinkStack() {
//        //栈的初始化，初始化一个空栈
//        LinkNode<T> first = new LinkNode<T>();//定义一个空节点
//        top = first;//把空节点放在最开头
//    }
//
//    public void push(T element) {//用于表达进栈的方法
//        LinkNode<T> s = new LinkNode<T>(element);//用s来代表要输入的元素
//        s.next = top;//让新进入的元素指向它的上一位元素
//        top = s;//top指针指到s上面
//    }
//
//    public T pop() {//用于表达出栈的方法
//        if (isEmpty())//先判断是否空栈,如果是空栈就抛出异常
//            throw new RuntimeException("栈空");
//        T top_node = top.data;//定义一个记录top指针指向元素的变量
//        top = top.next;//出栈后top指针指向下一个要出栈位置的元素
//        return top_node;//返回出栈时读取的元素
//    }
//    public T peek() {
//        if (isEmpty())//先判断是否空栈,如果是空栈就抛出异常
//            throw new RuntimeException("栈空");
//        return top.data;
//    }
//
//    public boolean isEmpty() {//用于判断栈是否为空的方法的方法
//        if (top == null)//如果top指针指向null的话
//            return true;//说明栈空
//        else
//            return false;//否则就是栈非空
//    }
//
//    public T getTop(){//用于表达展示当前的指针指向元素的方法
//        if(isEmpty())//先判断是否空栈,如果是空栈就抛出异常
//            throw new RuntimeException("栈空");
//        T top_node = top.data;//定义一个记录top指针指向元素的变量
//        return top_node;//返回top指向的元素
//    }
//
//    public void display() {//用于展示当前链栈的方法
//        LinkNode<T> a = top;//定义此时的a代替top指针
//        while (a.next !=null){//当a的引用域不为null时
//            System.out.print(a.data+"\n");//输出此时a的数据域
//            a = a.next;//往下循环a让元素一个一个轮流展示
//        }
//    }
//}
//class LinkNode <T> {
//    public T data;//声明data
//    public LinkNode<T> next;//声明next
//    public LinkNode(T i){//定义有参构造函数
//        this.data = i;
//        this.next = null;
//    }
//    public LinkNode(){//定义无参构造函数
//        this.data = null;
//        this.next = null;
//    }
//
//}}