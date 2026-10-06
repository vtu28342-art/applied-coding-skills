/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target, path, ans);
        return ans;
    }
    void dfs(TreeNode root, int target, List<Integer> path, List<List<Integer>> ans) {
        if (root == null)
            return;
        List<Integer> newpath = new ArrayList<>(path);
        newpath.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == target)
                ans.add(newpath);
            return;
        }
        int bal = target - root.val;
        dfs(root.left, bal, newpath, ans);
        dfs(root.right, bal, newpath, ans);
    }
}