package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import static leetcode.TreeNode.stringToTreeNode;

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

class Solution {
    public int sum(TreeNode root, int sum) {
        if(root == null){
            return sum;
        }
        if(root.left != null && root.right != null) {
            return sum(root.left,sum*10 + root.left.val) + sum(root.right,sum*10+root.right.val);
        }else if(root.left == null && root.right != null){
            return sum(root.right,sum*10+root.right.val);
        }else if(root.left != null && root.right == null){
            return sum(root.left,sum*10+root.left.val);
        }
        return sum;
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sum(root,root.val);
    }
}

class SumMainClass {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new Solution().sumNumbers(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}