package sy05;

import java.util.*;

public class BiTree {
    private static int index = 0;
    private BiTreeNode root;

    public BiTree() {
        this.root = null;
    }

    public BiTree(BiTreeNode root) {
        this.root = root;
    }

    //由表明空子树的先庚遍历序列创建一颗二叉树的算法
    public BiTree(String preStr) {
        char c = preStr.charAt(index++);
        if (c != '#') {
            root = new BiTreeNode(c);
            root.setLchild(new BiTree(preStr).root);
            root.setRchild(new BiTree(preStr).root);
        } else {
            root = null;
        }
    }

    //由先根序列和中跟序列创建一颗二叉树的算法
    public BiTree(String preOrder, String inOrder, int preIndex, int inIndex, int count) {
        if (count > 0) {
            char r = preOrder.charAt(preIndex);
            int i = 0;
            for (; i < count; i++) {
                if (r == inOrder.charAt(i + inIndex)) {
                    break;
                }
            }
            root = new BiTreeNode(r);
            root.setLchild(new BiTree(preOrder, inOrder, preIndex + 1, inIndex, i).root);
            root.setRchild(new BiTree(preOrder, inOrder, preIndex + i + 1, inIndex + i + 1, count - i - 1).root);
        }
    }

    //求二叉树的镜像的递归算法
    private static void exchange2(BiTreeNode T) {
        if (T != null) {
            if (T.getLchild() != null || T.getRchild() != null) {
                BiTreeNode p = (BiTreeNode) T.getLchild();
                T.setLchild(T.getRchild());
                T.setRchild(p);
            }
        }
        exchange2(T.getLchild());
        exchange2(T.getRchild());
    }

    //求二叉树镜像的非递归算法
    private static void exchange1(BiTreeNode T) {
        Stack<Object> s = new Stack<Object>();
        if (T != null) {
            s.push(T);
            do {
                T = (BiTreeNode) s.pop();
                if (T.getLchild() != null || T.getRchild() != null) {
                    BiTreeNode p = (BiTreeNode) T.getLchild();
                    T.setLchild(T.getRchild());
                    T.setRchild(p);
                }
                if (T.getLchild() != null) {
                    s.push(T.getLchild());
                }
                if (T.getRchild() != null) {
                    s.push(T.getRchild());
                }
            } while (!s.isEmpty());
        }
    }

    public BiTreeNode getRoot() {
        return root;
    }

    public void setRoot(BiTreeNode root) {
        this.root = root;
    }

    //先根遍历的递归算法
    public void preRootTraverse(BiTreeNode T) {
        if (T != null) {
            System.out.print(T.data);
            preRootTraverse(T.lchild);
            preRootTraverse(T.rchild);
        }
    }

    //中根遍历的递归算法
    public void inRootTraverse(BiTreeNode T) {
        if (T != null) {
            inRootTraverse(T.lchild);
            System.out.print(T.data);
            inRootTraverse(T.rchild);
        }
    }

    //后根遍历的递归算法
    public void postRootTraverse(BiTreeNode T) {
        if (T != null) {
            inRootTraverse(T.lchild);
            inRootTraverse(T.rchild);
            System.out.print(T.data);
        }
    }

    //先根遍历的非递归算法
    public void preRootTraverse() {
        BiTreeNode T = root;
        if (T != null) {
            Stack<Object> S = new Stack<Object>();
            S.push(T);
            while (!S.isEmpty()) {
                T = (BiTreeNode) S.pop();//移除栈顶节点，返回值
                System.out.print(T.data);
                while (T != null) {
                    if (T.lchild != null) {
                        System.out.print(T.lchild.data);
                    } else if (T.rchild != null) {
                        S.push(T.rchild);
                    }
                    T = T.lchild;
                }
            }

        }
    }
    //层次遍历二叉树的非递归算法

    //中根遍历的非递归算法
    public void inRootTraverse() {
        BiTreeNode T = root;
        if (T != null) {
            Stack<Object> S = new Stack<Object>();
            S.push(T);
            while (!S.isEmpty()) {
                while (S.peek() != null) {
                    S.push(((BiTreeNode) S.peek()).lchild);
                }
                S.pop();
                if (!S.isEmpty()) {
                    T = (BiTreeNode) S.pop();
                    System.out.print(T.data);
                    S.push(T.rchild);
                }
            }
        }
    }

    //后根遍历的非递归算法
    public void psetRootTraverse() {
        BiTreeNode T = root;
        if (T != null) {
            Stack<Object> S = new Stack<Object>();
            S.push(T);
            Boolean flag;
            BiTreeNode p = null;
            while (!S.isEmpty()) {
                while (S.peek() != null) {
                    S.push(((BiTreeNode) S.peek()).lchild);
                }
                S.pop();
                while (!S.isEmpty()) {
                    T = (BiTreeNode) S.peek();
                    if (T.rchild == null || T == p) {
                        System.out.print(T.data);
                        S.pop();
                        p = T;
                        flag = true;
                    } else {
                        S.push(T.rchild);
                        flag = false;
                    }
                    if (!flag) {
                        break;
                    }
                }
            }
        }
    }

    /**
     * 创建一个队列，将根节点入队。
     * 循环执行以下步骤，直到队列为空：
     * a. 出队一个节点，并访问该节点。
     * b. 如果该节点有左子节点，将左子节点入队。
     * c. 如果该节点有右子节点，将右子节点入队。
     */
    public void levelTraverse() {
        BiTreeNode T = root;
        if (T != null) {
            Queue<Object> L = new LinkedList<Object>();
            L.offer(T);
            while (!L.isEmpty()) {
                T = (BiTreeNode) L.poll();
                System.out.print(T.data);
                if (T.lchild != null) {
                    L.offer(T.lchild);
                } else if (T.rchild != null) {
                    L.offer(T.rchild);
                }
            }
        }
    }

    //统计二叉树节点个数的递归算法
    public int countNode(BiTreeNode T) {
        int count = 0;
        if (T != null) {
            count++;
            count += countNode(T.getLchild());
            count += countNode(T.getRchild());
        }
        return count;
    }

    //统计二叉树叶结点个数的递归算法
    public int countLeafNode(BiTreeNode T) {
        int count = 0;
        if (T != null) {
            if (T.getLchild() == null && T.getRchild() == null) {
                count++;
            } else {
                count += countLeafNode(T.getLchild());
                count += countLeafNode(T.getRchild());
            }
        }
        return count;
    }

    //寻路算法的递归实现

    /**
     * 如果根结点为 null，或者根结点为目标结点 p，则将根结点添加到路径中，并返回 true。
     * 递归遍历左子树，如果左子树中存在目标结点 p，则将根结点添加到路径中，并返回 true。
     * 递归遍历右子树，如果右子树中存在目标结点 p，则将根结点添加到路径中，并返回 true。
     * 如果左右子树中均不存在目标结点 p，则从路径中删除根结点，并返回 false。
     */
    public List<BiTreeNode> getPath(BiTreeNode root, BiTreeNode p) {
        List<BiTreeNode> path = new ArrayList<BiTreeNode>();
        if (root == null || p == null) {
            return path;
        }
        if (root == p) {
            path.add(root);
            return path;
        }
        if (getPath(root.getLchild(), p, path) || getPath(root.getRchild(), p, path)) {
            path.add(root);
            return path;
        }
        return path;
    }

    private boolean getPath(BiTreeNode root, BiTreeNode p, List<BiTreeNode> path) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            path.add(p);
            return true;
        }
        if (getPath(root.getLchild(), p, path) || getPath(root.getRchild(), p, path)) {
            path.add(root);
            return true;
        }
        return false;
    }
}
