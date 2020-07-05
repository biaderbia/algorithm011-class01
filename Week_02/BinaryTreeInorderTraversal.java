
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        root.right = second;
        TreeNode third = new TreeNode(3);
        second.left = third;
        List<Integer> result = solution.inorderTraversal(root);
        System.out.println(result);
    }

  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.empty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    TreeNode node = stack.pop();
                    list.add(node.val);
                    root = node.right;
                }
            }
            return list;
        }
    }

}
