class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> sumPath = new Stack<>();

        path.push(root);
        sumPath.push(root.val);

        while (!path.isEmpty()) {

            TreeNode temp = path.pop();
            int tempVal = sumPath.pop();

            // Check if leaf node and sum is equal
            if (temp.left == null && temp.right == null && tempVal == sum) {
                return true;
            }

            // Right child
            if (temp.right != null) {
                path.push(temp.right);
                sumPath.push(temp.right.val + tempVal);
            }

            // Left child
            if (temp.left != null) {
                path.push(temp.left);
                sumPath.push(temp.left.val + tempVal);
            }
        }

        return false;
    }
}