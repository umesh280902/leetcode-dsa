// 889. Construct Binary Tree from Preorder and Postorder Traversal
// Solved
// Medium
// Topics
// Companies
// Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.

// If there exist multiple answers, you can return any of them.

 

// Example 1:


// Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
// Output: [1,2,3,4,5,6,7]
// Example 2:

// Input: preorder = [1], postorder = [1]
// Output: [1]
 

// Constraints:

// 1 <= preorder.length <= 30
// 1 <= preorder[i] <= preorder.length
// All the values of preorder are unique.
// postorder.length == preorder.length
// 1 <= postorder[i] <= postorder.length
// All the values of postorder are unique.
// It is guaranteed that preorder and postorder are the preorder traversal and postorder traversal of the same binary tree.
public class BinaryTreeUsingPreAndPost {
    class Solution {
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            Stack<TreeNode> nodes = new Stack<>();
            TreeNode root = new TreeNode(preorder[0]);
            nodes.push(root);
            int pre = 1;
            int post = 0;
    
            while (!nodes.isEmpty()) {
                TreeNode current = nodes.peek(); // Use peek() instead of top()
                if (current.val == postorder[post]) {
                    nodes.pop();
                    post++;
                } else {
                    TreeNode newNode = new TreeNode(preorder[pre++]);
                    if (current.left == null) {
                        current.left = newNode;
                    } else {
                        current.right = newNode;
                    }
                    nodes.push(newNode);
                }
            }
            return root;
        }
    }
    
}
