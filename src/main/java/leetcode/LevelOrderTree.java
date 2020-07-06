package leetcode;
/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static leetcode.TreeNode.int2dListToString;


public class LevelOrderTree {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls;
        int[] a = {1, 2, 2};
        Queue<TreeNode> q = new LinkedList();
        TreeNode id = new TreeNode();
        id.val = -1;
        q.add(id);
        q.add(root);
        List<List<Integer>> li = new ArrayList();
        int level = 0;
        while (q.size() > 1) {
            TreeNode temp = q.poll();
            if (temp == null) {
                return li;
            }
            if (temp.val == -1) {
                level++;
                q.add(temp);
            } else {
                while (li.size() - 1 < level) {
                    li.add(new ArrayList());
                }
                List<Integer> inner = li.get(level);
                if (inner == null) {
                    inner = new ArrayList();
                }
                inner.add(temp.val);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        li.remove(0);

        return li;
    }
}

 class LevelOrderMainClass {



    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = TreeNode.stringToTreeNode(line);

            List<List<Integer>> ret = new LevelOrderTree().levelOrder(root);

            String out = int2dListToString(ret);

            System.out.print(out);

            //System.out.println(new LevelOrderTree().isValidBST(root));

        }
    }
}
