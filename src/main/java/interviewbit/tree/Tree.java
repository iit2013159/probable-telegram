package interviewbit.tree;

import java.util.List;

public class Tree<T> {
    T data;
    Tree<T> left;
    Tree<T> right;

    /**
     * @param tree
     * @param data
     * @param dir  --> true for left, false for right
     * @param <M>
     */
    public <M> Tree<M> insert(Tree<M> tree, M data, boolean dir) {
        if (tree == null) {
            tree = new Tree<>();
            tree.data = data;
        } else {
            if (dir) {
                tree.left = new Tree<>();
                tree.left.data = data;
            } else {
                tree.right = new Tree<>();
                tree.right.data = data;
            }
        }
        return tree;
    }

    public <M> Tree<M> insert(List<M> dataList) {
        Tree<M> tree = new Tree<>();
        tree.data = dataList.get(0);
        boolean dir = true;
        for (int i = 0; i < dataList.size(); i++) {
            M left;
            M right;
            try {
                left = dataList.get(2 * i + 1);
                right = dataList.get(2 * i + 2);
                tree = insert(tree, left, true);
                tree = insert(tree, right, false);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return null;
        //dataList.stream().forEach();
    }
}
