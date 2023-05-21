package sy05;

public class BiTreeNode {
    public Object data;
    public BiTreeNode lchild, rchild;

    //构造一个空节点
    public BiTreeNode() {
        this(null);
    }

    //构造一个左右孩子域为空的二叉树
    public BiTreeNode(Object data) {
        this.data = data;
        this.lchild = null;
        this.rchild = null;
    }

    //构造一个数据域和左右孩子域都不为空的二叉树
    public BiTreeNode(Object data, BiTreeNode lchild, BiTreeNode rchild) {
        this.data = data;
        this.lchild = lchild;
        this.rchild = rchild;
    }

    public BiTreeNode getLchild() {
        return lchild;
    }

    public void setLchild(BiTreeNode lchild) {
        this.lchild = lchild;
    }

    public BiTreeNode getRchild() {
        return rchild;
    }

    public void setRchild(BiTreeNode rchild) {
        this.rchild = rchild;
    }
}