package easy;

import java.util.ArrayList;
import java.util.List;

public class BTInorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        var list = new ArrayList<Integer>();

        if (root == null) return list;

        traverse(list, root);

        return list;
    }

    void traverse(List<Integer> list, TreeNode root) {
        if (root.left != null) {
            traverse(list, root.left);
        }

        list.add(root.val);

        if (root.right != null) {
            traverse(list, root.right);
        }
    }
}
