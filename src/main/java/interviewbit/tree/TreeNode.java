package interviewbit.tree;

import java.util.List;

public class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    /**
     * @param treeNode
     * @param data
     * @param dir      --> true for left, false for right
     * @param <M>
     */
    public <M> TreeNode<M> insert(TreeNode<M> treeNode, M data, boolean dir) {
        if (treeNode == null) {
            treeNode = new TreeNode<>();
            treeNode.data = data;
        } else {
            if (dir) {
                treeNode.left = new TreeNode<>();
                treeNode.left.data = data;
            } else {
                treeNode.right = new TreeNode<>();
                treeNode.right.data = data;
            }
        }
        return treeNode;
    }

    public <M> TreeNode<M> insert(List<M> dataList) {
        TreeNode<M> treeNode = new TreeNode<>();
        treeNode.data = dataList.get(0);
        boolean dir = true;
        for (int i = 0; i < dataList.size(); i++) {
            M left;
            M right;
            try {
                left = dataList.get(2 * i + 1);
                right = dataList.get(2 * i + 2);
                treeNode = insert(treeNode,
                                  left,
                                  true);
                treeNode = insert(treeNode,
                                  right,
                                  false);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return null;
        //dataList.stream().forEach();
    }
}
