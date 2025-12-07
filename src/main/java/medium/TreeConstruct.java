package medium;

import java.util.HashMap;
import java.util.Map;

public class TreeConstruct {
    private Map<Integer, Integer> inorderIndexMap;
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        preorderIndex = 0;

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        // The next root is at preorderIndex
        int rootVal = preorder[preorderIndex];
        preorderIndex++;
        TreeNode root = new TreeNode(rootVal);

        // Position of this root in inorder
        int inorderIndex = inorderIndexMap.get(rootVal);

        // Build left and right subtrees
        root.left  = build(preorder, left, inorderIndex - 1);
        root.right = build(preorder, inorderIndex + 1, right);

        return root;
    }
}
