package solution;
/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;

/**
 * @author tianming
 */
public class BinaryTree {

    public static void main(String[] args) {

    }
    public boolean isValidBST(TreeNode root) {
        if ((root == null) ){
            return true;
        }
        return isValidBST(root.left, null, null) ;

    }

    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return true;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<Integer> integers = new ArrayList<>();
        integers.addAll(inorderTraversal(root.left));
        integers.add(root.val);
        integers.addAll(inorderTraversal(root.right));
        return integers;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        if (root == null){
            return nums;
        }
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while (curr != null && !stack.empty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            nums.add(curr.val);
            curr = curr.right;
        }
        return nums;
    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


