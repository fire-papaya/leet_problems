package medium;

import java.util.HashMap;
import java.util.Map;

public class TreeConstruct2 {
    Map<Integer, Integer> indexMap = new HashMap<>();
    int postorderIndex = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return recursiveBuild(postorder, 0, inorder.length - 1);
    }

    private TreeNode recursiveBuild(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootValue = postorder[postorderIndex];
        postorderIndex--;
        TreeNode root = new TreeNode(rootValue);

        root.right = recursiveBuild(postorder, indexMap.get(rootValue) + 1, right);
        root.left = recursiveBuild(postorder, left, indexMap.get(rootValue) - 1);

        return root;
    }
}
