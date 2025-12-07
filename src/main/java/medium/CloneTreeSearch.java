package medium;



public class CloneTreeSearch {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return traverseSimultaneously(original, cloned, target.val);
    }

    private TreeNode traverseSimultaneously (final TreeNode original, final TreeNode cloned, final int value) {
        if (original.val == value)
            return cloned;
        TreeNode result = null;

        if (original.left != null) {
            result = traverseSimultaneously(original.left, cloned.left, value);
        }

        if (result != null)
            return result;

        if (original.right != null)
            result = traverseSimultaneously(original.right, cloned.right, value);

        return result;
    }
}